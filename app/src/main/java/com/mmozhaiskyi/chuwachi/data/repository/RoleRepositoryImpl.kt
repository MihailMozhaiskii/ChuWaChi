package com.mmozhaiskyi.chuwachi.data.repository

import com.mmozhaiskyi.chuwachi.data.model.Role
import com.mmozhaiskyi.chuwachi.db.roles.RoleDao
import com.mmozhaiskyi.chuwachi.db.roles.RoleDbModel
import com.mmozhaiskyi.chuwachi.domain.RoleRepository

object RoleMapper {

    fun fromDbModel(dbModel: RoleDbModel): Role = with(dbModel) {
        Role(uid, name, avatarUrl, description)
    }
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
