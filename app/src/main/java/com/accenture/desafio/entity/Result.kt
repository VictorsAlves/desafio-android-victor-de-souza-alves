package com.accenture.desafio.entity

data class Result(
    var code: String = "",
    var status: String = "",
    var message: String = "",
    var data: Data = Data(ArrayList())
)