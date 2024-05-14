package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.models.service.ReportesIngresosEgresosService;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//@EnableAsync(proxyTargetClass = true)
public class JobReportesIngresosEgresos implements Runnable {

    private static final int DESFASE_DIAS = -1;

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private CalendarioHelper calendarioHelper;

    @Autowired
    private ReportesIngresosEgresosService reportesIngresosEgresosService;
    @Autowired
    private NotificacionEmail notificacionEmail;

    public boolean generaReportesByProcessDate(Date processDate) throws QandeMmiiException {

        if (reportesIngresosEgresosService.generaReportesIngresosEgresos(processDate)) {
            appConfig.customLog.info("Generación Reportes Ingresos/Egresos Excel con fecha ["+processDate+"] finalizada OK");
            return true;
        } else {
            appConfig.customLog.error("Errores al generar Reportes Ingresos/Egresos Excel con fecha ["+processDate+"]");
            notificacionEmail.notificarErrorReportesIngresosEgresos(calendarioHelper.convierteDateToString(processDate), "Error Job Reportes Ingresos/Egresos");
            return false;
        }
    }
    public boolean calculaReporteByProcessDate(Date processDate) throws QandeMmiiException {
        return ( !(reportesIngresosEgresosService.calculaReporteIngresosEgresos(processDate) == null) );
    }

    public boolean reporteIngresosEgresosByProcessDate(Date processDate) throws QandeMmiiException {
        appConfig.customLog.info("Iniciando proceso Reportes Ingresos/Egresos");
        appConfig.customLog.info("Iniciando Cálculo Reportes Ingresos/Egresos");
        if (this.calculaReporteByProcessDate(processDate) ) {
            appConfig.customLog.info("Iniciando Generación Reportes Ingresos/Egresos");
            if ( this.generaReportesByProcessDate(processDate) ) {
                appConfig.customLog.info("Finalizado proceso Reportes Ingresos/Egresos");
                return true;
            }
        }
        return false;
    }

    public void tarea() {
        appConfig.customLog.info("Iniciando tarea Reportes Ingresos/Egresos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
        var processDate		= calendarioHelper.hoyConDesfaseDias(DESFASE_DIAS);
        try {
            this.calculaReporteByProcessDate(processDate);
        } catch (Exception e) {
            appConfig.customLog.error("Error tarea Reportes Ingresos/Egresos - Paso cálculo: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }
        try {
            this.generaReportesByProcessDate(processDate);
        } catch (QandeMmiiException e) {
            appConfig.customLog.error("Error tarea Reportes Ingresos/Egresos - Paso Excel: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]");
        }appConfig.customLog.info("Finalizando tarea Reportes Ingresos/Egresos: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName());
    }

    @Override
    public void run() {
        this.tarea();
    }
}
