package cl.qande.mmii.app.job;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.AppNotificacionMailProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.NotificacionEmail;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;

public abstract class CustomJob implements Runnable {
    private final String jobName;
    private final AppConfig appConfig;
    private final CalendarioHelper calendarioHelper;
    private final NotificacionEmail notificacionEmail;

    protected CustomJob(String jobName, AppConfig appConfig, CalendarioHelper calendarioHelper, NotificacionEmail notificacionEmail) {
        this.jobName = jobName;
        this.appConfig = appConfig;
        this.calendarioHelper = calendarioHelper;
        this.notificacionEmail = notificacionEmail;
    }
    protected abstract boolean ejecutaJob(String processDate, SesionWeb sesionWeb) throws QandeMmiiException;
    protected abstract void validateProcessDates(String startProcessDate, String endProcessDate) throws QandeMmiiException;
    protected abstract AppNotificacionMailProperties.NotificacionMailConfiguration getMailConfiguration();

    protected boolean ejecutaJob(String startProcessDate, String endProcessDate) throws QandeMmiiException {
        return ejecutaJob(startProcessDate, endProcessDate, null);
    }

    public boolean ejecutaJob(String startProcessDate, String endProcessDate, SesionWeb sesionWeb) throws QandeMmiiException {
        logInfoJob("Iniciada ejecución con processDate ["+startProcessDate+"] ["+endProcessDate+"]");
        validateProcessDates(startProcessDate, endProcessDate);
        var globalResult        = true;
        var listaProcessDate    = calendarioHelper.processDateRangeToList(startProcessDate, endProcessDate);
        for (var processDate : listaProcessDate) {
            CustomLog.getInstance().info("Procesando fecha ["+processDate+"]", false);
            try {
                var currentResult   = ejecutaJob(processDate, sesionWeb);
                globalResult    = (globalResult && currentResult);
            } catch (Exception e) {
                logErrorJob("Fecha ["+processDate+"]: "+e.getMessage());
                globalResult    = false;
            }
        }
        logInfoJob("Finalizada ejecución con processDate ["+startProcessDate+"] ["+endProcessDate+"]");
        return globalResult;
    }

    @Override
    public void run() {
        ejecutaJob();
    }

    protected NotificacionEmail getNotificacionEmail() {
        return notificacionEmail;
    }

    public String getJobName(){
        return jobName;
    }

    protected boolean ejecutaJob(){
        logStartJob();
        var processDate		= defaultProcessDate();
        try {
            return this.ejecutaJob(processDate, processDate);
        } catch (QandeMmiiException e) {
            logErrorJob(e.getMessage());
            logEndJob();
            return false;
        }
    }

    protected String defaultProcessDate() {
        return calendarioHelper.convierteDateToString(calendarioHelper.hoyConDesfaseDias(CustomScheduler.DESFASE_DIAS)).replace("-","");
    }

    protected void logStartJob(){
        CustomLog.getInstance().info("Iniciando tarea "+getJobName()+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName(), false);
    }
    protected void logEndJob(){
        CustomLog.getInstance().info("Finalizando tarea "+getJobName()+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName(), false);
    }
    protected void logErrorJob(String error){
        CustomLog.getInstance().error("Error al realizar tarea "+getJobName()+": "+this.getClass().getName()+" - "+Thread.currentThread().getName()+" - "+Thread.currentThread().getContextClassLoader().getName()+". Error ["+error+"]", false);
    }
    protected void logInfoJob(String msg){
        CustomLog.getInstance().info(getJobName()+": "+msg, false);
    }

    public AppConfig getAppConfig() {
        return appConfig;
    }

    public CalendarioHelper getCalendarioHelper() {
        return calendarioHelper;
    }
}
