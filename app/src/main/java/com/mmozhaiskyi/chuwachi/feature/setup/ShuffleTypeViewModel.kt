package com.mmozhaiskyi.chuwachi.feature.setup

import androidx.annotation.StringRes
import com.mmozhaiskyi.chuwachi.R
import com.mmozhaiskyi.chuwachi.data.model.ShuffleType

data class ShuffleTypeViewModel(
    @StringRes val title: Int,
    @StringRes val description: Int,
    val type: ShuffleType)

object ShuffleTypeContentProvider {

    val types = listOf(
        ShuffleTypeViewModel(
            R.string.one_vs_one,
            R.string.one_vs_one_description,
            ShuffleType.OneVsOne
        ),
        ShuffleTypeViewModel(
            R.string.two_vs_two,
            R.string.two_vs_two_description,
            ShuffleType.TwoVsTwo
        )
    )
}
