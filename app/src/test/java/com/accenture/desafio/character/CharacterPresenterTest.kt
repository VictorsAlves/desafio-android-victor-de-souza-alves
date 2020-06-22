package com.accenture.desafio.character

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import com.accenture.desafio.entity.Result
import com.accenture.desafio.viewmodel.Character
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CharacterPresenterTest {

    lateinit var characterPresenter: CharacterPresenter

    @Mock
    lateinit var iCharacterInteractorInput: CharacterContract.CharacterInteractorInput

    @Mock
    lateinit var iCharacterPresenterOutput: CharacterContract.CharacterPresenterOutput

    @Mock
    lateinit var characterLiveDate: MutableLiveData<MutableList<Character>>

    @Mock
    lateinit var activity: Activity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        characterPresenter =
            CharacterPresenter(iCharacterPresenterOutput,activity, characterLiveDate)
        characterPresenter.interactor = iCharacterInteractorInput
        Assert.assertNotNull(characterPresenter)
    }

    @Test
    fun startCharacters() {
        characterPresenter.startCharacters()
        Mockito.verify(iCharacterInteractorInput, Mockito.times(1))
            .startCharacters()
    }

    @Test
    fun returnCharacters() {
        characterPresenter.returnCharacters(Result())
        Mockito.verify(characterLiveDate, Mockito.times(1))
            .postValue(Mockito.anyList())
    }

    @Test
    fun returnError() {
        characterPresenter.returnError("teste")
        Mockito.verify(iCharacterPresenterOutput, Mockito.times(1))
            .returnError(Mockito.anyString())
    }
}