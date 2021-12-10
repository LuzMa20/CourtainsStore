package com.luzmag.courtainsstore.room_database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class seller (
    @PrimaryKey(autoGenerate = false)
    val idSeller: String,
    val nameSeller: String,
    val email: String,
    val password: String
        )