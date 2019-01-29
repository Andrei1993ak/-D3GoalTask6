package com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.network

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.network.ImagesApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
object ImagesApiModule {

    private const val BASE_URL: String = "https://api.thecatapi.com/v1/images/"

    @Provides
    @Reusable
    @JvmStatic
    @Named("ImagesApi")
    internal fun provideImagesApi(@Named("ImagesRetrofit") retrofit: Retrofit): ImagesApi {
        return retrofit.create(ImagesApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    @Named("ImagesRetrofit")
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}