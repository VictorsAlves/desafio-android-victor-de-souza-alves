package com.accenture.desafio.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.accenture.desafio.BR

class Character  : BaseObservable() {

    @Bindable
    var id: Int = 0
    set(value) {
        field = value
        notifyPropertyChanged(BR.id)
    }

    @Bindable
    var name: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.name)
    }

    @Bindable
    var detail: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.detail)
        }

    @Bindable
    var image: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.image)
    }

}