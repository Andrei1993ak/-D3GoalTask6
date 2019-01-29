package com.github.andrei1993ak.mentoring.daggertaskkazlouski.ui.details

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.BaseView
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.User

interface UserDetailView : BaseView {
    fun updateUser(user: User)
}