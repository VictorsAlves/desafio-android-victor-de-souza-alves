package com.accenture.desafio.users

import android.content.Context
import com.accenture.desafio.interactor.remote.IUsersRequest
import com.accenture.desafio.interactor.remote.Service
import com.accenture.desafio.users.entity.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class UserRepository(context: Context) : Service(context), UserContract.IUserRepository {

    override fun users(
        success: (currencyLayer: Response<UserData?>) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_PICPAY)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(IUsersRequest::class.java)

        val call = retrofit.users()

        call.enqueue(object : Callback<UserData?> {
            override fun onResponse(call: Call<UserData?>?, response: Response<UserData?>?) {
                response?.let {
                    success.invoke(it)
                }
            }

            override fun onFailure(call: Call<UserData?>?, t: Throwable) {
                failure.invoke(t)
            }
        })
    }

}
