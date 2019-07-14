package com.mmozhaiskyi.chuwachi.feature.ui_legacy.count

sealed class ChooseCountContentModel(val type: ViewType) {

    enum class ViewType { TITLE, MORE_BUTTON, NUMBER }

    object Title : ChooseCountContentModel(ViewType.TITLE)

    data class Number(val count: Int) : ChooseCountContentModel(ViewType.NUMBER)

    object MoreButton : ChooseCountContentModel(ViewType.MORE_BUTTON)
}
