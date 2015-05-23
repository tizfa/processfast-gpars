package it.cnr.isti.hlt.processfast_gpars.test

import groovyx.gpars.dataflow.DataflowBroadcast
import groovyx.gpars.dataflow.DataflowQueue
import groovyx.gpars.dataflow.DataflowVariable
import groovyx.gpars.dataflow.operator.DataflowProcessor
import groovyx.gpars.dataflow.operator.PoisonPill
import groovyx.gpars.group.DefaultPGroup
import groovyx.gpars.group.NonDaemonPGroup
import groovyx.gpars.remote.BroadcastDiscovery
import it.cnr.isti.hlt.processfast_gpars.connector.GParsLoadBalancingQueueConnector
import it.cnr.isti.hlt.processfast_gpars.connector.GParsTaskLoadBalancingQueueConnector

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class GParsLoadBalancingQueueTest {

    static def main(args) {
        def tasksGroup = new DefaultPGroup(10)
        // def tasksGroup = new NonDaemonPGroup()
        tasksGroup.with {
            int numConsumers = 3

            DataflowBroadcast dv = new DataflowBroadcast()
            def rc1 = dv.createReadChannel()
            def readChannels = []
            for (int i = 0; i < numConsumers; i++) {
                readChannels << dv.createReadChannel()
            }

            GParsLoadBalancingQueueConnector sharedQueue = new GParsLoadBalancingQueueConnector(10)

            def op1 = operator([rc1], []) {
//            def op1 = task {
                GParsTaskLoadBalancingQueueConnector queue = new GParsTaskLoadBalancingQueueConnector(sharedQueue)
                (1..10).each {
                    //sleep(new Random().nextInt(1000))
                    println("Val write: ${it}")
                    queue.putValue(it)

                }

                queue.signalEndOfStream()
                println("Sender ends!")
            }





            def operators = []
            for (int i = 0; i < numConsumers; i++) {
                def op2 = operator([readChannels[i]], []) {
                    //def op2 = task {
                    GParsTaskLoadBalancingQueueConnector queue = new GParsTaskLoadBalancingQueueConnector(sharedQueue)
                    println("Operator start ${i}")
                    while (true) {
                        def msg = queue.getValue()
                        if (msg == null)
                            break
                        def v = msg.payload

                        println("Val read: ${v}")
                    }

                    println("Operator 2 ended!")

                    dv << PoisonPill.instance
                }

                operators << op2
            }

            dv << true
            //dv << PoisonPill.instance

            op1.join()
            operators*.join()

        }

        tasksGroup.shutdown()
    }

}
