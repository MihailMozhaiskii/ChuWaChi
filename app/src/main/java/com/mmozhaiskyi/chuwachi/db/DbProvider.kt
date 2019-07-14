package com.mmozhaiskyi.chuwachi.db

import android.content.Context
import androidx.room.Room

object DbProvider {

    fun provide(context: Context) = Room.databaseBuilder(context, Database::class.java, DATABASE_NAME)

    private const val DATABASE_NAME = "game_db"
}
