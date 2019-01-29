package com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.network

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.network.RandomTextApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
object RandomTextApiModule {

    private const val BASE_URL: String = "http://www.randomtext.me/api/"

    /**
     * Provides the Post service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Post service implementati.on.
     */
    @Provides
    @Reusable
    @JvmStatic
    @Named("RandomTextApi")
    internal fun provideRandomTextApi(@Named("RandomTextRetrofit") retrofit: Retrofit): RandomTextApi {
        return retrofit.create(RandomTextApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    @Named("RandomTextRetrofit")
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}