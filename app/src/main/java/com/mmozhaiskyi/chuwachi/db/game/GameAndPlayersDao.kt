package com.mmozhaiskyi.chuwachi.db.game

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class GameAndPlayersDao {

    @Query("SELECT * FROM GameDbModel")
    abstract suspend fun loadGame(): GameAndPlayers

    fun insert(game: GameAndPlayers) {
        insert(game.game)
        insert(game.players)
    }

    @Insert
    protected abstract fun insert(game: GameDbModel)

    @Insert
    protected abstract fun insert(players: List<PlayerDbModel>)

    @Query("DELETE FROM GameDbModel")
    abstract suspend fun clearGame()
}
