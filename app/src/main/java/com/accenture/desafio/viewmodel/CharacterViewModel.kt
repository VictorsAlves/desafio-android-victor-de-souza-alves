package com.accenture.desafio.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class CharacterViewModel(
    val chacarterLiveData: MutableLiveData<MutableList<Character>> = MutableLiveData(ArrayList()),
    val list: MutableList<Character> = ArrayList(),
    var clickCharacter: Character = Character()
) : ViewModel()