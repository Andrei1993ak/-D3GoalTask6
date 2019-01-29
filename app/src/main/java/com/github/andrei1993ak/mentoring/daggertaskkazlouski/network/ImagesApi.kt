package com.github.andrei1993ak.mentoring.daggertaskkazlouski.network

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.Image
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImagesApi {

    @GET("search")
    fun getImages(@Query("limit") limit: Int): Single<List<Image>>
}