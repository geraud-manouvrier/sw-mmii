package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.properties.FtpPershingProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UnzipPershing {

    @Autowired
    private ZipService zipService;
    @Autowired
    private ProcesoFtpPershingService procesoFtpPershingService;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private FtpPershingProperties ftpPershingProperties;

    public List<String> processFilesByList(List<String> listaZip, String processDate, String processStamp) {
        var destFolder  = ftpPershingProperties.getWorkPath();
        var srcFolder  = ftpPershingProperties.getDownloadPath();
        List<String> archivosProcesados  = new ArrayList<>();
        List<String> archivosError  = new ArrayList<>();
        for (String archivo : listaZip) {
            try {
                var archivosDescomprimidos = zipService.unzip(srcFolder + archivo, destFolder);
                procesoFtpPershingService.procesaFtp(processDate, processStamp, "Archivo SFL procesado: " + archivo);
                archivosProcesados.addAll(archivosDescomprimidos);
            } catch (FileNotFoundException e) {
                procesoFtpPershingService.procesaFtp(processDate, processStamp, "Archivo SFL no encontrado: " + archivo);
                archivosError.add(archivo);
            } catch (IOException e) {
                procesoFtpPershingService.procesaFtp(processDate, processStamp, "Archivo SFL con error: " + archivo+" ["+e.getMessage()+"]");
                archivosError.add(archivo);
            }
        }
        if ( ! archivosError.isEmpty()) {
            var mensajeMail = "Error procesando archivos SFL: ["+archivosError.toString()+"]";
            try {
                notificacionEmail.notificarErrorProcesoSflFtpPershing(processDate, mensajeMail);
            } catch (QandeMmiiException e) {
                return archivosProcesados;
            }
        }
        return archivosProcesados;
    }

}
