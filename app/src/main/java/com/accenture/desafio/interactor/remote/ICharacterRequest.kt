package com.accenture.desafio.interactor.remote

import com.accenture.desafio.entity.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ICharacterRequest {

    @GET("v1/public/characters?")
    fun characters(
        @Query("ts") ts: Long,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Call<Result?>

    @GET("v1/public/characters/{characterId}/comics?")
    fun magazines(
        @Path("characterId") id: Int,
        @Query("ts") ts: Long,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ): Call<Result?>

}