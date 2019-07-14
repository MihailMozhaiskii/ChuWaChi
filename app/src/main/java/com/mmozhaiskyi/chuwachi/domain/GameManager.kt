package com.mmozhaiskyi.chuwachi.domain

import com.mmozhaiskyi.chuwachi.data.model.Game
import com.mmozhaiskyi.chuwachi.data.model.GameProperties

interface GameManager {

    suspend fun hasSavedGame(): Boolean

    suspend fun loadGame(): Game

    suspend fun createNew(properties: GameProperties): Game
}

class GameManagerImpl