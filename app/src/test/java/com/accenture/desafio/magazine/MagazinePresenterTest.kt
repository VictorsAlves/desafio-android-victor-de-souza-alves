package com.accenture.desafio.magazine

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import com.accenture.desafio.entity.Result
import com.accenture.desafio.viewmodel.Character
import com.accenture.desafio.viewmodel.Magazine
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MagazinePresenterTest {

    lateinit var magazinePresenter: MagazinePresenter

    @Mock
    lateinit var iMagazineInteractorInput: MagazineContract.MagazineInteractorInput

    @Mock
    lateinit var iMagazinePresenterOutput: MagazineContract.MagazinePresenterOutput

    @Mock
    lateinit var magazineLiveDate: MutableLiveData<Magazine>

    @Mock
    lateinit var activity: Activity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        magazinePresenter =
            MagazinePresenter(iMagazinePresenterOutput, activity, magazineLiveDate)
        magazinePresenter.interactor = iMagazineInteractorInput
        Assert.assertNotNull(magazinePresenter)
    }

    @Test
    fun startCharacters() {
        magazinePresenter.returnMagazines(Result())
        Mockito.verify(iMagazineInteractorInput, Mockito.times(1))
            .startMagazines(0)
    }

    @Test
    fun returnCharacters() {
        magazinePresenter.returnMagazines(Result())
        Mockito.verify(magazineLiveDate, Mockito.times(1))
            .postValue(Mockito.any())
    }

    @Test
    fun returnError() {
        magazinePresenter.returnError("teste")
        Mockito.verify(iMagazinePresenterOutput, Mockito.times(1))
            .returnError(Mockito.anyString())
    }
}