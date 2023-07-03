package com.example.mynewgamesapp.data.remote

import com.example.mynewgamesapp.data.model.games.SingleGameModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCall {
    @GET(ApiDetails.End_Point)
    suspend fun getGamebyId(@Query("id") id: Int): SingleGameModel

    @GET(ApiDetails.ALL_END_POINTS)
    suspend fun getGameByCategory(@Query("category") category : String) : List<SingleGameModel>

    @GET(ApiDetails.ALL_END_POINTS)
    suspend fun getAllGames() : List<SingleGameModel>

}