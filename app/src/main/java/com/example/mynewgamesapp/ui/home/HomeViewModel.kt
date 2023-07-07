package com.example.mynewgamesapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mynewgamesapp.data.model.games.SingleGameModel
import com.example.mynewgamesapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel(){

    val gameLiveData: MutableLiveData<List<SingleGameModel>> by lazy {
        MutableLiveData<List<SingleGameModel>>()
    }

    var isLoaded = false
    fun getGameData() {

        CoroutineScope(Dispatchers.Main).launch {
            val result = repository.getAllGames()

            gameLiveData.postValue(result)

            isLoaded = true

        }

    }



}