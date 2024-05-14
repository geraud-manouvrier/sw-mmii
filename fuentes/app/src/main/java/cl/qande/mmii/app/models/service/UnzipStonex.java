package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.properties.FtpStonexProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.exception.SchemaStonexException;
import cl.qande.mmii.app.util.helper.FtpStonexHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UnzipStonex {

    @Autowired
    private ZipService zipService;
    @Autowired
    private FtpStonexHelper ftpStonexHelper;
    @Autowired
    private FtpStonexProperties ftpStonexProperties;
    @Autowired
    private IProcesoFtpStonexService procesoFtpService;
    @Autowired
    private NotificacionEmail notificacionEmail;

    public List<String> processZipByDate(String processDate, String processStamp) throws QandeMmiiException {
        var sourceZip	    = ftpStonexHelper.generateSourceZipFileName(processDate+processStamp);
        try {
            var archivosProcesados = zipService.unzip(sourceZip, ftpStonexHelper.generateDestZipFolderName(processDate + processStamp));
            for (String archivo : archivosProcesados
            ) {
                procesoFtpService.procesaFtp(processDate, processStamp, "Archivo procesado: " + archivo);
            }
            return archivosProcesados;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
                notificacionEmail.notificarErrorProcesoSchemasStonex(processDate, "Error procesando ZIP");
                throw new SchemaStonexException(e, "Error al procesar ZIP Stonex para fecha " + processDate, processDate, processStamp);
        }
    }

}
