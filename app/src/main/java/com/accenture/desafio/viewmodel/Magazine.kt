package com.accenture.desafio.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.accenture.desafio.BR

class Magazine : BaseObservable() {

    @Bindable
    var id: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @Bindable
    var title: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @Bindable
    var price: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.price)
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