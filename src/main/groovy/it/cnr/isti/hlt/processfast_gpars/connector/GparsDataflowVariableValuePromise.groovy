package it.cnr.isti.hlt.processfast_gpars.connector

import groovyx.gpars.dataflow.DataflowVariable
import it.cnr.isti.hlt.processfast.connector.ValuePromise

/**
 * A GPars value promise.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
class GparsDataflowVariableValuePromise implements ValuePromise<Serializable> {

    /**
     * The channel used to retrieve the value.
     */
    final DataflowVariable channelValue

    GparsDataflowVariableValuePromise(DataflowVariable channelValue) {
        if (channelValue == null)
            throw new NullPointerException("The specified dataflow variable is 'null'")
        this.channelValue = channelValue
    }

    @Override
    Serializable get() {
        return channelValue.get()
    }
}
