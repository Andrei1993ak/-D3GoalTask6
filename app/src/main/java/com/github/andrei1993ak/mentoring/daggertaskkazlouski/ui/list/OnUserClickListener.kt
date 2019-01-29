package com.github.andrei1993ak.mentoring.daggertaskkazlouski.ui.list

import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.User

interface OnUserClickListener {
    fun onUserClicked(user: User)
}