package com.mmozhaiskyi.chuwachi.feature.setup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mmozhaiskyi.chuwachi.data.GameManager
import com.mmozhaiskyi.chuwachi.data.model.GameProperties
import com.mmozhaiskyi.chuwachi.data.model.ShuffleType
import kotlinx.coroutines.*

sealed class GameSetupState {

    object SetupCompleted : GameSetupState()
}

class GameSetupViewModel(
    private val gameManager: GameManager
) : ViewModel() {

    private val vmJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + vmJob)

    val state = MutableLiveData<GameSetupState>()

    var playersCount: Int = 3
    var gameType: ShuffleType = ShuffleType.OneVsOne

    fun createGameClicked() {
        val properties = GameProperties(playersCount, gameType)
        uiScope.launch {
            gameManager.createGame(properties)
            state.postValue(GameSetupState.SetupCompleted)
        }

        uiScope.launch {
            val hasSavedGame = gameManager.hasSavedGame()
            println("GAME::$hasSavedGame")
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}
