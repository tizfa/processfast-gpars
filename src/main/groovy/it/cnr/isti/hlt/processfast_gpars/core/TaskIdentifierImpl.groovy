package it.cnr.isti.hlt.processfast_gpars.core

import it.cnr.isti.hlt.processfast.core.TaskIdentifier

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class TaskIdentifierImpl implements TaskIdentifier {
    /**
     * The instance number of the task.
     */
    int instanceNumber = 0

    /**
     * The total number of instances of this task.
     */
    int numTotalInstances = 1

    /**
     * The task name.
     */
    String taskName
}
