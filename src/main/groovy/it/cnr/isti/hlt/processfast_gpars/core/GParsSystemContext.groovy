package it.cnr.isti.hlt.processfast_gpars.core

import groovy.transform.CompileStatic
import it.cnr.isti.hlt.processfast.core.LogManager
import it.cnr.isti.hlt.processfast.core.SystemContext
import it.cnr.isti.hlt.processfast.data.StorageManager

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
@CompileStatic
class GParsSystemContext implements SystemContext {

    /**
     * The GPars runtime to use.
     */
    final GParsRuntime runtime


    GParsSystemContext(GParsRuntime runtime) {
        if (runtime == null)
            throw new NullPointerException("The GPars runtime is 'null'")

        this.runtime = runtime
    }

    @Override
    LogManager getLogManager() {
        return runtime.orchestrator.internalLogManager
    }

    @Override
    StorageManager getStorageManager() {
        return runtime.storageManager
    }
}
