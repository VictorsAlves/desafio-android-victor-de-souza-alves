package com.accenture.desafio.users

import com.accenture.desafio.entity.Result
import com.accenture.desafio.users.entity.UserData
import retrofit2.Response

interface UserContract {

    interface IUserRepository {

        fun users(
            success: (currencyLayer: Response<UserData?>) -> Unit,
            failure: (throwable: Throwable) -> Unit
        )

        fun verifyConnection(): Boolean

        fun messageError(code: String): String
    }

    interface UserInteractorOutput {
        fun returnUser(result: UserData)
        fun returnError(error: String)
    }

    interface UserInteractorInput {
        fun startUser()
    }

    interface UserPresenterOutput {
        fun returnError(error: String)
    }

    interface UserPresenterInput {
        fun startUsers()
    }
}