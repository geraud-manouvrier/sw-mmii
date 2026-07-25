package cl.qande.mmii.app.config.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "app.properties.api-client-mmii-suracorp")
@ConstructorBinding
@Getter
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
    private final String methodClientFeeList;
    @NotNull
    private final String methodClientFeeControl;
    @NotNull
    private final String methodClientPortfolioList;

    public AppApiClientSuraCorpProperties(String xClientId, String xApiKey, String server, String path, String methodSourceCode, String methodClientFee, String methodClientFeeList, String methodClientFeeControl, String methodClientPortfolioList) {
        this.xClientId = xClientId;
        this.xApiKey = xApiKey;
        this.server = server;
        this.path = path;
        this.methodSourceCode = methodSourceCode;
        this.methodClientFee = methodClientFee;
        this.methodClientFeeList = methodClientFeeList;
        this.methodClientFeeControl = methodClientFeeControl;
        this.methodClientPortfolioList = methodClientPortfolioList;
    }
}
