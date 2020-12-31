package com.accenture.desafio.interactor.remote

import com.accenture.desafio.users.entity.UserData
import retrofit2.Call
import retrofit2.http.GET


interface IUsersRequest {

    @GET("users")
    fun users(
    ): Call<UserData?>


}