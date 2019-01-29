package com.github.andrei1993ak.mentoring.daggertaskkazlouski.network

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.RandomTextResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RandomTextApi {

    @GET("lorem/ul-{limit}")
    fun getRandomText(@Path("limit") limit: Int): Single<RandomTextResponse>
}