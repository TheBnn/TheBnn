package com.example.packagingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Session")
data class Session(
    @PrimaryKey(autoGenerate = true) val sessionId: Long = 0L,
    val date: Long,
    val description: String?
)
