package com.mmozhaiskyi.chuwachi.domain

import com.mmozhaiskyi.chuwachi.data.model.Role

interface RoleRepository {

    suspend fun loadRole(uid: String): Role

    /**
     * return list of role uid
     */

    //TODO add role types parameter. Something like Telegram sticker pack
    suspend fun getRandomRoles(count: Int): List<String>
}
