package cl.qande.mmii.app.config;

import cl.qande.mmii.app.config.properties.AppConfigProperties;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.UUID;

@Component
public class AppConfig {


    @Autowired
    public AppConfigProperties appConfigProperties;

    public final Logger log = LoggerFactory.getLogger(getClass());

    public static final Locale LOCALE_CL = new Locale("es", "CL");

    private UUID uuid = UUID.randomUUID();

    @Autowired
    public CustomLog customLog;

    @PostConstruct
    public void inicializarLog() {
        customLog.setUuid(this.uuid);
    }
}
