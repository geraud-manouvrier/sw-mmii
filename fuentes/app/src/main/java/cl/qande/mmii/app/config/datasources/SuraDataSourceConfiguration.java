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
@EnableJpaRepositories(basePackages = SuraDataSourceConfiguration.PACKAGE_DAO,
        entityManagerFactoryRef = SuraDataSourceConfiguration.ENTITY_MANAGER,
        transactionManagerRef= SuraDataSourceConfiguration.TRANSACTION_MANAGER
)
public class SuraDataSourceConfiguration {

    @Autowired
    private AppDatasourceProperties dsProperties;
    public static final String PACKAGE_ENTITIES     = "cl.qande.mmii.app.models.db.sura.entity";
    public static final String PACKAGE_DAO          = "cl.qande.mmii.app.models.db.sura.dao";
    public static final String NOMBRE_DATASOURCE    = "suraDataSource";
    public static final String ENTITY_MANAGER       = "suraEntityManagerFactory";
    public static final String TRANSACTION_MANAGER  = "suraTransactionManager";
    public static final String DATASOURCE_PROPERTIES    = "suraDataSourceProperties";
    @Bean(name=DATASOURCE_PROPERTIES)
    public DataSourceProperties createDataSourceProperties() {
        var dataSourceConfiguration= dsProperties.getDbsura();
        var dataSourceProperties              = new DataSourceProperties();
        dataSourceProperties.setUrl(dataSourceConfiguration.getUrl());
        dataSourceProperties.setDriverClassName(dataSourceConfiguration.getDriverClassName());
        dataSourceProperties.setUsername(dataSourceConfiguration.getUsername());
        dataSourceProperties.setPassword(dataSourceConfiguration.getPassword());
        return dataSourceProperties;
    }

    @Bean(name = NOMBRE_DATASOURCE)
    public DataSource buildDataSource() {
        return createDataSourceProperties().initializeDataSourceBuilder()
                .build();
    }

    @Bean(name = ENTITY_MANAGER)
    public LocalContainerEntityManagerFactoryBean buildEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(buildDataSource())
                .packages(PACKAGE_ENTITIES)
                .persistenceUnit(NOMBRE_DATASOURCE)
                .build();
    }

    @Bean(name=TRANSACTION_MANAGER)
    public PlatformTransactionManager createTransactionManager(
            final @Qualifier(ENTITY_MANAGER) LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }
}
