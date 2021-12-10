package com.luzmag.courtainsstore.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class sale(
    @PrimaryKey(autoGenerate = true)
    val idSale: Int,
    val date: String,
    val IdSeller: String,
    val nameCl: String,
    val type: String,
    val quantity: String,
    val valueSale: String
)
