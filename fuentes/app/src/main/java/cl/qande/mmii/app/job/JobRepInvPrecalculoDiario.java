package cl.qande.mmii.app.job;

import cl.qande.mmii.app.models.db.rep_inv.ReporteInversionesService;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobRepInvPrecalculoDiario implements Runnable {
    private static final String NOMBRE_JOB = "Pre cálculo Diario Rentabilidades";
    private final CalendarioHelper calendarioHelper;
    private final NotificacionEmail notificacionEmail;
    private final ReporteInversionesService reporteInversionesService;

    @Autowired
    public JobRepInvPrecalculoDiario(CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail, ReporteInversionesService reporteInversionesService) {
        this.calendarioHelper = calendarioHelper;
        this.notificacionEmail = notificacionEmail;
        this.reporteInversionesService = reporteInversionesService;
    }
    public String getNombreJob() {
        return NOMBRE_JOB;
    }

    public boolean ejecutaJob(String processDateFrom) throws QandeMmiiException {
        try {
            CustomLog.getInstance().info("Iniciando precalculo diario con fecha [" + processDateFrom + "]", false);
            reporteInversionesService.calculoDiario(processDateFrom);
            notificacionEmail.notificaJobPreCaulculoRentabilidadesDiario(true, processDateFrom, NOMBRE_JOB, "");
            CustomLog.getInstance().info("Finalizando OK precalculo diario con fechas [" + processDateFrom + "]", false);
            return true;
        } catch (Exception e) {
            CustomLog.getInstance().error("Finalizando con errores precalculo diario con fechas ["+processDateFrom+"]: "+e.getMessage(), false);
            notificacionEmail.notificaJobPreCaulculoRentabilidadesDiario(false, processDateFrom, NOMBRE_JOB, "Error: ["+e.getMessage()+"]");
        }
        return false;
    }

    public boolean ejecutaJob() {
        CustomLog.getInstance().info("Iniciando tarea precalculo diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName(), false);
        var processDateFrom		= calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(CustomScheduler.DESFASE_DIAS)).replace("-","");
        if ( processDateFrom.substring((processDateFrom.length() - 2)).equals("01") ) {
            try {
                processDateFrom = CalendarioHelper.processDateConDesfase(processDateFrom, -1).substring(0, 6).concat("01");
                CustomLog.getInstance().info("Inicio de mes, calculando desde mes anterior con process date: "+processDateFrom, false);
            } catch (Exception e) {
                CustomLog.getInstance().error("Error al obtener inicio mes anterior: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]", false);
            }
        }
        try {
            return this.ejecutaJob(processDateFrom);
        } catch (QandeMmiiException e) {
            CustomLog.getInstance().error("Error al realizar tarea precalculo diario: "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+e.getMessage()+"]", false);
            return false;
        }
    }

    @Override
    public void run() {
        this.ejecutaJob();
    }
}
