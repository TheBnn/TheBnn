package com.example.bagstash.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Department::class, Session::class, Machine::class, Cycle::class, Record::class],
    version = 1
)
abstract class PackagingDatabase : RoomDatabase() {
    abstract fun departmentDao(): DepartmentDao
    abstract fun sessionDao(): SessionDao
    abstract fun machineDao(): MachineDao
    abstract fun cycleDao(): CycleDao
    abstract fun recordDao(): RecordDao
}
