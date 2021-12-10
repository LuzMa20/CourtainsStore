package com.luzmag.courtainsstore.room_database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = arrayOf(seller::class, product::class, sale::class, advance::class),
    version = 1
)

abstract class CourtainStoreDB: RoomDatabase() {
    abstract fun advanceDAO(): advanceDAO
    abstract fun productDAO(): productDAO
    abstract fun saleDAO(): saleDAO
    abstract fun sellerDAO(): sellerDAO
}
