package com.mmozhaiskyi.chuwachi.domain

import com.mmozhaiskyi.chuwachi.data.repository.RoleRepositoryImpl
import org.koin.dsl.module

val domainModule = module {

    single<RoleRepository> { RoleRepositoryImpl(get()) }
}
