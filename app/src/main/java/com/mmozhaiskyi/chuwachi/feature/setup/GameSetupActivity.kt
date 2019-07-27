package com.mmozhaiskyi.chuwachi.feature.setup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mmozhaiskyi.chuwachi.R
import com.mmozhaiskyi.chuwachi.data.model.ShuffleType
import kotlinx.android.synthetic.main.activity_game_setup.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameSetupActivity : AppCompatActivity() {

    val vm: GameSetupViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_setup)

        count_variant_list.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        count_variant_list.adapter = PickNumberAdapter(3..20, vm.playersCount) {
            vm.playersCount = it.first()
        }

        game_types_variants_list.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        val types = ShuffleTypeContentProvider.types
        val default = types.first { it.type == ShuffleType.OneVsOne }
        game_types_variants_list.adapter = PickShuffleTypeAdapter(types, default) {
            vm.gameType = it.first().type
        }

        create_game_button.setOnClickListener { vm.createGameClicked() }

        val observer = Observer<GameSetupState> { state ->
            when (state) {
                is GameSetupState.SetupCompleted -> finish()
            }
        }
        vm.state.observe(this, observer)
    }
}
