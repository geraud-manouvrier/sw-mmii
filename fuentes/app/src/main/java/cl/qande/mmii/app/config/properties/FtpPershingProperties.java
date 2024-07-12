package cl.qande.mmii.app.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "app.properties.ftp.pershing")
@ConstructorBinding
public class FtpPershingProperties {

    @NotBlank
    private final String username;
    @NotBlank
    private final String password;
    @NotBlank
    private final String protocol;
    @NotBlank
    private final String server;
    @NotNull
    @Min(0)
    private final Integer port;
    @NotBlank
    private final String serverPath;

    @NotBlank
    private final String downloadPath;

    @NotBlank
    private final String workPath;
    @NotNull
    @Min(0)
    private final Integer useProxyPort;

    @NotNull
    private final boolean useSshKey;
    @NotNull
    private final String sshPrivateKey;

    @SuppressWarnings("squid:S00107")
    public FtpPershingProperties(String username, String password, String protocol, String server, Integer port, String serverPath, String downloadPath, String workPath, Integer useProxyPort, boolean useSshKey, String sshPrivateKey) {
        this.username = username;
        this.password = password;
        this.protocol = protocol;
        this.server = server;
        this.port = port;
        this.serverPath = serverPath;
        this.downloadPath = downloadPath;
        this.workPath = workPath;
        this.useProxyPort = useProxyPort;
        this.useSshKey = useSshKey;
        this.sshPrivateKey = sshPrivateKey;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getServer() {
        return server;
    }

    public Integer getPort() {
        return port;
    }

    public String getServerPath() {
        return serverPath;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public String getWorkPath() {
        return workPath;
    }

    public Integer getUseProxyPort() {
        return useProxyPort;
    }

    public boolean isUseSshKey() {
        return useSshKey;
    }

    public String getSshPrivateKey() {
        return sshPrivateKey;
    }
}
