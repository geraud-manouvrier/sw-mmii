package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.mail.EmailDetails;
public interface IEmailService {

    void sendSimpleMail(EmailDetails details) throws QandeMmiiException;
    void sendHtmlMail(EmailDetails details) throws QandeMmiiException;
    void sendMailWithAttachment(EmailDetails details) throws QandeMmiiException;
}
