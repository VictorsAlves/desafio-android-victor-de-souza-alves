package com.accenture.desafio.character

import android.content.Context
import com.accenture.desafio.entity.Result
import com.accenture.desafio.interactor.remote.ICharacterRequest
import com.accenture.desafio.interactor.remote.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class CharacterRepository(context: Context): Service(context)
    ,CharacterContract.ICharacterRepository {

    override fun characters(
        success: (currencyLayer: Response<Result?>) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_SERVICE)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ICharacterRequest::class.java)

        val ts = Date().time
        val call = retrofit.characters(ts,getApiKey(),getHash(ts))
        call.enqueue(object : Callback<Result?> {
            override fun onResponse(call: Call<Result?>?, response: Response<Result?>?) {
                response?.let {
                    success.invoke(it)
                }
            }

            override fun onFailure(call: Call<Result?>?, t: Throwable) {
                failure.invoke(t)
            }
        })
    }

}