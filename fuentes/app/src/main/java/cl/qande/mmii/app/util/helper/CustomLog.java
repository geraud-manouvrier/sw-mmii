package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.util.SesionWeb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.UUID;

@Component
public class CustomLog implements ApplicationContextAware {

    private static final String MSG_INFO    = "INFO";
    private static final String MSG_DEBUG    = "DEBUG";
    private static final String MSG_ERROR    = "ERROR";
    private static final String MSG_PATTERN    = "[{}] - {} - [{}]";
    private static final int INDEX_STACK    = 3;

    private UUID uuid;
    private static CustomLog instance;
    private static ApplicationContext applicationContext;

    private CustomLog() {
        this.uuid = UUID.randomUUID();
    }

    public static CustomLog getInstance() {
        if (instance == null) {
            instance = new CustomLog();
        }
        return instance;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    private <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    private void log(String msg, String typeLog) {
        var className   = Thread.currentThread().getStackTrace()[INDEX_STACK].getClassName();
        var methodName  = Thread.currentThread().getStackTrace()[INDEX_STACK].getMethodName();
        Logger log = LoggerFactory.getLogger(className);
        switch (typeLog) {
            case MSG_INFO:
                log.info(MSG_PATTERN, methodName, msg, getLogUuid());
                break;
            case MSG_ERROR:
                log.error(MSG_PATTERN, methodName, msg, getLogUuid());
                break;
            case MSG_DEBUG:
            default:
                log.debug(MSG_PATTERN, methodName, msg, getLogUuid());
                break;
        }
    }
    private UUID getLogUuid() {
        var sesionWeb   = getSesionWeb();
        if (sesionWeb!=null && sesionWeb.getUuid()!=null)
            return sesionWeb.getUuid();
        return this.uuid;
    }

    private void addWebNotification(String msg) {
        var sesionWeb   = getSesionWeb();
        if (sesionWeb!=null && sesionWeb.getUuid()!=null)
            sesionWeb.addNotification(msg);
    }

    private SesionWeb getSesionWeb() {
        // Verifica si hay atributos de solicitud (request) activos
        if (RequestContextHolder.getRequestAttributes() == null) {
            // No hay una solicitud activa, retorna null sin intentar obtener el bean
            return null;
        }
        try {
            return getBean(SesionWeb.class);
        } catch (Exception e) {
            return null;
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
