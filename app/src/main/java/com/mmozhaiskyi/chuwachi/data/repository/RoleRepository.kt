package com.mmozhaiskyi.chuwachi.data.repository

import com.mmozhaiskyi.chuwachi.data.mapper.RoleMapper
import com.mmozhaiskyi.chuwachi.data.model.Role
import com.mmozhaiskyi.chuwachi.db.roles.RoleDao

interface RoleRepository {

    suspend fun loadRole(uid: String): Role

    /**
     * return list of role uid
     */

    //TODO add role types parameter. Something like Telegram sticker pack
    suspend fun getRandomRoles(count: Int): List<String>
}


class RoleRepositoryImpl(
    private val roleDao: RoleDao
) : RoleRepository {

    override suspend fun loadRole(uid: String): Role {
        val dbModel = roleDao.getByUId(uid)
        return RoleMapper.fromDbModel(dbModel)
    }

    override suspend fun getRandomRoles(count: Int): List<String> = roleDao.getRandomUIDs(count)
}
