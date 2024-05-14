package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.impl.SchemaImpl;
import cl.qande.mmii.app.util.helper.CalendarioHelper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StonexService {
    private static final int ID_ETDO_CIERRE_OK = 0;

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private UnzipStonex unzipStonex;
    @Autowired
    private FtpStonexService ftpStonexService;
    @Autowired
    private ISchemaService schemaService;
    @Autowired
    private CalendarioHelper calendarioHelper;
    @Autowired
    private IProcesoFtpStonexService procesoFtpStonexService;

    private static final String FORMATO_FECHA_PROCESO   = "yyyyMMdd";

    public void processByDateRange(String minProcessDate, String maxProcessDate) throws QandeMmiiException {
        appConfig.customLog.info("Procesando Schemas por Rango de fechas ["+minProcessDate+"-"+maxProcessDate+"]");
        Date desde;
        Date hoy;
        Date hasta;
        try {
            desde	= calendarioHelper.convierteFechaStrToDateWithFormat(minProcessDate, FORMATO_FECHA_PROCESO);
            hasta	= calendarioHelper.fechaConDesfaseDias(calendarioHelper.convierteFechaStrToDateWithFormat(maxProcessDate, FORMATO_FECHA_PROCESO), 1);
            hoy		= desde;
            while (! hoy.equals(hasta)) {
                var processDate		= calendarioHelper.convierteDateToStringWithFormat(hoy, FORMATO_FECHA_PROCESO);
                //Usamos marcas de tiempo distintas en cada iteración para que no choquen PK y marcas
                var processStamp	= new SimpleDateFormat(processDate+"_yyyy.MM.dd.HH.mm.ss.SSS.Z").format(new Date());
                appConfig.customLog.info("Procesando fecha ["+processDate+"] con marca ["+processStamp+"]");
                this.processByDate(processDate, processStamp);
                hoy	= calendarioHelper.fechaConDesfaseDias(hoy, 1);
            }
        } catch (ParseException e) {
            throw new QandeMmiiException(e, "Error al procesar Schemas por Rango de fechas ["+minProcessDate+"-"+maxProcessDate+"]: ["+e.getMessage()+"]");
        }
    }
    public void processByDate(String processDate, String processStamp) throws QandeMmiiException {
        var message         = "";
        List<String> archivosProcesados;
        appConfig.customLog.info("Se procesarán archivos con fecha proceso ["+processDate+"] y marca de tiempo ["+processStamp+"]");

        try {
            message = "Iniciando paso FTP...";
            procesoFtpStonexService.procesaFtp(processDate, processStamp, message);
            ftpStonexService.downloadByDate(processDate, processStamp);
            message = "Paso FTP finalizado";
            procesoFtpStonexService.procesaFtp(processDate, processStamp, message);
        } catch (Exception e) {
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Error en paso FTP: ["+e.getMessage()+"]");
            return;
        }
        try {
            message = "Iniciando paso ZIP...";
            procesoFtpStonexService.procesaFtp(processDate, processStamp, message);
            archivosProcesados  = unzipStonex.processZipByDate(processDate, processStamp);
            message = "Paso ZIP finalizado";
            procesoFtpStonexService.procesaFtp(processDate, processStamp, message);
        } catch (Exception e) {
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Error en paso ZIP: ["+e.getMessage()+"]");
            return;
        }
        message = "Iniciando paso BD...";
        procesoFtpStonexService.procesaFtp(processDate, processStamp, message);
        if (! procesoFtpStonexService.esHabil(processDate)) {
            this.replicaInfoSchema(processDate, processStamp);
        } else {
            if (archivosProcesados.isEmpty()) {
                message="Excepción Stonex: Sin archivos descargados y día es hábil";
                procesoFtpStonexService.cierraProcesoFtp(processDate, processStamp, message, 1);
                throw new QandeMmiiException(message);
            }
            for (String archivo: archivosProcesados) {
                try {
                    schemaService.saveSchema(processDate, processStamp, archivo);
                    procesoFtpStonexService.procesaFtp(processDate, processStamp, "Archivo ["+archivo+"] procesado OK");
                } catch (Exception e) {
                    procesoFtpStonexService.procesaFtp(processDate, processStamp, "Archivo ["+archivo+"] con errores: ["+e.getMessage()+"]");
                }

                try {
                    schemaService.procesaSchema(processStamp, FilenameUtils.getName(archivo));
                    procesoFtpStonexService.procesaFtp(processDate, processStamp, "Schema ["+archivo+"] procesado OK");
                } catch (Exception e) {
                    procesoFtpStonexService.procesaFtp(processDate, processStamp, "Schema ["+archivo+"] con errores: ["+e.getMessage()+"]");
                }
            }
        }
        message = "Paso BD finalizado";
        procesoFtpStonexService.cierraProcesoFtp(processDate, processStamp, message, ID_ETDO_CIERRE_OK);

    }

    private void replicaInfoSchema(String processDate, String processStamp) {

        procesoFtpStonexService.procesaFtp(processDate, processStamp, "Replicando data de Process Stamp ["+processStamp+"] con Process Date ["+processDate+"]");
        try {
            schemaService.procesaSchema(processStamp, SchemaImpl.ACT_SCHEMA);
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Schema ACT replicado OK");
        } catch (QandeMmiiException e) {
            appConfig.customLog.info("Error al replicar Schema ACT con fecha proceso ["+processDate+"] y marca de tiempo ["+processStamp+"]: ["+e.getMessage()+"]");
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Error al replicar Schema ACT: ["+e.getMessage()+"]");
        }
        try {
            schemaService.procesaSchema(processStamp, SchemaImpl.BAL_ACT_SCHEMA);
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Schema BAL_ACT replicado OK");
        } catch (QandeMmiiException e) {
            appConfig.customLog.info("Error al replicar Schema BAL_ACT con fecha proceso ["+processDate+"] y marca de tiempo ["+processStamp+"]: ["+e.getMessage()+"]");
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Error al replicar Schema BAL_ACT: ["+e.getMessage()+"]");
        }
        try {
            schemaService.procesaSchema(processStamp, SchemaImpl.POS_SCHEMA);
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Schema POS replicado OK");
        } catch (QandeMmiiException e) {
            appConfig.customLog.info("Error al replicar Schema POS con fecha proceso ["+processDate+"] y marca de tiempo ["+processStamp+"]: ["+e.getMessage()+"]");
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Error al replicar Schema POS: ["+e.getMessage()+"]");
        }
        try {
            schemaService.procesaSchema(processStamp, SchemaImpl.SEC_OSI_SCHEMA);
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Schema SEC_OSI replicado OK");
        } catch (QandeMmiiException e) {
            appConfig.customLog.info("Error al replicar Schema SEC_OSI con fecha proceso ["+processDate+"] y marca de tiempo ["+processStamp+"]: ["+e.getMessage()+"]");
            procesoFtpStonexService.procesaFtp(processDate, processStamp, "Error al replicar Schema SEC_OSI: ["+e.getMessage()+"]");
        }
    }
}
