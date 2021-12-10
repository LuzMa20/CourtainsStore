package com.luzmag.courtainsstore.room_database

import androidx.room.*

@Dao
interface sellerDAO {
    @Query("SELECT * FROM seller")
    suspend fun getAllTasks(): List<seller>

    @Query("SELECT * FROM seller WHERE email = :email")
    suspend fun findById(email: String): seller

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: seller): Long

    @Update
    suspend fun updateTask(task: seller)

    @Delete
    suspend fun deleteTask(task: seller)
}