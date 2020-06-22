package com.accenture.desafio.character

import android.app.Activity

class CharacterInteractor(
    private val context: Activity,
    private val presenter: CharacterContract.CharacterInteractorOutput
) : CharacterContract.CharacterInteractorInput {
    var icharacterRepository: CharacterContract.ICharacterRepository = CharacterRepository(context)


    override fun startCharacters() {
        if (icharacterRepository.verifyConnection()) {
            icharacterRepository.characters(
                success = {
                    it.body()?.let {
                        if (it.code.equals("200")) {
                            presenter.returnCharacters(it)
                        } else {
                            presenter.returnError(
                                icharacterRepository.messageError(it.code)
                            )
                        }
                    }
                },
                failure = {
                    presenter.returnError(
                        icharacterRepository.messageError("error")
                    )
                })
        } else {
            presenter.returnError(
                icharacterRepository.messageError("connect")
            )
        }
    }

}