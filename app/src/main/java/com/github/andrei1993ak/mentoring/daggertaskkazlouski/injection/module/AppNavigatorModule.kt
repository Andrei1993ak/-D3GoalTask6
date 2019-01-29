package com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.AppNavigator
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object AppNavigatorModule {

    @Provides
    @Reusable
    @JvmStatic
    fun provideAppNavigator() = AppNavigator()
}