package com.accenture.desafio.magazine

import com.accenture.desafio.entity.Result
import retrofit2.Response

interface MagazineContract {

    interface MagazinePresenterInput {
        fun startMagazine(id: Int)
    }

    interface MagazinePresenterOutput {
        fun returnError(error: String)
    }

    interface MagazineInteractorInput {
        fun startMagazines(id: Int)
    }

    interface MagazineInteractorOutput {
        fun returnMagazines(result: Result)
        fun returnError(error: String)
    }

    interface IMagazineRepository {
        fun magazines(
            id: Int,
            success: (currencyLayer: Response<Result?>) -> Unit,
            failure: (throwable: Throwable) -> Unit
        )

        fun verifyConnection(): Boolean

        fun messageError(code: String): String
    }
}