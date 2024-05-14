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
    private final boolean enabledClientes;
    @NotNull
    private final boolean enabledContratos;

    public AppApiProperties(boolean enabledGlobal, boolean enabledArchivos, boolean enabledClientes, boolean enabledContratos) {
        this.enabledGlobal = enabledGlobal;
        this.enabledArchivos = enabledArchivos;
        this.enabledClientes = enabledClientes;
        this.enabledContratos = enabledContratos;
    }

    public boolean isEnabledGlobal() {
        return enabledGlobal;
    }

    public boolean isEnabledArchivos() {
        return enabledArchivos;
    }

    public boolean isEnabledClientes() {
        return enabledClientes;
    }

    public boolean isEnabledContratos() {
        return enabledContratos;
    }
}
