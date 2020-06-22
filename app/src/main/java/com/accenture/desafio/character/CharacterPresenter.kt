package com.accenture.desafio.character

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import com.accenture.desafio.R
import com.accenture.desafio.entity.Result
import com.accenture.desafio.viewmodel.Character

class CharacterPresenter(
    private val view: CharacterContract.CharacterPresenterOutput,
    private val context: Activity,
    private val liveDateCharacter: MutableLiveData<MutableList<Character>>
) : CharacterContract.CharacterPresenterInput, CharacterContract.CharacterInteractorOutput {

    var interactor:CharacterContract.CharacterInteractorInput = CharacterInteractor(context, this)

    override fun startCharacters() {
        interactor.startCharacters()
    }

    override fun returnCharacters(result: Result) {
        liveDateCharacter.postValue(result.data.results.sortedBy {
            it.name
        }.map {
            Character().apply {
                id = it.id
                name = it.name
                image = "${it.thumbnail.path}.${it.thumbnail.extension}"
                detail = if (it.description.isEmpty()) {
                    context.getString(R.string.not_descript)
                } else {
                    it.description
                }
            }
        }.toMutableList())
    }

    override fun returnError(error: String) {
        view.returnError(error)
    }
}