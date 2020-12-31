package com.accenture.desafio.users


import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.accenture.desafio.BR

class UserDataBind : BaseObservable() {

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
    var img: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.img)
        }

    @Bindable
    var username: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.username)
        }




}