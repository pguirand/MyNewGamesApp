package com.example.mynewgamesapp.data.repository

import com.example.mynewgamesapp.data.model.characters.CharacterModel
import com.example.mynewgamesapp.data.model.games.SingleGameModel
import com.example.mynewgamesapp.data.remote.CharCall
import com.example.mynewgamesapp.data.remote.GameCall
import javax.inject.Inject

class RepoImpl @Inject constructor(
    val gameCall: GameCall,
    val charCall: CharCall
): Repository {
    override suspend fun getGamebyId(id: Int) =  gameCall.getGamebyId(id)


    override suspend fun getGameByCategory(category: String) = gameCall.getGameByCategory(category)


    override suspend fun getAllGames() = gameCall.getAllGames()


    override suspend fun getCharacter(id: Int) =charCall.getCharacter(id)

}