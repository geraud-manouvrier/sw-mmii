package cl.qande.mmii.app.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "app.properties.api-client-mmii-suracorp")
@ConstructorBinding
public class AppApiClientSuraCorpProperties {

    @NotNull
    private final String xClientId;
    @NotNull
    private final String xApiKey;
    @NotNull
    private final String server;
    @NotNull
    private final String path;
    @NotNull
    private final String methodSourceCode;
    @NotNull
    private final String methodClientFee;
    @NotNull
    private final String methodClientFeeControl;

    public AppApiClientSuraCorpProperties(String xClientId, String xApiKey, String server, String path, String methodSourceCode, String methodClientFee, String methodClientFeeControl) {
        this.xClientId = xClientId;
        this.xApiKey = xApiKey;
        this.server = server;
        this.path = path;
        this.methodSourceCode = methodSourceCode;
        this.methodClientFee = methodClientFee;
        this.methodClientFeeControl = methodClientFeeControl;
    }

    public @NotNull String getxClientId() {
        return xClientId;
    }

    public @NotNull String getxApiKey() {
        return xApiKey;
    }

    public @NotNull String getServer() {
        return server;
    }

    public @NotNull String getPath() {
        return path;
    }

    public @NotNull String getMethodSourceCode() {
        return methodSourceCode;
    }

    public @NotNull String getMethodClientFee() {
        return methodClientFee;
    }

    public @NotNull String getMethodClientFeeControl() {
        return methodClientFeeControl;
    }
}
