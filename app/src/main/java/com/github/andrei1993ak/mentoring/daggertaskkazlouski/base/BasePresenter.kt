package com.github.andrei1993ak.mentoring.daggertaskkazlouski.base

import android.content.Intent

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    init {
        inject()
    }

    open fun onViewCreated(intent: Intent) {}

    open fun onViewDestroyed() {}

    abstract fun inject()

}