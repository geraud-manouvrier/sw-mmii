package cl.qande.mmii.app.util.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomLog {

    /*
    TODO:
     -Migrar a LOG4J2
     -Múltiples appender: app y otro para jobs
     -Async
     -Log into DB
     -Log into cloud (syslog u otro)

     https://www.baeldung.com/log4j2-appenders-layouts-filters
     https://www.baeldung.com/java-logging-intro
     https://logging.apache.org/log4j/2.x/
     https://logging.apache.org/log4j/2.x/manual/async.html
     https://logging.apache.org/log4j/2.x/manual/appenders.html
     */
    private static final String MSG_INFO    = "INFO";
    private static final String MSG_DEBUG    = "DEBUG";
    private static final String MSG_ERROR    = "ERROR";
    private static final String MSG_PATTERN    = "[{}] - {} - [{}]";
    private static final int INDEX_STACK    = 3;

    private UUID uuid;

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    private void log(String msg, String typeLog) {
        var className   = Thread.currentThread().getStackTrace()[INDEX_STACK].getClassName();
        var methodName  = Thread.currentThread().getStackTrace()[INDEX_STACK].getMethodName();
        Logger log = LoggerFactory.getLogger(className);
        switch (typeLog) {
            case MSG_INFO:
                log.info(MSG_PATTERN, methodName, msg, this.uuid);
                break;
            case MSG_ERROR:
                log.error(MSG_PATTERN, methodName, msg, this.uuid);
                break;
            case MSG_DEBUG:
            default:
                log.debug(MSG_PATTERN, methodName, msg, this.uuid);
                break;
        }
    }

    public void info(String msg) {
        this.log(msg, MSG_INFO);
    }

    public void error(String msg) {
        this.log(msg, MSG_ERROR);
    }

    public void debug(String msg) {
        this.log(msg, MSG_DEBUG);
    }

}
