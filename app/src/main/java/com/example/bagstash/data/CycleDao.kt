package com.example.bagstash.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CycleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cycle: Cycle): Long

    @Query("SELECT * FROM Cycle WHERE machineId = :machineId AND sessionId = :sessionId")
    suspend fun getCyclesByMachineAndSession(machineId: Long, sessionId: Long): List<Cycle>
}
