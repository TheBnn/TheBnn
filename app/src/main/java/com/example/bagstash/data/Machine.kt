package com.example.bagstash.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Machine")
data class Machine(
    @PrimaryKey(autoGenerate = true) val machineId: Long = 0L,
    val name: String
)
