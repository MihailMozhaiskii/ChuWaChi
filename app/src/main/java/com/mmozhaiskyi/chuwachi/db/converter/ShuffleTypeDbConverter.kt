package com.mmozhaiskyi.chuwachi.db.converter

import androidx.room.TypeConverter
import com.mmozhaiskyi.chuwachi.data.model.ShuffleType

class ShuffleTypeDbConverter {

    @TypeConverter
    fun toValue(type: ShuffleType): Int = type.ordinal

    @TypeConverter
    fun toShuffleType(value: Int): ShuffleType = ShuffleType.values()[value]
}
