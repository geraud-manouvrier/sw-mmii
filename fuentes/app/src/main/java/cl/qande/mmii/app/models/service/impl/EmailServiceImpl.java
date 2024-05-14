package cl.qande.mmii.app.models.service.impl;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.mail.EmailDetails;
import cl.qande.mmii.app.models.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements IEmailService {
    private static final String MSG_MAIL_OFF    = "Mailing desactivado... omitiendo mail: ";
    private static final String MSG_MAIL_ERROR    = "Error al enviar correo";
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${app.properties.mailing.enabled}") private boolean mailingEnabled;

    //https://www.geeksforgeeks.org/spring-boot-sending-email-via-smtp/
    public void sendSimpleMail(EmailDetails details) throws QandeMmiiException {

        if (!mailingEnabled) {
            appConfig.customLog.info(MSG_MAIL_OFF+details.toString());
            return;
        }
        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(details.getSenderName());
            mailMessage.setTo(details.getRecipientsTo());
            mailMessage.setCc(details.getRecipientsCc());
            mailMessage.setBcc(details.getRecipientsBcc());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            throw new QandeMmiiException(e, MSG_MAIL_ERROR);
        }
    }

    //TODO: Crear mail HTML
    /*
    https://mailtrap.io/blog/spring-send-email/#How-to-send-HTML-emails-in-Spring-Boot
    https://stackoverflow.com/questions/5289849/how-do-i-send-html-email-in-spring-mvc
    */
    public void sendHtmlMail(EmailDetails details) throws QandeMmiiException {
        if (!mailingEnabled) {
            appConfig.customLog.info(MSG_MAIL_OFF+details.toString());
            return;
        }
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(details.getSenderName());
            mimeMessageHelper.setTo(details.getRecipientsTo());
            mimeMessageHelper.setCc(details.getRecipientsCc());
            mimeMessageHelper.setBcc(details.getRecipientsBcc());
            mimeMessageHelper.setText(details.getMsgBody(), true);
            mimeMessageHelper.setSubject(
                    details.getSubject());
        } catch (MessagingException e) {
            throw new QandeMmiiException(e, MSG_MAIL_ERROR);
        }
        javaMailSender.send(mimeMessage);
    }

    public void sendMailWithAttachment(EmailDetails details) throws QandeMmiiException
    {
        if (!mailingEnabled) {
            appConfig.customLog.info(MSG_MAIL_OFF+details.toString());
            return;
        }
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(details.getSenderName());
            mimeMessageHelper.setTo(details.getRecipientsTo());
            mimeMessageHelper.setCc(details.getRecipientsCc());
            mimeMessageHelper.setBcc(details.getRecipientsBcc());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
        }
        // Catch block to handle MessagingException
        catch (javax.mail.MessagingException e) {
            throw new QandeMmiiException(e, MSG_MAIL_ERROR);
        }
    }
}
