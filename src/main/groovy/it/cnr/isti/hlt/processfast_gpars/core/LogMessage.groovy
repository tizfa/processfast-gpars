package it.cnr.isti.hlt.processfast_gpars.core

import it.cnr.isti.hlt.processfast.core.LogLevel

/**
 * An internal log message record exchanged with logger operator.
 *
 * @author Tiziano Fagni (tiziano.fagni@isti.cnr.it)
 * @since 1.0.0
 */
class LogMessage implements Serializable {

    /**
     * The logger name.
     */
    String loggerName

    /**
     * The level of message.
     */
    LogLevel level

    /**
     * The message to log.
     */
    String message

    /**
     * The optional throwable to log.
     */
    Throwable throwable

    /**
     * Indicate if this message is used to set the default log level. If true, only {@link #loggerName} and
     * {@link #level} properties will be used.
     */
    boolean settingDefaultLogLevel = false
}
