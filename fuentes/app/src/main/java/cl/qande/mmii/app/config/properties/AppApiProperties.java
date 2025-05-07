package cl.qande.mmii.app.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "app.properties.config.api")
@ConstructorBinding
public class AppApiProperties {

    @NotNull
    private final boolean enabledGlobal;
    @NotNull
    private final boolean enabledArchivos;
    @NotNull
    private final boolean enabledReportesMaestros;
    @NotNull
    private final boolean enabledRetornos;

    public AppApiProperties(boolean enabledGlobal, boolean enabledArchivos, boolean enabledReportesMaestros, boolean enabledRetornos) {
        this.enabledGlobal = enabledGlobal;
        this.enabledArchivos = enabledArchivos;
        this.enabledReportesMaestros = enabledReportesMaestros;
        this.enabledRetornos = enabledRetornos;
    }

    public boolean isEnabledGlobal() {
        return enabledGlobal;
    }

    public boolean isEnabledArchivos() {
        return enabledArchivos;
    }

    public boolean isEnabledReportesMaestros() {
        return enabledReportesMaestros;
    }

    @NotNull
    public boolean isEnabledRetornos() {
        return enabledRetornos;
    }
}
