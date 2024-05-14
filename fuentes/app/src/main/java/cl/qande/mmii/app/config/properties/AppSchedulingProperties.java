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
    private final String cronFtpStonexAll;
    @NotBlank
    private final String cronReportesMaestros;
    @NotBlank
    private final String cronReportesIngresosEgresos;
    @NotBlank
    private final String cronControlDiario;
    @NotBlank
    private final String cronCargaMaestrosFtpChile;
    @NotBlank
    private final String cronFtpPershing;
    @NotBlank
    private final String cronMallaDiaria;
    @NotBlank
    private final String cronReporteInversiones;

    public AppSchedulingProperties(String cronFtpStonexAll, String cronReportesMaestros, String cronReportesIngresosEgresos, String cronControlDiario, String cronCargaMaestrosFtpChile, String cronFtpPershing, String cronMallaDiaria, String cronReporteInversiones) {
        this.cronFtpStonexAll = cronFtpStonexAll;
        this.cronReportesMaestros = cronReportesMaestros;
        this.cronReportesIngresosEgresos = cronReportesIngresosEgresos;
        this.cronControlDiario = cronControlDiario;
        this.cronCargaMaestrosFtpChile = cronCargaMaestrosFtpChile;
        this.cronFtpPershing = cronFtpPershing;
        this.cronMallaDiaria = cronMallaDiaria;
        this.cronReporteInversiones = cronReporteInversiones;
    }

    public String getCronFtpStonexAll() {
        return cronFtpStonexAll;
    }

    public String getCronReportesMaestros() {
        return cronReportesMaestros;
    }

    public String getCronReportesIngresosEgresos() {
        return cronReportesIngresosEgresos;
    }

    public String getCronControlDiario() {
        return cronControlDiario;
    }

    public String getCronCargaMaestrosFtpChile() {
        return cronCargaMaestrosFtpChile;
    }

    public String getCronFtpPershing() {
        return cronFtpPershing;
    }

    public String getCronMallaDiaria() {
        return cronMallaDiaria;
    }

    public String getCronReporteInversiones() {
        return cronReporteInversiones;
    }
}
