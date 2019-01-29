package com.github.andrei1993ak.mentoring.daggertaskkazlouski.base

import android.content.Context
import android.content.Intent
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.User
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.ui.details.UserDetailsActivity
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.utils.USER_EXTRA_KEY

class AppNavigator {
    fun goToDetailPage(user: User, context: Context) {
        val intent = Intent(context, UserDetailsActivity::class.java)
        intent.putExtra(USER_EXTRA_KEY, user)

        context.startActivity(intent)
    }
}
