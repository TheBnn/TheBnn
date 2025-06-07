package com.example.bagstash.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(session: Session): Long

    @Query("SELECT * FROM Session ORDER BY date DESC")
    suspend fun getAll(): List<Session>
}
