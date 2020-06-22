package com.accenture.desafio.character

import com.accenture.desafio.entity.Result
import retrofit2.Response

interface CharacterContract {

    interface CharacterPresenterInput {
        fun startCharacters()
    }

    interface CharacterPresenterOutput {
        fun returnError(error: String)
    }

    interface CharacterInteractorInput {
        fun startCharacters()
    }

    interface CharacterInteractorOutput {
        fun returnCharacters(result: Result)
        fun returnError(error: String)
    }

    interface ICharacterRepository {
        fun characters(success: (currencyLayer: Response<Result?>) -> Unit,
                       failure: (throwable: Throwable) -> Unit)

        fun verifyConnection(): Boolean

        fun messageError(code: String): String
    }
}