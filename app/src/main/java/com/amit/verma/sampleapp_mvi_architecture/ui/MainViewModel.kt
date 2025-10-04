package com.amit.verma.sampleapp_mvi_architecture.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amit.verma.sampleapp_mvi_architecture.data.remote.AnimalRepo
import com.amit.verma.sampleapp_mvi_architecture.intent.MainIntent
import com.amit.verma.sampleapp_mvi_architecture.state.MainState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repo: AnimalRepo
) : ViewModel() {

    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)

    var state = mutableStateOf<MainState>(MainState.Idle)
        private set

    init {
        handleIntent()
    }

    private fun handleIntent() {

        viewModelScope.launch {

            userIntent.consumeAsFlow().collect { collector ->

                when(collector){
                    MainIntent.FetchAnimals -> fetchAnimals()
                }

            }
        }
    }

    private fun fetchAnimals(){
        viewModelScope.launch {
            state.value = MainState.Loading
            state.value = try {
                MainState.Animals(repo.getAnimals())
            }catch (e : Exception){
                MainState.Error(e.localizedMessage)
            }
        }
    }

}