package com.mmozhaiskyi.chuwachi.db.game

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class GameAndPlayersDao {

    @Query("SELECT * FROM GameDbModel")
    abstract suspend fun loadGame(): GameAndPlayers

    @Insert
    abstract suspend fun insert(game: GameAndPlayers)

    @Query("DELETE FROM GameDbModel")
    abstract suspend fun clearGame()
}
