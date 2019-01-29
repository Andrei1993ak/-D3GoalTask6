package com.github.andrei1993ak.mentoring.daggertaskkazlouski.base

import android.content.Intent

/**
 * Base presenter any presenter of the application must extend. It provides initial injections and
 * required methods.
 * @param V the type of the View the presenter is based on
 * @property view the view the presenter is based on
 * @constructor Injects the required dependencies
 */
abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated(intent: Intent) {}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed() {}

    /**
     * Injects the required dependencies
     */
    abstract fun inject()

}