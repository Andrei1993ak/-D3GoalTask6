package com.github.andrei1993ak.mentoring.daggertaskkazlouski.ui.list

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.BaseView
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.User

interface UsersListView : BaseView {
    fun updateUsers(users: List<User>)

    fun showError(error: String)

    fun showLoading()

    fun removeUser(userId: Long)

    fun hideLoading()
}