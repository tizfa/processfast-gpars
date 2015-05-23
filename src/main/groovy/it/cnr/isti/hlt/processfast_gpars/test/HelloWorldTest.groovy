package it.cnr.isti.hlt.processfast_gpars.test

import it.cnr.isti.hlt.processfast.connector.ConnectorCapability
import it.cnr.isti.hlt.processfast.connector.ConnectorType
import it.cnr.isti.hlt.processfast.data.RamDictionary
import it.cnr.isti.hlt.processfast_gpars.core.GParsRuntime

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class HelloWorldTest {
    static def main(args) {
        GParsRuntime runtime = new GParsRuntime()
        def ts = runtime.createTaskSet()

        ts.onTasksSetInitialization({ sc ->
            sc.logManager.getLogger("test").info("Program starting....")
        })

        ts.onTasksSetTermination({ sc ->
            sc.logManager.getLogger("test").info("Program ending....")
        })

        ts.createConnector("msg", ConnectorType.LOAD_BALANCING_QUEUE)
        RamDictionary d = new RamDictionary()
        d.put("numMessages", 10)

        ts.task { tc ->
            def r = new Random()
            int numMessages = tc.privateTaskDataDictionary.get("numMessages")
            def c = tc.connectorManager.getConnectorWriter("msg")
            for (int i = 0; i < numMessages; i++) {
                def v = r.nextInt(1000)
                tc.logManager.getLogger("messages").info("Sender ${tc.taskName}: sending msg #${i + 1}: Value: ${v}")
                c.putValue(v)
            }
            tc.logManager.getLogger("messages").info("Sender ${tc.taskName}: sent all data!")
            c.signalEndOfStream()
        }.withDataDictionary(d, { wddi ->
            wddi.dataDictionary
        }).withConnectors { wci ->
            wci.connectorManager.attachTaskToConnector(wci.taskName, "msg", ConnectorCapability.WRITE)
        }.withNumInstances(1, 1).withName { ni -> "se" }

        ts.task { tc ->
            def c = tc.connectorManager.getConnectorReader("msg")
            while (true) {
                def v = c.value
                if (v == null)
                    break
                tc.logManager.getLogger("messages").info("Receiver ${tc.taskName}: The square of ${v.payload} is ${v.payload**2}")
                sleep(new Random().nextInt(1000))
            }
            tc.logManager.getLogger("messages").info("Receiver ${tc.taskName}: received all data!")
        }.withDataDictionary(d, { wddi ->
            wddi.dataDictionary
        }).withConnectors { wci ->
            wci.connectorManager.attachTaskToConnector(wci.taskName, "msg", ConnectorCapability.READ)
        }.withNumInstances(2, 2).withName {
            ni -> "re_${ni}"
        }


        runtime.run(ts)
    }
}
