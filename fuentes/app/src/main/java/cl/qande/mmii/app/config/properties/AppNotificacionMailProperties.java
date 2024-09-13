package cl.qande.mmii.app.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "app.properties.notificacion-mail")
@ConstructorBinding
public class AppNotificacionMailProperties {

    private final NotificacionMailConfiguration reportesMaestros;
    private final NotificacionMailConfiguration controlDiario;
    private final NotificacionMailConfiguration sflPershing;
    private final NotificacionMailConfiguration cuentasNoMapeadas;
    private final NotificacionMailConfiguration parametrosSuracorp;

    public AppNotificacionMailProperties(NotificacionMailConfiguration reportesMaestros, NotificacionMailConfiguration controlDiario, NotificacionMailConfiguration sflPershing, NotificacionMailConfiguration cuentasNoMapeadas, NotificacionMailConfiguration parametrosSuracorp) {
        this.reportesMaestros = reportesMaestros;
        this.controlDiario = controlDiario;
        this.sflPershing = sflPershing;
        this.cuentasNoMapeadas = cuentasNoMapeadas;
        this.parametrosSuracorp = parametrosSuracorp;
    }

    public NotificacionMailConfiguration getReportesMaestros() {
        return reportesMaestros;
    }


    public NotificacionMailConfiguration getControlDiario() {
        return controlDiario;
    }


    public NotificacionMailConfiguration getSflPershing() {
        return sflPershing;
    }

    public NotificacionMailConfiguration getCuentasNoMapeadas() {
        return cuentasNoMapeadas;
    }

    public NotificacionMailConfiguration getParametrosSuracorp() {
        return parametrosSuracorp;
    }

    public static class NotificacionMailConfiguration {
        @NotBlank
        private final String senderName;
        @NotBlank
        private final String recipientTo;
        @NotBlank
        private final String recipientCc;
        @NotNull
        private final String recipientBcc;
        @NotBlank
        private final String recipientErrorTo;
        @NotBlank
        private final String recipientErrorCc;
        @NotNull
        private final String recipientErrorBcc;
        @NotBlank
        private final String defaultSubject;

        @SuppressWarnings("squid:S00107")
        public NotificacionMailConfiguration(String senderName, String recipientTo, String recipientCc, String recipientBcc, String recipientErrorTo, String recipientErrorCc, String recipientErrorBcc, String defaultSubject) {
            this.senderName = senderName;
            this.recipientTo = recipientTo;
            this.recipientCc = recipientCc;
            this.recipientBcc = recipientBcc;
            this.recipientErrorTo = recipientErrorTo;
            this.recipientErrorCc = recipientErrorCc;
            this.recipientErrorBcc = recipientErrorBcc;
            this.defaultSubject = defaultSubject;
        }

        public String getSenderName() {
            return senderName;
        }

        public String getRecipientTo() {
            return recipientTo;
        }

        public String getRecipientCc() {
            return recipientCc;
        }

        public String getRecipientBcc() {
            return recipientBcc;
        }

        public String getRecipientErrorTo() {
            return recipientErrorTo;
        }

        public String getRecipientErrorCc() {
            return recipientErrorCc;
        }

        public String getRecipientErrorBcc() {
            return recipientErrorBcc;
        }

        public String getDefaultSubject() {
            return defaultSubject;
        }

    }

}
