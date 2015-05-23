package it.cnr.isti.hlt.processfast_gpars.connector

import it.cnr.isti.hlt.processfast.connector.ConnectorType

/**
 * A generic GPars connector used to create communication channels
 * among defined tasks.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class GParsConnector {

    /**
     * The name of the connector (which is unique inside the owning tasks set).
     */
    String connectorName = "Unnamed!"

    /**
     * Indicate if the defined connector is virtual or real.
     */
    boolean isVirtual = false

    /**
     * The connector type. Valid only when the connector is not virtual. Default value is
     * ConnectorType.LOAD_BALANCING_QUEUE
     */
    ConnectorType connectorType = ConnectorType.LOAD_BALANCING_QUEUE


    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        GParsConnector that = (GParsConnector) o

        if (connectorName != that.connectorName) return false

        return true
    }

    int hashCode() {
        return connectorName.hashCode()
    }
}
