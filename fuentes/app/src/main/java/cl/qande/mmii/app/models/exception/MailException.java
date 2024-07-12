package cl.qande.mmii.app.models.exception;

public class MailException extends QandeMmiiException {
        public MailException(Exception exception, String customErrorMsg) {
            super(exception, customErrorMsg);
        }
}
