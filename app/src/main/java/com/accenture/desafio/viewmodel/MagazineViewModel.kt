package com.accenture.desafio.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class MagazineViewModel(
    val magazineLiveData: MutableLiveData<Magazine> = MutableLiveData(Magazine()),
    var magazine: Magazine = Magazine()
) : ViewModel()