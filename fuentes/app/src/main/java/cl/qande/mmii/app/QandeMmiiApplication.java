package cl.qande.mmii.app;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.*;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.file.Files;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({
		AppConfigProperties.class,
		AppDatasourceProperties.class,
		AppSchedulingProperties.class,
		AppNotificacionMailProperties.class,
		AppApiProperties.class,
		FtpPershingProperties.class,
		AppApiClientSuraCorpProperties.class
})
public class QandeMmiiApplication implements CommandLineRunner {

	private final ArchivosHelper archivosHelper;
	private final AppConfig appConfig;

	@Autowired
	public QandeMmiiApplication(ArchivosHelper archivosHelper, AppConfig appConfig) {
        this.archivosHelper = archivosHelper;
        this.appConfig = appConfig;
    }

    public static void main(String[] args) {
		SpringApplication.run(QandeMmiiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appConfig.customLog.info("Iniciando método run...");
		if( ! Files.exists(archivosHelper.getPathFromName(appConfig.appConfigProperties.getRootFolder()))) {
			throw new QandeMmiiException("Directorio APP no existe <"+appConfig.appConfigProperties.getRootFolder()+">; finalizando...");
		}
		if( ! Files.exists(archivosHelper.getPathFromName(appConfig.appConfigProperties.getUploadFolder()))) {
			appConfig.customLog.info("Directorio UPLOADS no existe <{}>, creando..."+ appConfig.appConfigProperties.getUploadFolder());
			archivosHelper.creaDirectorioSubida();
		}
		if( ! Files.exists(archivosHelper.getPathFromName(appConfig.appConfigProperties.getLogFolder()))) {
			appConfig.customLog.info("Directorio LOGS no existe <{}>, creando..."+ appConfig.appConfigProperties.getLogFolder());
			archivosHelper.creaDirectorioLogs();
		}
		if( ! Files.exists(archivosHelper.getPathFromName(appConfig.appConfigProperties.getReportesMaestrosFolder()))) {
			appConfig.customLog.info("Directorio Reportes Maestro no existe <{}>, creando..."+ appConfig.appConfigProperties.getReportesMaestrosFolder());
			archivosHelper.creaDirectorioReportesMaestro();
		}
		if( ! Files.exists(archivosHelper.getPathFromName(appConfig.appConfigProperties.getDownloadableFolder()))) {
			appConfig.customLog.info("Directorio de Descargables no existe <{}>, creando..."+ appConfig.appConfigProperties.getDownloadableFolder());
			archivosHelper.creaDirectorioDownloadable();
		}

		appConfig.customLog.info("Método run finalizado");
	}
}
