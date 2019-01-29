package com.github.andrei1993ak.mentoring.daggertaskkazlouski.ui.details

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.R
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.BaseActivity
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.databinding.ActivityDetailBinding
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.User

class UserDetailsActivity : BaseActivity<UserDetailsPresenter>(), UserDetailView {

    override fun updateUser(user: User) {
        binding.user = user
    }

    private lateinit var binding: ActivityDetailBinding

    override fun instantiatePresenter(): UserDetailsPresenter {
        return UserDetailsPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        presenter.onViewCreated(intent)
    }


    override fun onDestroy() {
        super.onDestroy()

        presenter.onViewDestroyed()
    }
}
