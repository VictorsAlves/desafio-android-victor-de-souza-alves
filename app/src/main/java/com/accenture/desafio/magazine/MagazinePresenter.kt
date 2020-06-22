package com.accenture.desafio.magazine

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import com.accenture.desafio.R
import com.accenture.desafio.character.CharacterContract
import com.accenture.desafio.character.CharacterInteractor
import com.accenture.desafio.entity.Result
import com.accenture.desafio.utils.MoneyFormact
import com.accenture.desafio.viewmodel.Character
import com.accenture.desafio.viewmodel.Magazine

class MagazinePresenter(
    private val view: MagazineContract.MagazinePresenterOutput,
    private val context: Activity,
    private val liveDateMagazine: MutableLiveData<Magazine>
) : MagazineContract.MagazinePresenterInput, MagazineContract.MagazineInteractorOutput {

     var interactor: MagazineContract.MagazineInteractorInput = MagazineInteractor(context, this)



    override fun startMagazine(id: Int) {
        interactor.startMagazines(id)
    }

    override fun returnMagazines(result: Result) {
        if (!result.data.results.isNullOrEmpty()) {
            val item = result.data.results.sortedBy {
                it.prices.sortedBy { price -> price.price }.last().price
            }.map {
                Magazine().apply {
                    id = it.id
                    title = it.title
                    image = "${it.thumbnail.path}.${it.thumbnail.extension}"
                    price = MoneyFormact.mask(it.prices.sortedBy { price -> price.price }.last().price)
                    detail = if (it.description.isNullOrEmpty()) {
                        context.getString(R.string.not_descript)
                    } else {
                        it.description
                    }
                }
            }.last()
            liveDateMagazine.postValue(item)
        } else {
            view.returnError(context.getString(R.string.list_empty))
        }
    }

    override fun returnError(error: String) {
        view.returnError(error)
    }
}