package cl.qande.mmii.app.models.exception;

public class DaoException extends QandeMmiiException {

    public DaoException(Exception exception, String customErrorMsg) {
        super(exception, customErrorMsg);
    }

    public DaoException(String customErrorMsg) {
        super(customErrorMsg);
    }

}
