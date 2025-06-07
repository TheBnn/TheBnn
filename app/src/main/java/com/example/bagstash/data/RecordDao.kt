package com.example.packagingapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface RecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: Record): Long

    @Update
    suspend fun update(record: Record)

    @Query("SELECT * FROM Record WHERE sessionId = :sessionId")
    suspend fun getRecordsBySession(sessionId: Long): List<Record>

    @Query("SELECT * FROM Record WHERE sessionId = :sessionId AND machineId IS NULL")
    suspend fun getRecordsBySessionAndNoMachine(sessionId: Long): List<Record>

    @Query("SELECT COALESCE(SUM(weight), 0.0) FROM Record WHERE cycleId = :cycleId")
    suspend fun getSumWeightByCycle(cycleId: Long): Double?

    @Query("UPDATE Record SET machineId = :machineId, cycleId = :cycleId WHERE recordId = :recordId")
    suspend fun updateMachineAndCycle(recordId: Long, machineId: Long?, cycleId: Long?)
}
