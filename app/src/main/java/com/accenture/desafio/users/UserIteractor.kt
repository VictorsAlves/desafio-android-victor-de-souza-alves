package com.accenture.desafio.users

import android.app.Activity


class UserInteractor(
    private val context: Activity,
    private val presenter: UserContract.UserInteractorOutput
) : UserContract.UserInteractorInput {
    var iUserRepository: UserContract.IUserRepository = UserRepository(context)

    override fun startUser() {
        if (iUserRepository.verifyConnection()) {
            iUserRepository.users(
                success = {
                    it.body()?.let {
                        presenter.returnUser(it)
                    }
                },
                failure = {
                    presenter.returnError(
                        iUserRepository.messageError("error")
                    )
                })

        } else {
            presenter.returnError(
                iUserRepository.messageError("connect")
            )
        }
    }
}