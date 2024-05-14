package cl.qande.mmii.app.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@ConfigurationProperties(prefix = "app.properties.config")
@ConstructorBinding
public class AppConfigProperties {

    @NotBlank
    private final String rootFolder;
    @NotBlank
    private final String projectVersion;
    @NotBlank
    private final String contextPath;
    @NotBlank
    private final String logFolder;
    @NotBlank
    private final String uploadFolder;
    @NotBlank
    private final String reportesMaestrosFolder;
    @NotBlank
    private final String reportesIngresosegresosFolder;
    @NotBlank
    private final String downloadableFolder;
    @NotBlank
    private final String reporteInversionesFolder;
    @NotBlank
    private final String propertiesEnvironment;
    @NotBlank
    private final String propertiesSecrets;
    @NotBlank
    private final String defaultPwd;
    @NotBlank
    private final String plantillaCargaManualClientes;
    @NotBlank
    private final String pptHelp;

    public AppConfigProperties(String rootFolder, String projectVersion, String contextPath, String logFolder, String uploadFolder, String reportesMaestrosFolder, String reportesIngresosegresosFolder, String downloadableFolder, String reporteInversionesFolder, String propertiesEnvironment, String propertiesSecrets, String defaultPwd, String plantillaCargaManualClientes, String pptHelp) {
        this.rootFolder = rootFolder;
        this.projectVersion = projectVersion;
        this.contextPath = contextPath;
        this.logFolder = logFolder;
        this.uploadFolder = uploadFolder;
        this.reportesMaestrosFolder = reportesMaestrosFolder;
        this.reportesIngresosegresosFolder = reportesIngresosegresosFolder;
        this.downloadableFolder = downloadableFolder;
        this.reporteInversionesFolder = reporteInversionesFolder;
        this.propertiesEnvironment = propertiesEnvironment;
        this.propertiesSecrets = propertiesSecrets;
        this.defaultPwd = defaultPwd;
        this.plantillaCargaManualClientes = plantillaCargaManualClientes;
        this.pptHelp = pptHelp;
    }

    public final String getRootFolder() {
        return rootFolder;
    }

    public String getProjectVersion() {
        return projectVersion;
    }

    public String getContextPath() {
        return contextPath;
    }

    public String getLogFolder() {
        return logFolder;
    }

    public String getUploadFolder() {
        return uploadFolder;
    }

    public String getReportesMaestrosFolder() {
        return reportesMaestrosFolder;
    }

    public String getReportesIngresosegresosFolder() {
        return reportesIngresosegresosFolder;
    }

    public String getPropertiesEnvironment() {
        return propertiesEnvironment;
    }

    public String getPropertiesSecrets() {
        return propertiesSecrets;
    }

    public String getDownloadableFolder() {
        return downloadableFolder;
    }

    public String getReporteInversionesFolder() {
        return reporteInversionesFolder;
    }

    public String getDefaultPwd() {
        return defaultPwd;
    }

    public String getPlantillaCargaManualClientes() {
        return plantillaCargaManualClientes;
    }

    public String getPptHelp() {
        return pptHelp;
    }
}
