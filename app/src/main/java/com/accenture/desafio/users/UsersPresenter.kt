package com.accenture.desafio.users

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import com.accenture.desafio.users.entity.UserData


class UsersPresenter(
    private val view: UserContract.UserPresenterOutput,
    private val context: Activity,
    private val liveDateUser: MutableLiveData<MutableList<UserDataBind>>
) : UserContract.UserPresenterInput, UserContract.UserInteractorOutput {

    var interactor: UserContract.UserInteractorInput = UserInteractor(context, this)


    override fun startUsers() {
        interactor.startUser()
    }

    override fun returnUser(result: UserData) {
        liveDateUser.postValue(result.results.sortedBy {
            it.name
        }.map {
            UserDataBind().apply {
                id = it.id
                name = it.name
                username = it.username
                img = it.img

            }
        }.toMutableList())
    }

    override fun returnError(error: String) {
        view.returnError(error)
    }
}


