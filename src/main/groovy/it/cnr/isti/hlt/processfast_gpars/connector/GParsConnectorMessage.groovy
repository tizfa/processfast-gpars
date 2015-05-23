package it.cnr.isti.hlt.processfast_gpars.connector

import groovyx.gpars.dataflow.DataflowVariable
import it.cnr.isti.hlt.processfast.connector.ConnectorMessage

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class GParsConnectorMessage implements ConnectorMessage {

    final Serializable payload
    final DataflowVariable replyTo

    /**
     * Build new instance.
     *
     * @param payload The payload to wrap.
     * @param replyTo If different from 'null', specify the dataflow variable
     * where to reply to sender.
     */
    GParsConnectorMessage(Serializable payload, DataflowVariable replyTo) {
        if (payload == null)
            throw new NullPointerException("The specified payload is 'null'")
        this.payload = payload
        this.replyTo = replyTo
    }


    @Override
    boolean isWaitingReply() {
        return replyTo != null
    }

    @Override
    void replyValue(Serializable v) {
        if (replyTo == null)
            throw new IllegalStateException("This object has not dataflow variable where to reply a message")

    }
}
