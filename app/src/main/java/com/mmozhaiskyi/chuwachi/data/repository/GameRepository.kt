package com.mmozhaiskyi.chuwachi.data.repository

import com.mmozhaiskyi.chuwachi.data.mapper.GameMapper
import com.mmozhaiskyi.chuwachi.data.mapper.PlayerMapper
import com.mmozhaiskyi.chuwachi.data.model.Game
import com.mmozhaiskyi.chuwachi.db.game.GameAndPlayersDao

interface GameRepository {

    suspend fun hasSavedGame(): Boolean

    suspend fun loadSavedGame(): Game

    suspend fun saveGame(game: Game)
}

class GameRepositoryImpl(
    private val gameAndPlayersDao: GameAndPlayersDao
) : GameRepository {

    override suspend fun hasSavedGame() = gameAndPlayersDao.countOfSavedGame() > 0

    override suspend fun loadSavedGame(): Game {
        val dbModel = gameAndPlayersDao.loadGame()
        return GameMapper.fromCombinedDbModel(dbModel)
    }

    override suspend fun saveGame(game: Game) {
        val gameDbModel = GameMapper.toDbModel(game)
        val gameId = gameAndPlayersDao.insert(gameDbModel)
        val players = game.players.map { PlayerMapper.toDbModel(it, gameId.toInt()) }
        gameAndPlayersDao.insert(players)
    }
}
