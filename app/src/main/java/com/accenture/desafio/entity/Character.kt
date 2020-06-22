package com.accenture.desafio.entity

data class Character(
    var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var thumbnail: Thumbnail = Thumbnail(),
    var prices: MutableList<Price> = ArrayList(),
    var title: String = ""
)