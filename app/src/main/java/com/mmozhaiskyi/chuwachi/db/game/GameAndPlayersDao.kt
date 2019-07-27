package com.mmozhaiskyi.chuwachi.db.game

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class GameAndPlayersDao {

    @Query("SELECT * FROM GameDbModel")
    abstract suspend fun loadGame(): GameAndPlayers

    @Query("SELECT COUNT(*) FROM GameDbModel")
    abstract suspend fun countOfSavedGame(): Int

    @Insert
    abstract suspend fun insert(game: GameDbModel): Long

    @Insert
    abstract suspend fun insert(players: List<PlayerDbModel>)

    @Query("DELETE FROM GameDbModel")
    abstract suspend fun clearGame()
}
