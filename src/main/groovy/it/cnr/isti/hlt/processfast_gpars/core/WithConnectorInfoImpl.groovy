package it.cnr.isti.hlt.processfast_gpars.core

import it.cnr.isti.hlt.processfast.connector.ConnectorManager
import it.cnr.isti.hlt.processfast.core.WithConnectorInfo
import it.cnr.isti.hlt.processfast.data.ReadableDictionary

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class WithConnectorInfoImpl extends TaskIdentifierImpl implements WithConnectorInfo {

    /**
     * The connector manager.
     */
    ConnectorManager connectorManager

    /**
     * The data dictionary specific for a given instance of a task.
     */
    ReadableDictionary dataDictionary
}
