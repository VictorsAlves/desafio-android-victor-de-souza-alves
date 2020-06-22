package com.accenture.desafio.character

import android.app.Activity
import com.accenture.desafio.R
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CharacterInteractorTest {

    lateinit var characterInteractor: CharacterInteractor

    @Mock
    lateinit var iCharacterInteractorOutput: CharacterContract.CharacterInteractorOutput

    @Mock
    lateinit var activity: Activity

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        characterInteractor = CharacterInteractor(activity, iCharacterInteractorOutput)
        Assert.assertNotNull(characterInteractor)
    }

    @Test
    fun startCharacters() {
        Mockito.`when`(activity.getString(R.string.not_connection)).thenReturn("error")
        characterInteractor.startCharacters()
        Mockito.verify(iCharacterInteractorOutput, Mockito.times(1))
            .returnError(Mockito.anyString())
    }

}