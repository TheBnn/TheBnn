package com.example.packagingapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MachineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(machine: Machine): Long

    @Query("SELECT * FROM Machine")
    suspend fun getAllMachines(): List<Machine>
}
