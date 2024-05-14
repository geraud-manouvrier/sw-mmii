package cl.qande.mmii.app.models.exception;

public class SflPershingException extends QandeMmiiException {

    public SflPershingException(Exception exception, String customErrorMsg) {
        super(exception, customErrorMsg);
    }

    public SflPershingException(String customErrorMsg, String archivo) {
        super(customErrorMsg + " - Archivo ["+archivo+"]");
    }

}
