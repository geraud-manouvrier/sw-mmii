package cl.qande.mmii.app.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@ConfigurationProperties(prefix = "app.properties.config.scheduling")
@ConstructorBinding
public class AppSchedulingProperties {

    @NotBlank
    private final String cronReportesMaestros;
    @NotBlank
    private final String cronControlDiario;
    @NotBlank
    private final String cronFtpPershing;
    @NotBlank
    private final String cronMallaDiaria;
    @NotBlank
    private final String cronCuentasNoMapeadas;

    public AppSchedulingProperties(String cronReportesMaestros, String cronControlDiario, String cronFtpPershing, String cronMallaDiaria, String cronCuentasNoMapeadas) {
        this.cronReportesMaestros = cronReportesMaestros;
        this.cronControlDiario = cronControlDiario;
        this.cronFtpPershing = cronFtpPershing;
        this.cronMallaDiaria = cronMallaDiaria;
        this.cronCuentasNoMapeadas = cronCuentasNoMapeadas;
    }

    public String getCronReportesMaestros() {
        return cronReportesMaestros;
    }

    public String getCronControlDiario() {
        return cronControlDiario;
    }

    public String getCronFtpPershing() {
        return cronFtpPershing;
    }

    public String getCronMallaDiaria() {
        return cronMallaDiaria;
    }

    public String getCronCuentasNoMapeadas() {
        return cronCuentasNoMapeadas;
    }
}
