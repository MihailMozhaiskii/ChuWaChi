package com.mmozhaiskyi.chuwachi.data.mapper

import com.mmozhaiskyi.chuwachi.data.model.Role
import com.mmozhaiskyi.chuwachi.db.roles.RoleDbModel

object RoleMapper {

    fun fromDbModel(dbModel: RoleDbModel): Role = with(dbModel) {
        Role(uid, name, avatarUrl, description)
    }
}
