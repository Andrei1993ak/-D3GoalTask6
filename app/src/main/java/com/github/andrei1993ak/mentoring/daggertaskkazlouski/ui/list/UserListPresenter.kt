package com.github.andrei1993ak.mentoring.daggertaskkazlouski.ui.list

import android.content.Intent
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.R
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.AppNavigator
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.base.BasePresenter
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.component.DaggerUserListPresenterInjector
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.AppNavigatorModule
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.ContextModule
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.injection.module.network.UserRepositoryModule
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.model.User
import com.github.andrei1993ak.mentoring.daggertaskkazlouski.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserListPresenter(usersListView: UsersListView) : BasePresenter<UsersListView>(usersListView) {

    override fun inject() {
        DaggerUserListPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .userRepositoryModule(UserRepositoryModule)
            .appNavigatorModule(AppNavigatorModule)
            .build()
            .inject(this)
    }

    @Inject
    lateinit var repository: UserRepository

    @Inject
    lateinit var appNavigator: AppNavigator

    private var subscription: Disposable? = null

    override fun onViewCreated(intent: Intent) {
        loadUsers()
    }

    fun onUserItemClicked(user: User) {
        appNavigator.goToDetailPage(user, view.getContext())
    }

    fun onIemSwipedToDelete(userId: Long) {
        view.showLoading()

        subscription =
                repository.removeUser(userId)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        { success ->
                            view.hideLoading()

                            if (success) {
                                view.removeUser(userId)
                            } else {
                                view.showError(view.getContext().getString(R.string.unknown_error))
                            }
                        },
                        { view.showError(view.getContext().getString(R.string.unknown_error)) }
                    )
    }

    private fun loadUsers() {
        view.showLoading()

        subscription =
                repository.getUsers()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        { usersList ->
                            view.hideLoading()
                            view.updateUsers(usersList)
                        },
                        { view.showError(view.getContext().getString(R.string.unknown_error)) }
                    )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}