package cl.qande.mmii.app.config;

import cl.qande.mmii.app.config.properties.AppSchedulingProperties;
import cl.qande.mmii.app.job.CustomScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;


@Configuration
@ComponentScan(basePackages = "cl.qande.mmii.app.job", basePackageClasses = { CustomScheduler.class })
public class SchedulingConfig {

    private static final String THREAD_NAME_PREFIX  = "CustomThreadPoolTaskScheduler";
    private static final int THREAD_POOL_SIZE   = 10;


    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(THREAD_POOL_SIZE);
        threadPoolTaskScheduler.setThreadNamePrefix(THREAD_NAME_PREFIX);
        return threadPoolTaskScheduler;
    }
    @Bean
    public CronTrigger cronReportesMaestros(AppSchedulingProperties appSchedulingProperties) {
        return new CronTrigger(appSchedulingProperties.getCronReportesMaestros());
    }
    @Bean
    public CronTrigger cronControlDiario(AppSchedulingProperties appSchedulingProperties) {
        return new CronTrigger(appSchedulingProperties.getCronControlDiario());
    }
    @Bean
    public CronTrigger cronFtpPershing(AppSchedulingProperties appSchedulingProperties) {
        return new CronTrigger(appSchedulingProperties.getCronFtpPershing());
    }
    @Bean
    public CronTrigger cronMallaDiaria(AppSchedulingProperties appSchedulingProperties) {
        return new CronTrigger(appSchedulingProperties.getCronMallaDiaria());
    }
    @Bean
    public CronTrigger cronCuentasNoMapeadas(AppSchedulingProperties appSchedulingProperties) {
        return new CronTrigger(appSchedulingProperties.getCronCuentasNoMapeadas());
    }
    @Bean
    public CronTrigger cronParametrosSuraCorp(AppSchedulingProperties appSchedulingProperties) {
        return new CronTrigger(appSchedulingProperties.getCronParametrosSuraCorp());
    }
    @Bean
    public CronTrigger cronReporteInversiones(AppSchedulingProperties appSchedulingProperties) {
        return new CronTrigger(appSchedulingProperties.getCronReporteInversiones());
    }
    @Bean
    public CronTrigger cronReporteInversionesControles(AppSchedulingProperties appSchedulingProperties) {
        return new CronTrigger(appSchedulingProperties.getCronReporteInversionesControles());
    }
}
