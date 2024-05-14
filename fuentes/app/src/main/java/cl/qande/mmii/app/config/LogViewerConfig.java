package cl.qande.mmii.app.config;

import com.logviewer.data2.LogFormat;
import com.logviewer.logLibs.LogConfigurationLoader;
import com.logviewer.springboot.LogViewerSpringBootConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class LogViewerConfig extends LogViewerSpringBootConfig {


    @Bean
    public LogConfigurationLoader customLogFolderLoader(AppConfig appConfig) {
        File dirLogs= new File(appConfig.appConfigProperties.getLogFolder());
        var archivosLog = dirLogs.listFiles();
        Map<Path,LogFormat> result = new HashMap<>();

        for(var i=0; i<archivosLog.length; i++) {
            if (archivosLog[i].exists() && archivosLog[i].isFile()) {
                result.put(Path.of(archivosLog[i].getAbsolutePath()), null);
            }
        }
        return () -> result;
    }
}
