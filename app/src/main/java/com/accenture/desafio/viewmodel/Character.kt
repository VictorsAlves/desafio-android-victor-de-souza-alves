package com.accenture.desafio.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class Character  : BaseObservable() {


    var id: Int = 0
    set(value) {
        field = value
       // notifyPropertyChanged(BR.id)
    }


    var name: String = ""
    set(value) {
        field = value
        //notifyPropertyChanged(BR.name)
    }


    var detail: String = ""
        set(value) {
            field = value
            //notifyPropertyChanged(BR.detail)
        }


    var image: String = ""
    set(value) {
        field = value
        //notifyPropertyChanged(BR.image)
    }

}