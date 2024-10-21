package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.impl.SflImpl;
import cl.qande.mmii.app.util.helper.ArchivosHelper;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import cl.qande.mmii.app.util.helper.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PershingService {
    private static final int ID_ETDO_CIERRE_OK = 0;
    private static final String TIMESTAMP_SUFFIX = "_yyyy.MM.dd.HH.mm.ss.SSS.Z";
    public static final String CONCAT_MSG_SFL = "SFL [";
    public static final String SUFFIX_REPLIC = "] replicado";
    public static final String ERROR_PROCESS = "Error al procesar lista de archivos: [";
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private FtpPershingService ftpPershingService;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IProcesoFtpPershingService procesoFtpPershingService;
    @Autowired
    private UnzipPershing unzipPershing;
    @Autowired
    private ISflService sflService;
    @Autowired
    private ArchivosHelper archivosHelper;

    public void processByDate(String processDate, boolean useDownloadedFiles, String idSfl) throws QandeMmiiException {
        var processStamp	= new SimpleDateFormat(processDate+TIMESTAMP_SUFFIX).format(new Date());
        if (useDownloadedFiles) {
            this.processFilesByDate(processDate, processStamp, idSfl);
        } else {
            this.processByDateAndStamp(processDate, processStamp);
        }
    }

    private void processByDateAndStamp(String processDate, String processStamp) throws QandeMmiiException {
        Long idProceso;
        var message         = "";
        var fechaPershing   = calendarioHelper.convierteFechaStrToFechaPershing(processDate);
        List<String> archivosDescargados;
        try {
            message = "Iniciando paso FTP Pershing...";
            idProceso   = procesoFtpPershingService.procesaFtp(processDate, processStamp, message).getId();
            archivosDescargados = ftpPershingService.downloadFilesByPattern(fechaPershing);
            message = "Paso FTP Pershing finalizado";
            procesoFtpPershingService.procesaFtp(processDate, processStamp, message);
            CustomLog.getInstance().info("Descarga FTP Pershing con fecha [" + processDate + "]-["+fechaPershing+"] finalizado OK. Archivos descargados: "+archivosDescargados.toString());
        } catch (QandeMmiiException e) {
            procesoFtpPershingService.procesaFtp(processDate, processStamp, "Error en paso FTP Pershing: ["+e.getMessage()+"]");
            throw new QandeMmiiException(e, "Error en paso FTP Pershing: ["+e.getMessage()+"]");
        }
        try {
            message = "Iniciando procesado lista de archivos...";
            procesoFtpPershingService.procesaFtp(processDate, processStamp, message);
            this.processFileList(archivosDescargados, processDate, processStamp, idProceso);
        } catch (Exception e) {
            procesoFtpPershingService.procesaFtp(processDate, processStamp, ERROR_PROCESS +e.getMessage()+"]");
            throw new QandeMmiiException(e, ERROR_PROCESS +e.getMessage()+"]");
        }
        message = "Procesado lista de archivos finalizado";
        procesoFtpPershingService.cierraProcesoFtp(processDate, processStamp, message, ID_ETDO_CIERRE_OK);
    }

    private void processFilesByDate(String processDate, String processStamp, String idSfl) throws QandeMmiiException {
        Long idProceso;
        var message         = "";
        var fechaPershing   = calendarioHelper.convierteFechaStrToFechaPershing(processDate);
        message = "Iniciando paso Archivos por Fecha Proceso: ["+processDate+"] y Fecha Pershing: ["+fechaPershing+"]. Id SFL: ["+idSfl+"]...";
        idProceso   = procesoFtpPershingService.procesaFtp(processDate, processStamp, message).getId();
        var archivosDescargados = archivosHelper.listadoDeSflZipPershingPorFechaIdSfl(fechaPershing, idSfl);
        CustomLog.getInstance().info("Archivos detectados a procesar: [" + List.of(archivosDescargados) + "]");
        try {
            message = "Iniciando procesado lista de archivos...";
            procesoFtpPershingService.procesaFtp(processDate, processStamp, message);
            this.processFileList(List.of(archivosDescargados), processDate, processStamp, idProceso);
        } catch (Exception e) {
            procesoFtpPershingService.procesaFtp(processDate, processStamp, ERROR_PROCESS +e.getMessage()+"]");
            throw new QandeMmiiException(e, ERROR_PROCESS +e.getMessage()+"]");
        }
        message = "Procesado lista de archivos finalizado";
        procesoFtpPershingService.cierraProcesoFtp(processDate, processStamp, message, ID_ETDO_CIERRE_OK);

    }

    private void processFileList(List<String> archivosDescargados, String processDate, String processStamp, Long idProceso) throws QandeMmiiException {
        var message         = "";
        List<String> archivosProcesados;
        try {
            message = "Iniciando paso ZIP SFL...";
            procesoFtpPershingService.procesaFtp(processDate, processStamp, message);
            archivosProcesados  = unzipPershing.processFilesByList(archivosDescargados, processDate, processStamp);
            message = "Paso ZIP SFL finalizado";
            procesoFtpPershingService.procesaFtp(processDate, processStamp, message);

        } catch (Exception e) {
            procesoFtpPershingService.procesaFtp(processDate, processStamp, "Error en paso ZIP SFL: ["+e.getMessage()+"]");
            return;
        }
        message = "Iniciando paso BD...";
        procesoFtpPershingService.procesaFtp(processDate, processStamp, message);
        if (! procesoFtpPershingService.esHabil(processDate)) {
            this.replicaInfoSfl(idProceso, processDate, processStamp);
        } else {
            if (archivosProcesados.isEmpty()) {
                message="Excepción Pershing: Sin archivos descargados y día es hábil";
                procesoFtpPershingService.cierraProcesoFtp(processDate, processStamp, message, 1);
                throw new QandeMmiiException(message);
            }
            for (String archivo: archivosProcesados) {
                var idSfl   = this.obtieneIdSflDesdeArchivo(archivo);
                try {
                    sflService.saveSfl(idProceso, processDate, processStamp, archivo, idSfl);
                    procesoFtpPershingService.procesaFtp(processDate, processStamp, "Archivo ["+archivo+"] guardado y parse OK");
                } catch (Exception e) {
                    procesoFtpPershingService.procesaFtp(processDate, processStamp, "Archivo ["+archivo+"] guardado y parse con errores: ["+e.getMessage()+"]");
                }

                try {
                    sflService.procesaSfl(idProceso, processDate, processStamp, archivo, idSfl);
                    procesoFtpPershingService.procesaFtp(processDate, processStamp, CONCAT_MSG_SFL +archivo+"] procesado OK");
                } catch (Exception e) {
                    procesoFtpPershingService.procesaFtp(processDate, processStamp, CONCAT_MSG_SFL +archivo+"] procesado con errores: ["+e.getMessage()+"]");
                }
            }
        }
        message = "Paso BD finalizado";
        procesoFtpPershingService.procesaFtp(processDate, processStamp, message);
    }

    private void replicaInfoSfl(Long idProceso, String processDate, String processStamp) {
        try {
            var fullPathFile    = "DummyFilePath";
            procesoFtpPershingService.procesaFtp(processDate, processStamp, "Iniciando replicación de datos con id ["+idProceso+"] y fecha ["+processDate+"]");
            sflService.procesaSfl(idProceso, processDate, processStamp, fullPathFile, SflImpl.ACCT_SFL_EXT);
            procesoFtpPershingService.procesaFtp(processDate, processStamp, CONCAT_MSG_SFL +SflImpl.ACCT_SFL_EXT+ SUFFIX_REPLIC);
            sflService.procesaSfl(idProceso, processDate, processStamp, fullPathFile, SflImpl.ISCA_SFL_EXT);
            procesoFtpPershingService.procesaFtp(processDate, processStamp, CONCAT_MSG_SFL +SflImpl.ISCA_SFL_EXT+ SUFFIX_REPLIC);
            sflService.procesaSfl(idProceso, processDate, processStamp, fullPathFile, SflImpl.GCUS_SFL_EXT);
            procesoFtpPershingService.procesaFtp(processDate, processStamp, CONCAT_MSG_SFL +SflImpl.GCUS_SFL_EXT+ SUFFIX_REPLIC);
            sflService.procesaSfl(idProceso, processDate, processStamp, fullPathFile, SflImpl.GMON_SFL_EXT);
            procesoFtpPershingService.procesaFtp(processDate, processStamp, CONCAT_MSG_SFL +SflImpl.GMON_SFL_EXT+ SUFFIX_REPLIC);
        } catch (QandeMmiiException e) {
            throw new RuntimeException(e);
        }
    }

    private String obtieneIdSflDesdeArchivo(String fullPathToFile) {
        return archivosHelper.obtieneExtension(fullPathToFile);
    }
}
