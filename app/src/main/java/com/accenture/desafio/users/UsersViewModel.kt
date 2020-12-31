package com.accenture.desafio.users

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.accenture.desafio.viewmodel.Character

class UsersViewModel(
    val userLiveData: MutableLiveData<MutableList<UserDataBind>> = MutableLiveData(ArrayList()),
    val list: MutableList<UserDataBind> = ArrayList()
) : ViewModel()