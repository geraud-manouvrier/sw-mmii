package cl.qande.mmii.app.models.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QandeMmiiException extends Exception {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String HEADER_ERROR_MSG   = "ERROR [QandeMmiiException]: ";

    public QandeMmiiException(Exception exception, String customErrorMsg) {
        super(exception);
        customLogError("["+exception.getClass().getName()+"]: " + exception.getMessage() + "||" + customErrorMsg);
    }
    public QandeMmiiException(String customErrorMsg) {
        super(customErrorMsg);
        customLogError(customErrorMsg);
    }

    private void customLogError(String msgError) {
        log.error("{} {}", HEADER_ERROR_MSG, msgError);
    }
}
