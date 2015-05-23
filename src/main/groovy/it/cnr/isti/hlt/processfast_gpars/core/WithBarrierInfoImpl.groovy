package it.cnr.isti.hlt.processfast_gpars.core

import it.cnr.isti.hlt.processfast.core.WithBarrierInfo
import it.cnr.isti.hlt.processfast.data.ReadableDictionary

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class WithBarrierInfoImpl extends TaskIdentifierImpl implements WithBarrierInfo {
    /**
     * The data dictionary specific for a given instance of a task.
     */
    ReadableDictionary dataDictionary
}
