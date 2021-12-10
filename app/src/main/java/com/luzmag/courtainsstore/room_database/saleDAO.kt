package com.luzmag.courtainsstore.room_database

import androidx.room.*

@Dao
interface saleDAO {
    @Query("SELECT * FROM sale")
    suspend fun getAllTasks():List<sale>

    @Query("SELECT * FROM sale WHERE idSale = :id")
    suspend fun findById(id: Int): sale

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: sale): Long

    @Update
    suspend fun updateTask(task: sale)

    @Delete
    suspend fun deleteTask(task: sale)
}