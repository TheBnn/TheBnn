package com.example.packagingapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DepartmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(department: Department): Long

    @Query("SELECT * FROM Department")
    suspend fun getAll(): List<Department>
}
