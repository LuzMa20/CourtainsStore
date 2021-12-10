package com.luzmag.courtainsstore.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class product(
    @PrimaryKey(autoGenerate = true)
    val idProduct: Int,
    val code: String,
    val type: String,
    val color: String,
    val price: String
)
