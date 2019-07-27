package com.mmozhaiskyi.chuwachi.data.mapper

import com.mmozhaiskyi.chuwachi.data.model.Player
import com.mmozhaiskyi.chuwachi.db.game.PlayerDbModel

object PlayerMapper {

    fun fromDbModel(dbModel: PlayerDbModel): Player = with(dbModel) {
        Player(roleUID = roleUID)
    }

    fun toDbModel(model: Player, gameId: Int): PlayerDbModel = with(model) {
        PlayerDbModel(_gameId = gameId, roleUID = roleUID)
    }
}
