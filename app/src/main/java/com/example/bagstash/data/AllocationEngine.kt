package com.example.packagingapp.data

import javax.inject.Inject

class AllocationEngine @Inject constructor(
    private val machineDao: MachineDao,
    private val recordDao: RecordDao,
    private val cycleDao: CycleDao
) {
    suspend fun autoAllocate(sessionId: Long) {
        val unassigned = recordDao.getRecordsBySessionAndNoMachine(sessionId)
        val machines = machineDao.getAllMachines().sortedBy { it.name }
        val machineStates = machines.map { machine ->
            val cycles = cycleDao.getCyclesByMachineAndSession(machine.machineId, sessionId)
                .map { cycle ->
                    val used = recordDao.getSumWeightByCycle(cycle.cycleId) ?: 0.0
                    cycle to used
                }.toMutableList()
            machine to cycles
        }
        for (record in unassigned) {
            if (record.weight > 9.0) continue
            var placed = false
            for ((machine, cycles) in machineStates) {
                for (i in cycles.indices) {
                    val (cycle, used) = cycles[i]
                    val available = 9.0 - used
                    if (record.weight <= available) {
                        recordDao.updateMachineAndCycle(record.recordId, machine.machineId, cycle.cycleId)
                        cycles[i] = cycle to (used + record.weight)
                        placed = true
                        break
                    }
                }
                if (!placed) {
                    val newCycle = Cycle(
                        machineId = machine.machineId,
                        sessionId = sessionId,
                        name = "${machine.name} - Cycle ${cycles.size + 1}",
                        createdAt = System.currentTimeMillis()
                    )
                    val newId = cycleDao.insert(newCycle)
                    cycles.add(newCycle.copy(cycleId = newId) to record.weight)
                    recordDao.updateMachineAndCycle(record.recordId, machine.machineId, newId)
                    placed = true
                }
                if (placed) break
            }
        }
    }
}
