package it.cnr.isti.hlt.processfast_gpars.data

import groovy.transform.CompileStatic
import it.cnr.isti.hlt.processfast.core.TaskDataContext
import it.cnr.isti.hlt.processfast.core.TaskSharedData
import it.cnr.isti.hlt.processfast.data.ReadableDictionary
import it.cnr.isti.hlt.processfast.data.StorageManager
import it.cnr.isti.hlt.processfast_gpars.core.GParsTaskContext

/**
 * A task data context to be used in partitionable datasets
 * operations.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
@CompileStatic
class GParsTaskDataContext implements TaskDataContext {

    final ReadableDictionary tasksSetDataDictionary

    final TaskSharedData taskSharedData

    final StorageManager storageManager

    GParsTaskDataContext(GParsTaskContext tc) {
        if (tc == null)
            throw new NullPointerException("The task context is 'null'")
        this.tasksSetDataDictionary = tc.tasksSetDataDictionary
        this.taskSharedData = new GParsTaskSharedData(dataDictionary: tc.privateTaskDataDictionary)
        this.storageManager = tc.storageManager
    }

    @Override
    StorageManager getStorageManager() {
        return storageManager
    }
}


@CompileStatic
class GParsTaskSharedData implements TaskSharedData {

    ReadableDictionary dataDictionary

}
