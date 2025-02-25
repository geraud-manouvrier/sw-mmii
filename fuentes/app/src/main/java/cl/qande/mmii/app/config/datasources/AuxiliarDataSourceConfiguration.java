package cl.qande.mmii.app.config.datasources;


import cl.qande.mmii.app.config.properties.AppDatasourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {
        AuxiliarDataSourceConfiguration.PACKAGE_REPINV_DAO
},
        entityManagerFactoryRef = AuxiliarDataSourceConfiguration.ENTITY_MANAGER,
        transactionManagerRef= AuxiliarDataSourceConfiguration.TRANSACTION_MANAGER
)
public class AuxiliarDataSourceConfiguration {

    private final AppDatasourceProperties dsProperties;
    //DAO
    public static final String PACKAGE_REPINV_DAO           = "cl.qande.mmii.app.models.db.rep_inv.dao";
    //Entity
    public static final String PACKAGE_REPINV_ENTITIES      = "cl.qande.mmii.app.models.db.rep_inv.entity";
    //
    public static final String NAME_DATASOURCE              = "auxiliarDataSource";
    public static final String ENTITY_MANAGER               = "auxiliarEntityManagerFactory";
    public static final String TRANSACTION_MANAGER          = "auxiliarTransactionManager";
    public static final String DATASOURCE_PROPERTIES        = "auxiliarDataSourceProperties";

    @Autowired
    public AuxiliarDataSourceConfiguration(AppDatasourceProperties dsProperties) {
        this.dsProperties = dsProperties;
    }

    @Bean(name=DATASOURCE_PROPERTIES)
    public DataSourceProperties createDataSourceProperties() {
        var dataSourceConfiguration= dsProperties.getDbauxiliar();
        var dataSourceProperties              = new DataSourceProperties();
        dataSourceProperties.setUrl(dataSourceConfiguration.getUrl());
        dataSourceProperties.setDriverClassName(dataSourceConfiguration.getDriverClassName());
        dataSourceProperties.setUsername(dataSourceConfiguration.getUsername());
        dataSourceProperties.setPassword(dataSourceConfiguration.getPassword());
        return dataSourceProperties;
    }

    @Bean(name = NAME_DATASOURCE)
    public DataSource buildDataSource() {
        return createDataSourceProperties().initializeDataSourceBuilder()
                .build();
    }

    @Bean(name = ENTITY_MANAGER)
    public LocalContainerEntityManagerFactoryBean buildEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(buildDataSource())
                .packages(PACKAGE_REPINV_ENTITIES)
                .persistenceUnit(NAME_DATASOURCE)
                .build();
    }

    @Bean(name=TRANSACTION_MANAGER)
    public PlatformTransactionManager createTransactionManager(
            final @Qualifier(ENTITY_MANAGER) LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }
}
