package com.mmozhaiskyi.chuwachi.feature.setup

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.mmozhaiskyi.chuwachi.R
import com.mmozhaiskyi.chuwachi.data.model.ShuffleType

data class ShuffleTypeViewModel(
    @ColorRes val backgroundColor: Int,
    @StringRes val title: Int,
    @StringRes val description: Int)

object ShuffleTypeContentProvider {

    fun get() = listOf(
        ShuffleTypeViewModel(
            R.color.materialPurple,
            R.string.one_vs_one,
            R.string.one_vs_one_description
        ),
        ShuffleTypeViewModel(
            R.color.materialAmber,
            R.string.two_vs_two,
            R.string.two_vs_two_description
        )
    )
}
