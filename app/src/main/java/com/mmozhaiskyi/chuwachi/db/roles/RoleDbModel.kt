package com.mmozhaiskyi.chuwachi.db.roles

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoleDbModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val _id: Int,
    @ColumnInfo(name = "uid") val uid: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "avatarUrl") val avatarUrl: String,
    @ColumnInfo(name = "description") val description: String)
