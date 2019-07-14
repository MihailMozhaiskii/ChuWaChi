package com.mmozhaiskyi.chuwachi.db.roles

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class RoleDao {

    @Insert
    abstract suspend fun insert(role: RoleDbModel)

    @Query("SELECT * FROM RoleDbModel WHERE uid = :uid")
    abstract suspend fun getByUId(uid: String): RoleDbModel

    @Query("SELECT uid FROM RoleDbModel ORDER BY RANDOM() LIMIT :count")
    abstract suspend fun getRandomUIDs(count: Int): List<String>
}
