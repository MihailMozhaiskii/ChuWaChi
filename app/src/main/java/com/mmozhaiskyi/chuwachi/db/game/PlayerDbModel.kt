package com.mmozhaiskyi.chuwachi.db.game

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(
        entity = GameDbModel::class,
        parentColumns = ["id"],
        childColumns = ["game_id"],
        onDelete = ForeignKey.CASCADE
    )
])
data class PlayerDbModel(
    @PrimaryKey(autoGenerate = true) val _id: Int = 0,
    @ColumnInfo(name = "game_id") val _gameId: Int,
    @ColumnInfo(name = "role_uid") val roleUID: String)
