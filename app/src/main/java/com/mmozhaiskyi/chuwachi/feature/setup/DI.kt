package com.mmozhaiskyi.chuwachi.feature.setup

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gameSetupModule = module {

    viewModel { GameSetupViewModel() }
}
