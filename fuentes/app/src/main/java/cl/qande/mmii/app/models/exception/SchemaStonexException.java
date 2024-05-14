package cl.qande.mmii.app.models.exception;

public class SchemaStonexException extends QandeMmiiException {

    public SchemaStonexException(Exception exception, String customErrorMsg, String processDate, String processStamp) {
        super(exception, customErrorMsg +" - Fecha proceso ["+processDate+"] y marca de tiempo ["+processStamp+"]");
    }

    public SchemaStonexException(String customErrorMsg, String processDate, String processStamp) {
        super(customErrorMsg + " - Fecha proceso ["+processDate+"] y marca de tiempo ["+processStamp+"]");
    }

}
