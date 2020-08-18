package com.accenture.desafio.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class Magazine : BaseObservable() {


    var id: Int = 0
        set(value) {
            field = value
           // notifyPropertyChanged(BR.id)
        }


    var title: String = ""
        set(value) {
            field = value
          //  notifyPropertyChanged(BR.title)
        }


    var price: String = ""
        set(value) {
            field = value
           // notifyPropertyChanged(BR.price)
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