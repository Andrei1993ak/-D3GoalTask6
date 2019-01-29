package com.github.andrei1993ak.mentoring.daggertaskkazlouski.repository

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.Image
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.RandomTextResponse
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.User
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.network.ImagesApi
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.network.RandomTextApi
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.utils.TEXT_API_PARSING_REGEX
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.utils.USER_COUNT
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import java.util.*
import java.util.regex.Pattern

class UserRepository(private val imagesApi: ImagesApi, private val randomTextApi: RandomTextApi) {

    fun getUsers(): Single<List<User>> {
        val imagesSingle = getImagesObservable()
        val descriptionObservable = getDescriptionObservable()

        return imagesSingle.zipWith(
            descriptionObservable,
            BiFunction<List<Image>, List<String>, List<User>> { t1, t2 -> getUsers(t1, t2) })
    }

    fun removeUser(userId: Long): Single<Boolean> {
        return Single.fromCallable {
            Thread.sleep(1000L)
            true
        }
    }

    private fun getImagesObservable(): Single<List<Image>> = imagesApi.getImages(USER_COUNT)

    private fun getDescriptionObservable(): Single<List<String>> {
        return randomTextApi.getRandomText(USER_COUNT)
            .flatMap { getStrings(it) }
    }

    private fun getStrings(response: RandomTextResponse): Single<List<String>> {
        val pattern = Pattern.compile(TEXT_API_PARSING_REGEX)
        val matcher = pattern.matcher(response.text_out)

        val list = ArrayList<String>()
        var i = 0

        while (matcher.find(i)) {
            val element = matcher.group(1)
            i += element.length

            list.add(element.subSequence(4, element.length - 5).toString())
        }

        return Single.just(list)
    }

    private fun getUsers(imagesList: List<Image>?, descriptionsList: List<String>?): List<User> {
        return if (imagesList == null || descriptionsList == null || imagesList.size != descriptionsList.size) {
            Collections.emptyList()
        } else {
            val users = ArrayList<User>(imagesList.size)

            for ((index, value) in imagesList.withIndex()) {
                users.add(User(index.toLong(), descriptionsList[index], value.url))
            }

            users
        }
    }
}