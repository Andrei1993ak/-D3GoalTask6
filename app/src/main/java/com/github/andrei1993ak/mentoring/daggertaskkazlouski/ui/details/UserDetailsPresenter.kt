package com.github.andrei1993ak.mentoring.daggertaskkazlouski.ui.details

import android.content.Intent
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.BasePresenter
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.User
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.utils.USER_EXTRA_KEY

class UserDetailsPresenter(userDetailView: UserDetailView) : BasePresenter<UserDetailView>(userDetailView) {
    override fun inject() {
    }

    override fun onViewCreated(intent: Intent) {
        val user = intent.getParcelableExtra<User>(USER_EXTRA_KEY)
        view.updateUser(user)
    }
}