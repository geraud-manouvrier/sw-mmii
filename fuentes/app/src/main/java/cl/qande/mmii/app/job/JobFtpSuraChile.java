package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.SuraChileService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@EnableAsync(proxyTargetClass = true)
public class JobFtpSuraChile implements Runnable {

    private static final int DESFASE_DIAS = -1;
    private static final boolean FLAG_OMITIR_CTRL_DIARIO = false;

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private SuraChileService suraChileService;

    public boolean realizaCargaDiaria(String processDate, boolean flagOmitirControlDiario) throws QandeMmiiException {
        try {
            var resultadoProceso = suraChileService.cargaArchivosEnFtpPorFechaProceso(processDate, flagOmitirControlDiario);
            appConfig.customLog.info("Carga Maestros a FTP SURA Chile con fecha [" + processDate + "] finalizada OK");
            if (resultadoProceso.isEmpty()) {
                notificacionEmail.notificarOkSubidaFtpSuraChile(processDate, resultadoProceso);
                appConfig.customLog.info("Mail de resultado carga Maestros FTP SURA Chile con fecha [" + processDate + "] enviado OK");
                return true;
            } else {
                notificacionEmail.notificarErrorSubidaFtpSuraChile(processDate, resultadoProceso);
                appConfig.customLog.info("Mail de Error carga Maestros FTP SURA Chile con fecha [" + processDate + "] enviado OK");
                return false;
            }
        } catch (Exception e) {
            appConfig.customLog.error("Errores al cargar Maestros a FTP SURA Chile con fecha ["+processDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorSubidaFtpSuraChile(processDate, null);
            return false;
        }
    }

    public void tarea() {
        appConfig.customLog.info("Iniciando tarea carga Maestros a FTP: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            this.realizaCargaDiaria(processDate, FLAG_OMITIR_CTRL_DIARIO);
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error al realizar tarea carga Maestros a FTP: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");

        }
        appConfig.customLog.info("Finalizando tarea carga Maestros a FTP: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
