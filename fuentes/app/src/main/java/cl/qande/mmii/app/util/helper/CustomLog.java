package cl.qande.mmii.app.util.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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
    private static final int MAX_CANT_NOTIF    = 100;

    private UUID uuid;
    private List<String> notifications = new ArrayList<>();

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    private void log(String msg, String typeLog, String userMsg) {
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
        if (userMsg!=null) {
            this.addNotification(userMsg);
        }
    }

    public void info(String msg) {
        this.log(msg, MSG_INFO, null);
    }
    public void info(String msg, String userMsg) {
        this.log(msg, MSG_INFO, userMsg);
    }

    public void error(String msg) {
        this.log(msg, MSG_ERROR, null);
    }
    public void error(String msg, String userMsg) {
        this.log(msg, MSG_ERROR, userMsg);
    }

    public void debug(String msg) {
        this.log(msg, MSG_DEBUG, null);
    }
    public void debug(String msg, String userMsg) {
        this.log(msg, MSG_DEBUG, userMsg);
    }

    public synchronized void addNotification(String message) {
        if (notifications.size() >= MAX_CANT_NOTIF) {
            notifications.remove(0);
        }
        notifications.add(message);
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void clearNotifications() {
        notifications.clear();
    }

}
