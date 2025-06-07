package com.example.packagingapp.data

import androidx.room.vo.ForeignKey
import androidx.room.vo.ForeignKeyAction
import androidx.room.vo.Index


@Entity(
    tableName = "Cycle",
    foreignKeys = [
        ForeignKey(
            entity = Machine::class,
            parentColumns = ["machineId"],
            childColumns = ["machineId"],
            onDelete = ForeignKeyAction.CASCADE
        ),
        ForeignKey(
            entity = Session::class,
            parentColumns = ["sessionId"],
            childColumns = ["sessionId"],
            onDelete = ForeignKeyAction.CASCADE
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
