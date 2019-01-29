package com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.network

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.network.ImagesApi
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.network.RandomTextApi
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Named

@Module(
    includes = [(ImagesApiModule::class), (RandomTextApiModule::class)]
)
object UserRepositoryModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideUserRepository(
        @Named("ImagesApi") imagesApi: ImagesApi,
        @Named("RandomTextApi") randomTextApi: RandomTextApi
    ) = UserRepository(imagesApi, randomTextApi)
}