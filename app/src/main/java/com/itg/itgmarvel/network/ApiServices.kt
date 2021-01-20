package com.itg.itgmarvel.network

import com.itg.itgmarvel.models.CharactersListResponseModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("characters")
    fun getCharacters(
        @Query("ts")timeStr:String,
        @Query("apikey")publicKey:String,
        @Query("hash")md5Hash:String,
        //TODO: add limit, offset queries.
    ): Deferred<CharactersListResponseModel>
}