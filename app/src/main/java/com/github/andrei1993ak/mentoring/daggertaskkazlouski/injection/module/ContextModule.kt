package com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module

import android.app.Application
import android.content.Context
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.BaseView
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
@Suppress("unused")
object ContextModule {

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}