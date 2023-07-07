package com.example.mynewgamesapp.data.repository

import com.example.mynewgamesapp.data.model.characters.CharacterModel
import com.example.mynewgamesapp.data.model.games.SingleGameModel
import retrofit2.http.Path
import retrofit2.http.Query

interface Repository {

    suspend fun getGamebyId(@Query("id") id: Int): SingleGameModel

    suspend fun getGameByCategory(@Query("category") category : String) : List<SingleGameModel>

    suspend fun getAllGames() : List<SingleGameModel>


    suspend fun getCharacter(@Path("id") id:Int) : CharacterModel
}