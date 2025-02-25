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
    @NotBlank
    private final String cronParametrosSuraCorp;
    @NotBlank
    private final String cronReporteInversiones;
    @NotBlank
    private final String cronReporteInversionesControles;

    public AppSchedulingProperties(String cronReportesMaestros, String cronControlDiario, String cronFtpPershing, String cronMallaDiaria, String cronCuentasNoMapeadas, String cronParametrosSuraCorp, String cronReporteInversiones, String cronReporteInversionesControles) {
        this.cronReportesMaestros = cronReportesMaestros;
        this.cronControlDiario = cronControlDiario;
        this.cronFtpPershing = cronFtpPershing;
        this.cronMallaDiaria = cronMallaDiaria;
        this.cronCuentasNoMapeadas = cronCuentasNoMapeadas;
        this.cronParametrosSuraCorp = cronParametrosSuraCorp;
        this.cronReporteInversiones = cronReporteInversiones;
        this.cronReporteInversionesControles = cronReporteInversionesControles;
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

    public @NotBlank String getCronParametrosSuraCorp() {
        return cronParametrosSuraCorp;
    }

    public @NotBlank String getCronReporteInversiones() {
        return cronReporteInversiones;
    }

    public @NotBlank String getCronReporteInversionesControles() {
        return cronReporteInversionesControles;
    }
}
