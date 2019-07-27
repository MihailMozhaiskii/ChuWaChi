package com.mmozhaiskyi.chuwachi.data

import com.mmozhaiskyi.chuwachi.data.model.Game
import com.mmozhaiskyi.chuwachi.data.model.GameProperties
import com.mmozhaiskyi.chuwachi.data.model.Player
import com.mmozhaiskyi.chuwachi.data.repository.GameRepository
import com.mmozhaiskyi.chuwachi.data.repository.RoleRepository

class GameManager(
    private val gameRepository: GameRepository,
    private val roleRepository: RoleRepository
) {

    suspend fun hasSavedGame(): Boolean = gameRepository.hasSavedGame()

    suspend fun createGame(properties: GameProperties) {
        val roles = roleRepository.getRandomRoles(properties.playerCount)
        val players = roles.map { role -> Player(roleUID = role) }
        val game = Game(players, properties.shuffleType)

        gameRepository.saveGame(game)
    }
}
