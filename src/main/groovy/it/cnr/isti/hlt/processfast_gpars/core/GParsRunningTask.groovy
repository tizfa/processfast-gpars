package it.cnr.isti.hlt.processfast_gpars.core

import it.cnr.isti.hlt.processfast.core.Task
import it.cnr.isti.hlt.processfast.data.Dictionary
import it.cnr.isti.hlt.processfast.data.RamDictionary

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class GParsRunningTask {

    /**
     * The tasks set owning this primitive task.
     */
    GParsRunningTasksSet ownerTasksSet

    /**
     * The code of the task.
     */
    Task taskCode

    /**
     * The task unique name inside the declaring tasks set.
     */
    String taskName

    /**
     * The instance number of the this task.
     */
    int numInstance = 0

    /**
     * The number of total instances created for this task.
     */
    int numTotalInstances = 1

    /**
     * The set of declared barriers.
     */
    final HashSet<String> barriersDeclared = new HashSet<>()

    /**
     * The task private data dictionary.
     */
    Dictionary privateDataDictionary = new RamDictionary()

    /**
     * The virtual machine name where the task is executed.
     */
    String virtualMachineName = ""

    GParsRunningTask(GParsRunningTasksSet ownerTasksSet, Task taskCode) {
        if (ownerTasksSet == null)
            throw new NullPointerException("The owner tasks set is 'null'")
        if (taskCode == null)
            throw new NullPointerException("The task code is 'null'")
        this.ownerTasksSet = ownerTasksSet
        this.taskCode = taskCode
        this.taskName = "task" + System.currentTimeMillis() + "_" + new Random().nextInt(1000000)
    }


}
