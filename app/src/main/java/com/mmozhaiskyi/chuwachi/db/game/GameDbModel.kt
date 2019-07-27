package com.mmozhaiskyi.chuwachi.db.game

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.mmozhaiskyi.chuwachi.data.model.ShuffleType

@Entity
data class GameDbModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val _id: Int = 0,
    @ColumnInfo(name = "shuffle_type") val type: ShuffleType
)

data class GameAndPlayers(
    @Embedded val game: GameDbModel,
    @Relation(
        parentColumn = "id",
        entityColumn = "game_id",
        entity = PlayerDbModel::class
    ) val players: List<PlayerDbModel>)
