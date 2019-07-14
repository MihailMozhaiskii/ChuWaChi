package com.mmozhaiskyi.chuwachi.feature.setup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
        count_variant_list.adapter = PickNumberAdapter(3..20) {

        }

        game_types_variants_list.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        game_types_variants_list.adapter = PickShuffleTypeAdapter(ShuffleTypeContentProvider.get()) {

        }
    }
}
