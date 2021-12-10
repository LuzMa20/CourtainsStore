package com.luzmag.courtainsstore.room_database

import androidx.room.*

@Dao
interface productDAO {
    @Query("SELECT * FROM product")
     suspend fun getAllTasks():List<product>

    @Query("SELECT * FROM product WHERE idProduct = :id")
    suspend fun findById(id: Int): product

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: product): Long

    @Update
    suspend fun updateTask(task: product)

    @Delete
    suspend fun deleteTask(task: product)
}