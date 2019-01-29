package com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.component

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.BaseView
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.AppNavigatorModule
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.ContextModule
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.network.ImagesApiModule
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.network.RandomTextApiModule
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.network.UserRepositoryModule
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.ui.list.UserListPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(ContextModule::class), (ImagesApiModule::class), (RandomTextApiModule::class), (UserRepositoryModule::class), (AppNavigatorModule::class)])
interface UserListPresenterInjector {
    fun inject(userListPresenter: UserListPresenter)

    @Component.Builder
    interface Builder {
        fun build(): UserListPresenterInjector

        fun contextModule(contextModule: ContextModule): Builder
        fun userRepositoryModule(userRepositoryModule: UserRepositoryModule): Builder
        fun appNavigatorModule(appNavigatorModule: AppNavigatorModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}