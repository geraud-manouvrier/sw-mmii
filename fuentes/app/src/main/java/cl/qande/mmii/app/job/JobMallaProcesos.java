package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//@EnableAsync(proxyTargetClass = true)
public class JobMallaProcesos implements Runnable {

    private static final int DESFASE_DIAS = -1;

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;

    @Autowired
    private JobGetFromFtpPershing jobGetFromFtpPershing;
    @Autowired
    private JobControlDiario jobControlDiario;
    @Autowired
    private JobReportesMaestros jobReportesMaestros;

    public boolean mallaProcesosByProcessDate(Date processDateAsDate) throws QandeMmiiException {
        CustomLog.getInstance().info("Ejecutando Malla Procesos");
        var processDateAsString = calendarioHelper.convierteDateToStringWithFormat(processDateAsDate, "yyyyMMdd");
        if (
                //Job Pershing
                jobGetFromFtpPershing.processByProcessDate(processDateAsString, false) &&
                //Job Reportes Maestros
                jobReportesMaestros.generaReportesByProcessDate(processDateAsString) &&
                //Job Control Diario
                jobControlDiario.realizaControlDiarioSegmentado(processDateAsString)
        ) {
                CustomLog.getInstance().info("Malla Procesos finalizada OK");
                return true;
            }
        CustomLog.getInstance().info("Malla Procesos finalizada con errores");
        return false;
    }

    public void tarea() {
        CustomLog.getInstance().info("Iniciando tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS);
        try {
            this.mallaProcesosByProcessDate(processDate);
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        CustomLog.getInstance().info("Finalizando tarea Malla Procesos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
