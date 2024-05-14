package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.StonexService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
//@EnableAsync(proxyTargetClass = true)
public class JobGetFromFtpStonex implements Runnable {

    private static final int DESFASE_DIAS = -1;

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;

    @Autowired
    private StonexService stonexService;
    public boolean processByProcessDate(String processDate) throws QandeMmiiException {
        var processStamp	= new SimpleDateFormat(processDate+"_yyyy.MM.dd.HH.mm.ss.SSS.Z").format(new Date());
        try {
            stonexService.processByDate(processDate, processStamp);
            notificacionEmail.notificarOkProcesoSchemasStonex(processDate);
            appConfig.customLog.info("Mail FTP Stonex con fecha [" + processDate + "] enviado OK");
            return true;

        } catch (Exception e) {
            appConfig.customLog.error("Errores al realizar FTP Stonex con fecha ["+processDate+"]: "+e.getMessage());
            notificacionEmail.notificarErrorProcesoSchemasStonex(processDate, "Error Job FTP Stonex: ["+e.getMessage()+"]");
            return false;
        }
    }


    public void tarea() {
        appConfig.customLog.info("Iniciando tarea: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS)).replace("-","");
        try {
            this.processByProcessDate(processDate);
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error en tarea Stonex: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        appConfig.customLog.info("Finalizando tarea: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
