package com.mmozhaiskyi.chuwachi.db

import org.koin.dsl.module

val databaseModule = module {

    single { DbProvider.provide(get()) }

    single { get<Database>().gameAndPlayersDao() }

    single { get<Database>().roleDao() }
}
