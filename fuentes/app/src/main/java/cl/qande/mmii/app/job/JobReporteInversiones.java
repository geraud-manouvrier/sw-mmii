package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.IReporteInversionesService;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobReporteInversiones implements Runnable {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private IReporteInversionesService reporteInversionesService;

    public boolean preCalculoDiario(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        try {
            appConfig.customLog.info("Iniciando precalculo diario con fechas [" + startProcessDate + " - " + endProcessDate + "]");
            reporteInversionesService.preCalculoDiarioRentabilidad(startProcessDate, endProcessDate);
            notificacionEmail.notificarOkPreCaulculoDiario(startProcessDate, endProcessDate);
            appConfig.customLog.info("Finalizando OK precalculo diario con fechas [" + startProcessDate + " - " + endProcessDate + "]");
            return true;
        } catch (Exception e) {
            appConfig.customLog.error("Finalizando con errores precalculo diario con fechas ["+startProcessDate+" - "+endProcessDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorPreCaulculoDiario(startProcessDate, endProcessDate, "Error Job Control Diario: ["+e.getMessage()+"]");
        }
        return false;
    }

    public void tarea() {
        appConfig.customLog.info("Iniciando tarea Control Diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(CustomScheduler.DESFASE_DIAS)).replace("-","");
        try {
            this.preCalculoDiario(processDate, processDate);
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error al realizar tarea precalculo diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        appConfig.customLog.info("Finalizando tarea precalculo diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
