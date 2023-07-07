package com.example.mynewgamesapp

import com.example.mynewgamesapp.data.model.characters.CharacterModel
import com.example.mynewgamesapp.data.model.games.SingleGameModel
import com.example.mynewgamesapp.data.repository.Repository


class TestRepoImpl {

    object Foo{
        fun getAllGames(): List<SingleGameModel> {
            return listOf(
                SingleGameModel(
                    id = 412,
                    title = "Call of Duty",
                    shortDescription = "Call of Duty Testing"
                ),
                SingleGameModel(
                    id = 512,
                    title = "Prince Of Persia",
                    shortDescription = "Prince Of PersiaTesting"
                ),
                SingleGameModel(
                    id = 412,
                    title = "Super Mario",
                    shortDescription = "Super Mario Testing"
                )
            )
        }

         fun getGamebyId(id: Int): SingleGameModel {
            return SingleGameModel(
                id = 412,
                title = "Call of Duty",
                shortDescription = "Call of Duty Testing"
            )
        }


         fun getGameByCategory(category: String): List<SingleGameModel> {
            return listOf(
                SingleGameModel(
                    id = 412,
                    title = "Call of Duty",
                    shortDescription = "Call of Duty Testing"
                ),
                SingleGameModel(
                    id = 512,
                    title = "Prince Of Persia",
                    shortDescription = "Prince Of PersiaTesting"
                ),
                SingleGameModel(
                    id = 412,
                    title = "Super Mario",
                    shortDescription = "Super Mario Testing"
                )
            )

        }

         fun getCharacter(id: Int): CharacterModel {
            return CharacterModel(
                aliases = listOf("Spiderman", "Venom"),
                gender = "M"
            )
        }
    }

}