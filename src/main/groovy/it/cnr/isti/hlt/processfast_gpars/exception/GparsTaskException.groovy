package it.cnr.isti.hlt.processfast_gpars.exception

import it.cnr.isti.hlt.processfast.exception.TaskException

/**
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 */
class GparsTaskException extends Exception implements TaskException {
    final String taskName
    final String virtualMachineName

    GparsTaskException(String vmName, String taskName, String message, Throwable t) {
        super(message, t)
        if (vmName == null)
            throw new IllegalArgumentException("The VM name is 'null'")
        if (taskName == null || taskName.empty)
            throw new IllegalArgumentException("The task name is 'null' or empty")
        if (message == null)
            throw new IllegalArgumentException("The message is 'null'")
        if (t == null)
            throw new NullPointerException("The causing throwable is 'null'")
        this.virtualMachineName = vmName
        this.taskName = taskName
    }

    Throwable getCausingThrowable() {
        return cause
    }


    @Override
    public String toString() {
        return "Task exception details\n" +
                "VM name: ${virtualMachineName}\n" +
                "TaskName: ${taskName},\n" +
                "Message: ${message},\n" +
                "CausingThrowable: ${causingThrowable.toString()}"
    }
}
