package it.cnr.isti.hlt.processfast_gpars.core

import it.cnr.isti.hlt.processfast.core.WithBarrierInfo
import it.cnr.isti.hlt.processfast.core.WithDataDictionaryInfo
import it.cnr.isti.hlt.processfast.data.Dictionary
import it.cnr.isti.hlt.processfast.data.ReadableDictionary

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class WithDataDictionaryInfoImpl extends TaskIdentifierImpl implements WithDataDictionaryInfo {
    /**
     * The data dictionary specific for a given instance of a task.
     */
    Dictionary dataDictionary
}
