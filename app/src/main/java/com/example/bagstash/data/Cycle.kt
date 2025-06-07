package com.example.bagstash.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Cycle",
    foreignKeys = [
        ForeignKey(
            entity = Machine::class,
            parentColumns = ["machineId"],
            childColumns = ["machineId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Session::class,
            parentColumns = ["sessionId"],
            childColumns = ["sessionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("machineId"), Index("sessionId")]
)
data class Cycle(
    @PrimaryKey(autoGenerate = true) val cycleId: Long = 0L,
    val machineId: Long,
    val sessionId: Long,
    val name: String,
    val createdAt: Long
)
