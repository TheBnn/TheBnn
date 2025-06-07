package com.example.bagstash.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Record",
    foreignKeys = [
        ForeignKey(
            entity = Session::class,
            parentColumns = ["sessionId"],
            childColumns = ["sessionId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Department::class,
            parentColumns = ["departmentId"],
            childColumns = ["departmentId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Machine::class,
            parentColumns = ["machineId"],
            childColumns = ["machineId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = Cycle::class,
            parentColumns = ["cycleId"],
            childColumns = ["cycleId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("sessionId"),
        Index("departmentId"),
        Index("machineId"),
        Index("cycleId")
    ]
)
data class Record(
    @PrimaryKey(autoGenerate = true) val recordId: Long = 0L,
    val sessionId: Long,
    val departmentId: Long,
    val packClass: String,
    val packType: String,
    val quantity: Int,
    val weight: Double,
    val timestamp: Long,
    val machineId: Long? = null,
    val cycleId: Long? = null,
    val comment: String? = null
)
