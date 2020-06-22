package com.accenture.desafio.magazine

import android.app.Activity

class MagazineInteractor(
    private val context: Activity,
    private val presenter: MagazineContract.MagazineInteractorOutput
) : MagazineContract.MagazineInteractorInput {

    val iMagazineRepository: MagazineContract.IMagazineRepository = MagazineRepository(context)

    override fun startMagazines(id: Int) {
        if (iMagazineRepository.verifyConnection()) {
            iMagazineRepository.magazines(id,
                success = {
                    it.body()?.let {
                        if (it.code.equals("200")) {
                            presenter.returnMagazines(it)
                        } else {
                            presenter.returnError(
                                iMagazineRepository.messageError(it.code)
                            )
                        }
                    }
                },
                failure = {
                    presenter.returnError(
                        iMagazineRepository.messageError("error")
                    )
                })
        } else {
            presenter.returnError(
                iMagazineRepository.messageError("connect")
            )
        }
    }

}