package com.mmozhaiskyi.chuwachi.data.model

import java.util.UUID

data class Player(
    val id: String = UUID.randomUUID().toString(),
    val roleUID: String)
