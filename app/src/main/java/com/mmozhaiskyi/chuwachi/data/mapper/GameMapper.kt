package com.mmozhaiskyi.chuwachi.data.mapper

import com.mmozhaiskyi.chuwachi.data.model.Game
import com.mmozhaiskyi.chuwachi.db.game.GameAndPlayers
import com.mmozhaiskyi.chuwachi.db.game.GameDbModel

object GameMapper {

    fun fromCombinedDbModel(dbModel: GameAndPlayers): Game = with(dbModel) {
        val players = players.map { PlayerMapper.fromDbModel(it) }
        return@with Game(players, game.type)
    }

    fun toDbModel(model: Game): GameDbModel = with(model) {
        GameDbModel(type = shuffleType)
    }
}
