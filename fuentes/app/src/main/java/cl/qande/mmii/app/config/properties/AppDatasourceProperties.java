package cl.qande.mmii.app.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@ConfigurationProperties(prefix = "app.properties.datasource")
@ConstructorBinding
public class AppDatasourceProperties {

    private final DataSourceConfiguration dbcore;
    private final DataSourceConfiguration dbpershing;
    private final DataSourceConfiguration dbclientes;
    private final DataSourceConfiguration dbauxiliar;

    public AppDatasourceProperties(DataSourceConfiguration dbcore, DataSourceConfiguration dbpershing, DataSourceConfiguration dbclientes, DataSourceConfiguration dbauxiliar) {
        this.dbcore = dbcore;
        this.dbpershing = dbpershing;
        this.dbclientes = dbclientes;
        this.dbauxiliar = dbauxiliar;
    }

    public static class DataSourceConfiguration {

        @NotBlank
        private final String url;
        @NotBlank
        private final String driverClassName;
        @NotBlank
        private final String username;
        @NotBlank
        private final String password;

        public DataSourceConfiguration(String url, String driverClassName, String username, String password) {
            this.url = url;
            this.driverClassName = driverClassName;
            this.username = username;
            this.password = password;
        }

        public String getUrl() {
            return url;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public DataSourceConfiguration getDbcore() {
        return dbcore;
    }

    public DataSourceConfiguration getDbpershing() {
        return dbpershing;
    }

    public DataSourceConfiguration getDbclientes() {
        return dbclientes;
    }

    public DataSourceConfiguration getDbauxiliar() {
        return dbauxiliar;
    }
}
