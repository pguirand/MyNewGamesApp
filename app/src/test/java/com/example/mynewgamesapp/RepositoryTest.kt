package com.example.mynewgamesapp

import com.example.mynewgamesapp.data.model.games.SingleGameModel
import com.example.mynewgamesapp.data.remote.CharCall
import com.example.mynewgamesapp.data.remote.GameCall
import com.example.mynewgamesapp.data.repository.RepoImpl
import com.example.mynewgamesapp.data.repository.Repository
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.internal.configuration.MockAnnotationProcessor

class RepositoryTest {
    lateinit var repository: Repository

    @Mock
    lateinit var gameCall:GameCall

    @Mock
    lateinit var charcall:CharCall

    @Before
    fun startup() {
        MockitoAnnotations.openMocks(this)
        repository = RepoImpl(
            gameCall = gameCall,
            charCall = charcall
        )
    }
//
//    @Test
//    fun getGameById_Success() = runBlocking {
//        Mockito.`when`(gameCall.getGamebyId(412)).thenReturn(SingleGameModel(
//            id = 412,
//            title = "Call of Duty",
//            shortDescription = "Call of Duty Testing"
//        ))
//
//        val game = repository.getGamebyId(421)
//
//        assertFalse(game.gameUrl == TestRepoImpl.Foo.getGamebyId(412).gameUrl)
//
//
////        assertEquals("Call of Duty", repository.getGamebyId(412).title)
//
//    }


    @Test
    fun testEmptyCallResponse(){

        runTest {
            val game = repository.getGamebyId(421)

            Mockito.`when`(gameCall.getAllGames()).thenReturn(listOf())

            assertEquals(0, repository.getAllGames().size)
        }
    }

    @Test
    fun testHasLessThan10() {
        runTest {
            val allgames = repository.getAllGames()
            Mockito.`when`(gameCall.getAllGames()).thenReturn(TestRepoImpl.Foo.getAllGames())
            assertTrue(gameCall.getAllGames().size < 10)
        }
    }
}