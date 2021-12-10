package com.luzmag.courtainsstore.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class advance(
    @PrimaryKey(autoGenerate = true)
    val idAdvance: Int,
    val SaleId: String,
    val date: String,
    val valueAdvance: String
)
