package it.cnr.isti.hlt.processfast_gpars.core

import it.cnr.isti.hlt.processfast.core.WithBarrierInfo
import it.cnr.isti.hlt.processfast.core.WithVirtualMachineInfo
import it.cnr.isti.hlt.processfast.data.ReadableDictionary

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class WithVirtualMachineInfoImpl extends TaskIdentifierImpl implements WithVirtualMachineInfo {
    /**
     * The data dictionary specific for a given instance of a task.
     */
    ReadableDictionary dataDictionary
}
