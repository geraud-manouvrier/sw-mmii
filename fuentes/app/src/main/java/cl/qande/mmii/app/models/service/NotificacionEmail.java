package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.FeeControlResponse;
import cl.qande.mmii.app.models.api_clients.mmii_suracorp.ParSourceCode;
import cl.qande.mmii.app.models.db.core.entity.ControlDiario;
import cl.qande.mmii.app.models.db.core.entity.VwCuentasNoMapeadasPershingProjection;
import cl.qande.mmii.app.models.db.core.entity.VwReporteDiferenciasFee;
import cl.qande.mmii.app.models.db.rep_inv.entity.ResultadoControl;
import cl.qande.mmii.app.models.exception.MailException;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.mail.EmailDetails;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.mapper.EntityToHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionEmail {

    private static final String SUBJECT_OK = " - OK ";
    private static final String SUBJECT_ERROR = " - ERROR ";
    private final EmailService emailService;
    private final AppNotificacionMailProperties appNotificacionMailProperties;

    @Autowired
    public NotificacionEmail(EmailService emailService, AppNotificacionMailProperties appNotificacionMailProperties) {
        this.emailService = emailService;
        this.appNotificacionMailProperties = appNotificacionMailProperties;
    }

    public AppNotificacionMailProperties getAppNotificacionMailProperties() {
        return appNotificacionMailProperties;
    }


    private String generaDetalle(String detalle) {
        return detalle.isEmpty() ? "" : " Detalle: ["+detalle+"]";
    }
    private String generaTituloHtml(String titulo) {
        return "<h1>"+titulo+"</h1></br></br>";
    }

    public void notificarErrorReportesMaestros(String processDate, String detalle) throws QandeMmiiException {
        var mensaje = "Error al generar reportes maestros para fecha proceso ["+processDate+"]." + this.generaDetalle(detalle);
        var asunto  = appNotificacionMailProperties.getReportesMaestros().getDefaultSubject()+SUBJECT_ERROR+processDate;
        var recipients  = new String[]{appNotificacionMailProperties.getReportesMaestros().getRecipientErrorTo(),
                appNotificacionMailProperties.getReportesMaestros().getRecipientErrorCc(),
                appNotificacionMailProperties.getReportesMaestros().getRecipientErrorBcc()};
        this.enviaMail(mensaje, asunto, appNotificacionMailProperties.getReportesMaestros(), recipients);
    }
    public void notificarOkReportesMaestros(String processDate) throws QandeMmiiException {
        var mensaje = "Reportes maestros para fecha proceso ["+processDate+"] generados correctamente.";
        var asunto  = appNotificacionMailProperties.getReportesMaestros().getDefaultSubject()+SUBJECT_OK+processDate;
        var recipients  = new String[]{appNotificacionMailProperties.getReportesMaestros().getRecipientTo(),
                appNotificacionMailProperties.getReportesMaestros().getRecipientCc(),
                appNotificacionMailProperties.getReportesMaestros().getRecipientBcc()};
        this.enviaMail(mensaje, asunto, appNotificacionMailProperties.getReportesMaestros(), recipients);
    }

    public void notificarErrorControlDiario(String processDate, String detalle) throws QandeMmiiException {
        var mensaje = "Error al realizar control diario para fecha proceso ["+processDate+"]." + this.generaDetalle(detalle);
        var asunto  = appNotificacionMailProperties.getControlDiario().getDefaultSubject()+SUBJECT_ERROR+processDate;
        var recipients  = new String[]{appNotificacionMailProperties.getControlDiario().getRecipientErrorTo(),
                appNotificacionMailProperties.getControlDiario().getRecipientErrorCc(),
                appNotificacionMailProperties.getControlDiario().getRecipientErrorBcc()};
        this.enviaMail(mensaje, asunto, appNotificacionMailProperties.getControlDiario(), recipients);
    }

    public void notificarOkControlDiario(String processDate, List<ControlDiario> resultado) throws QandeMmiiException {
        var mensaje = this.generaTituloHtml("Resultado del control diario para fecha proceso ["+processDate+"]");
        mensaje     = mensaje+ EntityToHtml.resultadoControlDiarioToHtml(resultado, "");
        var asunto  = appNotificacionMailProperties.getControlDiario().getDefaultSubject()+SUBJECT_OK+processDate;
        var recipients  = new String[]{appNotificacionMailProperties.getControlDiario().getRecipientTo(),
                appNotificacionMailProperties.getControlDiario().getRecipientCc(),
                appNotificacionMailProperties.getControlDiario().getRecipientBcc()};
        this.enviaMail(mensaje, asunto, appNotificacionMailProperties.getControlDiario(), recipients);
    }
    public void notificarErrorProcesoSflFtpPershing(String processDate, String detalle) throws QandeMmiiException {
        var mensaje = "Error al procesar SFL Pershing para fecha proceso ["+processDate+"]." + this.generaDetalle(detalle);
        var asunto  = appNotificacionMailProperties.getSflPershing().getDefaultSubject()+SUBJECT_ERROR+processDate;
        var recipients  = new String[]{appNotificacionMailProperties.getSflPershing().getRecipientErrorTo(),
                appNotificacionMailProperties.getSflPershing().getRecipientErrorCc(),
                appNotificacionMailProperties.getSflPershing().getRecipientErrorBcc()};
        this.enviaMail(mensaje, asunto, appNotificacionMailProperties.getSflPershing(), recipients);
    }
    public void notificarOkProcesoSflFtpPershing(String processDate) throws QandeMmiiException {
        var mensaje = "SFL Pershing para fecha proceso ["+processDate+"] procesados correctamente.";
        var asunto  = appNotificacionMailProperties.getSflPershing().getDefaultSubject()+SUBJECT_OK+processDate;
        var recipients  = new String[]{appNotificacionMailProperties.getSflPershing().getRecipientTo(),
                appNotificacionMailProperties.getSflPershing().getRecipientCc(),
                appNotificacionMailProperties.getSflPershing().getRecipientBcc()};
        this.enviaMail(mensaje, asunto, appNotificacionMailProperties.getSflPershing(), recipients);
    }

    public void notificarJobCuentasNoMapeadas(String processDate, boolean flagOk, List<VwCuentasNoMapeadasPershingProjection> detalle) throws MailException {
        var mailConfiguration = appNotificacionMailProperties.getCuentasNoMapeadas();
        var mensaje = this.generaTituloHtml("Listado Cuentas No Mapeadas para fecha proceso ["+processDate+"]") + EntityToHtml.resultadoCuentaNoMapeadasToHtml(detalle);
        var asunto  = generaAsunto(mailConfiguration.getDefaultSubject(), flagOk, processDate);
        this.enviaMail(mensaje, asunto, mailConfiguration, flagOk);
    }

    public void notificarJobParametrosFromSuracorp(boolean isOk, String startProcessDate, String endProcessDate, String jobName, ParSourceCode[][] resultado, String msg) {
        var mailConfiguration   = appNotificacionMailProperties.getParametrosSuracorp();
        notificacionGenerica(isOk, startProcessDate, endProcessDate, jobName, EntityToHtml.resultadoParametrosSuracorpToHtml(resultado, msg), mailConfiguration);

    }

    public void notificarJobMallaDiaria(boolean isOk, String startProcessDate, String endProcessDate, String jobName, String msg) {
        var mailConfiguration   = appNotificacionMailProperties.getMallaDiaria();
        notificacionGenerica(isOk, startProcessDate, endProcessDate, jobName, msg, mailConfiguration);

    }
    public void notificaJobPreCaulculoRentabilidadesDiario(boolean isOk, String startProcessDate, String jobName, String msg) {
        var mailConfiguration   = appNotificacionMailProperties.getPrecalculoRentabilidades();
        notificacionGenerica(isOk, startProcessDate, startProcessDate, jobName, msg, mailConfiguration);
    }
    public void notificaJobControlRepInv(boolean isOk, String startProcessDate, String endProcessDate, String jobName, List<ResultadoControl> resultado, String msg) {
        var mailConfiguration   = appNotificacionMailProperties.getRepinvControl();
        notificacionGenerica(isOk, startProcessDate, endProcessDate, jobName, EntityToHtml.resultadoControlRepInvToHtml(resultado, msg), mailConfiguration);
    }
    public void notificaJob(boolean isOk, String startProcessDate, String endProcessDate, String jobName, List<VwReporteDiferenciasFee> resultado, String msg, AppNotificacionMailProperties.NotificacionMailConfiguration mailConfiguration)  {
        notificacionGenerica(isOk, startProcessDate, endProcessDate, jobName, EntityToHtml.resultadoJobToHtml(resultado, msg), mailConfiguration);
    }
    public void notificaJob(boolean isOk, String startProcessDate, String endProcessDate, String jobName, FeeControlResponse resultado, String msg, AppNotificacionMailProperties.NotificacionMailConfiguration mailConfiguration)  {
        notificacionGenerica(isOk, startProcessDate, endProcessDate, jobName, EntityToHtml.resultadoJobToHtml(resultado, msg), mailConfiguration);
    }


    /********************************
     * Funciones auxiliares
     ********************************/

    private void notificacionGenerica(boolean isOk, String startProcessDate, String endProcessDate, String jobName, String detalle, AppNotificacionMailProperties.NotificacionMailConfiguration mailConfiguration) {
        var recipients          = getRecipients(isOk, mailConfiguration);
        var mensaje             = generaBodyHtml(isOk, startProcessDate, endProcessDate, jobName, detalle);
        var asunto              = mailConfiguration.getDefaultSubject()+(isOk ? SUBJECT_OK : SUBJECT_ERROR)+"["+startProcessDate+" - "+endProcessDate+"]";
        try {
            this.enviaMail(mensaje, asunto, mailConfiguration, recipients);
            CustomLog.getInstance().info("Mail para job ["+jobName+"] con fechas ["+startProcessDate+"-"+endProcessDate+"] procesado.");
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error enviando mail para job ["+jobName+"] con fechas ["+startProcessDate+"-"+endProcessDate+"]: "+e.getMessage());
            CustomLog.getInstance().info("Detalle mail para job ["+jobName+"] con fechas ["+startProcessDate+"-"+endProcessDate+"]: "+detalle);
        }

    }

    private String generaBodyHtml(boolean isOk, String startProcessDate, String endProcessDate, String jobName, String resultadoHtml) {
        var mensaje = "Job "+jobName+" finalizado "+(isOk ? "OK" : "con errores")+" para fecha proceso ["+startProcessDate+" - "+endProcessDate+"]";
        mensaje     = mensaje+"<br>"+resultadoHtml;
        return mensaje;
    }

    private String[] getRecipients(boolean isOk, AppNotificacionMailProperties.NotificacionMailConfiguration mailConfiguration) {
        if (isOk) {
            return new String[]{mailConfiguration.getRecipientTo(),
                    mailConfiguration.getRecipientCc(),
                    mailConfiguration.getRecipientBcc()};
        } else {
            return new String[]{mailConfiguration.getRecipientErrorTo(),
                    mailConfiguration.getRecipientErrorCc(),
                    mailConfiguration.getRecipientErrorBcc()};
        }
    }

    private String generaAsunto(String defaultSubject, boolean flagOk, String complemento) {
        return defaultSubject + (flagOk ? SUBJECT_OK : SUBJECT_ERROR) + complemento;

    }

    private void enviaMail(String mensaje, String asunto, AppNotificacionMailProperties.NotificacionMailConfiguration mailConfiguration, boolean flagOk) throws MailException {
        String[] recipients;
        if (flagOk) {
            recipients = new String[]{mailConfiguration.getRecipientTo(),
                    mailConfiguration.getRecipientCc(),
                    mailConfiguration.getRecipientBcc()};
        } else {
            recipients = new String[]{mailConfiguration.getRecipientErrorTo(),
                    mailConfiguration.getRecipientErrorCc(),
                    mailConfiguration.getRecipientErrorBcc()};
        }
        var mailDetail = new EmailDetails();
        mailDetail.setSenderName(mailConfiguration.getSenderName());
        mailDetail.setRecipientsTo(recipients[0]);
        mailDetail.setRecipientsCc(recipients[1]);
        mailDetail.setRecipientsBcc(recipients[2]);

        mailDetail.setMsgBody(mensaje);
        mailDetail.setSubject(asunto.isEmpty() ? mailConfiguration.getDefaultSubject() : asunto);

        try {
            emailService.sendHtmlMail(mailDetail);
        } catch (QandeMmiiException e) {
            throw new MailException(e, "Error al enviar mail : ["+e.getMessage()+"]");
        }
    }

    private void enviaMail(String mensaje, String asunto, AppNotificacionMailProperties.NotificacionMailConfiguration mailConfiguration, String[] recipients) throws QandeMmiiException {
        var mailDetail = new EmailDetails();
        mailDetail.setSenderName(mailConfiguration.getSenderName());
        mailDetail.setRecipientsTo(recipients[0]);
        mailDetail.setRecipientsCc(recipients[1]);
        mailDetail.setRecipientsBcc(recipients[2]);

        mailDetail.setMsgBody(mensaje);
        mailDetail.setSubject(asunto.isEmpty() ? mailConfiguration.getDefaultSubject() : asunto);

        try {
            emailService.sendHtmlMail(mailDetail);
        } catch (QandeMmiiException e) {
            throw new QandeMmiiException(e, "Error al enviar mail : ["+e.getMessage()+"]");
        }
    }
}
