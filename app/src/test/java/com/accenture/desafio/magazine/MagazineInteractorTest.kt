package com.accenture.desafio.magazine

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import com.accenture.desafio.R
import com.accenture.desafio.entity.Result
import com.accenture.desafio.viewmodel.Character
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MagazineInteractorTest {

    lateinit var magazineInteractor: MagazineInteractor

    @Mock
    lateinit var iMagazineInteractorOutput: MagazineContract.MagazineInteractorOutput

    @Mock
    lateinit var activity: Activity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        magazineInteractor = MagazineInteractor(activity, iMagazineInteractorOutput)
        Assert.assertNotNull(magazineInteractor)
    }

    @Test
    fun startCharacters() {
        Mockito.`when`(activity.getString(R.string.not_connection)).thenReturn("error")
        magazineInteractor.startMagazines(1)
        Mockito.verify(iMagazineInteractorOutput, Mockito.times(1))
            .returnError(Mockito.anyString())
    }

}