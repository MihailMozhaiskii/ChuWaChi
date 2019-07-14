package com.mmozhaiskyi.chuwachi.data.repository

import com.mmozhaiskyi.chuwachi.data.model.Role

interface RoleRepository {

    suspend fun loadRole(uid: String): Role

    /**
     * return list of role uid
     */

    //TODO add role types parameter. Something like Telegram sticker pack
    suspend fun getRandomRoles(): List<String>
}
