package com.mmozhaiskyi.chuwachi.feature.ui.game.setup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameSetupActivity : AppCompatActivity() {

    val vm: GameSetupViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
