package com.mmozhaiskyi.chuwachi.data

import com.mmozhaiskyi.chuwachi.data.repository.GameRepository
import com.mmozhaiskyi.chuwachi.data.repository.GameRepositoryImpl
import com.mmozhaiskyi.chuwachi.data.repository.RoleRepository
import com.mmozhaiskyi.chuwachi.data.repository.RoleRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single<RoleRepository> { RoleRepositoryImpl(get()) }

    single<GameRepository> { GameRepositoryImpl(get()) }

    single { GameManager(get(), get()) }
}
