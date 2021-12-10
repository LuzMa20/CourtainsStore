package com.luzmag.courtainsstore.room_database

import androidx.room.*

@Dao
interface advanceDAO {
    @Query("SELECT * FROM advance")
    suspend fun getAllTasks(): List<advance>

    @Query("SELECT * FROM advance WHERE idAdvance = :id")
    suspend fun findById(id: Int): advance

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: advance): Long

    @Update
    suspend fun updateTask(task: advance)

    @Delete
    suspend fun deleteTask(task: advance)
}