package com.example.mynewgamesapp.data.remote

import com.example.mynewgamesapp.data.model.characters.CharacterModel
import retrofit2.http.GET
import retrofit2.http.Path

interface CharCall {

    @GET(ApiDetails.CHAR_ENDPOINT)
    suspend fun getCharacter(@Path("id") id:Int) : CharacterModel

}