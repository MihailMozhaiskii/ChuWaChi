package com.mmozhaiskyi.chuwachi.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mmozhaiskyi.chuwachi.db.game.GameAndPlayersDao
import com.mmozhaiskyi.chuwachi.db.game.GameDbModel
import com.mmozhaiskyi.chuwachi.db.game.PlayerDbModel
import com.mmozhaiskyi.chuwachi.db.roles.RoleDao
import com.mmozhaiskyi.chuwachi.db.roles.RoleDbModel

@Database(entities = [GameDbModel::class, PlayerDbModel::class, RoleDbModel::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun gameAndPlayersDao(): GameAndPlayersDao

    abstract fun roleDao(): RoleDao
}
