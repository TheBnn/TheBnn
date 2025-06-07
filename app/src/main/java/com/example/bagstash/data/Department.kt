package com.example.bagstash.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Department")
data class Department(
    @PrimaryKey(autoGenerate = true) val departmentId: Long = 0L,
    val name: String
)
