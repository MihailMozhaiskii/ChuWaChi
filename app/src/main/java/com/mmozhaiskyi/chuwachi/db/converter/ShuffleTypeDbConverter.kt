package com.mmozhaiskyi.chuwachi.db.converter

import com.mmozhaiskyi.chuwachi.data.model.ShuffleType

class ShuffleTypeDbConverter {

    fun toValue(type: ShuffleType): Int = type.ordinal

    fun toShuffleType(value: Int): ShuffleType = ShuffleType.values()[value]
}
