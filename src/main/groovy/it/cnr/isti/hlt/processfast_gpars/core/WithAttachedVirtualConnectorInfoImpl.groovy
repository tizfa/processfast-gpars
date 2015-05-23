package it.cnr.isti.hlt.processfast_gpars.core

import it.cnr.isti.hlt.processfast.core.WithAttachedVirtualConnectorInfo
import it.cnr.isti.hlt.processfast.data.ReadableDictionary

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class WithAttachedVirtualConnectorInfoImpl extends TaskIdentifierImpl implements WithAttachedVirtualConnectorInfo {

    /**
     * The data dictionary specific for a given instance of a task.
     */
    ReadableDictionary dataDictionary
}
