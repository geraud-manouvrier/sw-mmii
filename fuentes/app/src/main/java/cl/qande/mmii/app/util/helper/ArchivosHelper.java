package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.properties.FtpPershingProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ArchivosHelper {

    private final AppConfig appConfig;
    private final FtpPershingProperties ftpPershingProperties;

    private final Logger log = LoggerFactory.getLogger(getClass());
    private static final String UPLOADS_TX_PREFIX   = "CargaTx_";
    private static final String UPLOADS_TIMESTAMP   = "yyyy.MM.dd.HH.mm.ss.SSS.Z";

    @Autowired
    public ArchivosHelper(AppConfig appConfig, FtpPershingProperties ftpPershingProperties) {
        this.appConfig = appConfig;
        this.ftpPershingProperties = ftpPershingProperties;
    }

    public String subirArchivo(MultipartFile file) throws QandeMmiiException {

        String nombreOriginal;
        try {
            nombreOriginal  = file.getOriginalFilename();
        } catch (Exception e) {
            throw new QandeMmiiException(e, "Error accediendo al archivo: "+e.getMessage());
        }
        String nombreFinal      = generaNombreArchivoTx(nombreOriginal);
        this.copy(file, nombreFinal);
        return nombreFinal;
    }

    public String generaNombreArchivoTx(String nombreOriginal) {
        String timeStamp    = new SimpleDateFormat(UPLOADS_TIMESTAMP).format(new Date());
        String nombreLimpio = nombreOriginal.replace(" ", "");
        return UPLOADS_TX_PREFIX+timeStamp+"_"+nombreLimpio;
    }

    public void copy(MultipartFile file, String nombreDestino) throws QandeMmiiException {
        var destino           = this.getUploadsPath(nombreDestino);

        try {
            Files.copy(file.getInputStream(), destino);
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error copiando archivo: "+e.getMessage());
        }
    }

    public Path getUploadsPath(String filename) {
        return Paths.get(appConfig.appConfigProperties.getUploadFolder()).resolve(filename).toAbsolutePath();
    }

    public Path getPathFromName(String strPath) {
        return Paths.get(strPath);
    }

    public boolean delete(String filename) throws QandeMmiiException {
        var rootPath           = this.getUploadsPath(filename);
        log.info("rootPath: {}", rootPath);
        var archivo = rootPath.toFile();

        if(archivo.exists() && archivo.canRead()) {
            try {
                Files.delete(rootPath);
            } catch (IOException e) {
                throw new QandeMmiiException(e, "Error al borrar el archivo: "+e.getMessage());
            }
        }
        return true;
    }

    public void vaciaDirectorioSubida() {
        FileSystemUtils.deleteRecursively(Paths.get(appConfig.appConfigProperties.getUploadFolder()).toFile());
    }

    public void creaDirectorioSubida() throws QandeMmiiException {
        try {
            Files.createDirectory(Paths.get(appConfig.appConfigProperties.getUploadFolder()));
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error creando directorio de subida archivos: "+e.getMessage());
        }
    }

    public void creaDirectorioLogs() throws QandeMmiiException {
        try {
            Files.createDirectory(Paths.get(appConfig.appConfigProperties.getLogFolder()));
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error creando directorio de LOGS: "+e.getMessage());
        }
    }

    public void creaDirectorioReportesMaestro() throws QandeMmiiException {
        try {
            Files.createDirectory(Paths.get(appConfig.appConfigProperties.getReportesMaestrosFolder()));
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error creando directorio de Reportes Maestro: "+e.getMessage());
        }
    }
    public void creaDirectorioDownloadable() throws QandeMmiiException {
        try {
            Files.createDirectory(Paths.get(appConfig.appConfigProperties.getDownloadableFolder()));
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error creando directorio de descargables: "+e.getMessage());
        }
    }

    public void creaDirectorioReporteInversiones(String fullPath) throws QandeMmiiException {
        if ( ! Files.exists(Paths.get(fullPath))) {
            try {
                Files.createDirectory(Paths.get(fullPath));
                CustomLog.getInstance().info("Directorio creado: ["+fullPath+"]");
            } catch (IOException e) {
                throw new QandeMmiiException(e, "Error creando directorio de Reportes Inversiones ["+fullPath+"]: "+e.getMessage());
            }
        }
    }
    public Resource cargarArchivo(String filename) throws QandeMmiiException, MalformedURLException {
        var pathArchivo = getUploadsPath(filename);
        log.info("pathArchivo: {}", pathArchivo);

        Resource recurso;

        recurso = new UrlResource(pathArchivo.toUri());
        if (!recurso.exists() && !recurso.isReadable()) {
            throw new QandeMmiiException("Error: no se puede cargar la imagen: " + pathArchivo.toString());
        }
        return recurso;
    }

    public Resource getFileAsResource(String ruta, String filename) throws QandeMmiiException {
        Resource recurso = null;
        try {
            var pathArchivo = Paths.get(ruta).resolve(filename).toAbsolutePath();
            recurso = new UrlResource(pathArchivo.toUri());
            if (!recurso.exists() && !recurso.isReadable()) {
                throw new QandeMmiiException("Error: no se puede cargar el archivo: " + pathArchivo.toString());
            }
        } catch (MalformedURLException e) {
            throw new QandeMmiiException(e, "Error  al acceder al archivo URL: "+e.getClass().getName()+"{"+e.getMessage()+"}");
        }
        return recurso;
    }
    public String[] listadoDeArchivosMaestros(String processDate) {
        FilenameFilter filtro = (arch, name) -> ( name.matches(processDate+".*") );
        var directorio	= new File(appConfig.appConfigProperties.getReportesMaestrosFolder());
        var listado = directorio.listFiles(filtro);
        Arrays.sort(listado, Comparator.comparingLong(File::lastModified));

        return this.arrayDeArchivosToArrayString(listado);
    }
    public void borraListadoDeArchivosMaestros(String processDate) {
        log.info("Borrando archivos con patrón processDate: {}", processDate);
        FilenameFilter filtro = (arch, name) -> ( name.matches(processDate+".*") );
        var directorio	= new File(appConfig.appConfigProperties.getReportesMaestrosFolder());
        var listadoPorBorrar= directorio.listFiles(filtro);
        for(var archivoPorBorrar : listadoPorBorrar) {
            log.info("Borrando archivo : {}", archivoPorBorrar.getAbsolutePath());
            try {
                Files.delete(archivoPorBorrar.toPath());
            } catch (IOException e) {
                CustomLog.getInstance().error("Error en borrar archivo ["+archivoPorBorrar.getAbsolutePath()+"]");
            }
        }

    }

    public String[] listadoDeSflZipPershingPorFecha(String processDateInPershingFormat) {
        return listadoDeSflZipPershingPorFechaIdSfl(processDateInPershingFormat, "*");
    }
    public String[] listadoDeSflZipPershingPorFechaIdSfl(String processDateInPershingFormat, String idSfl) {
        FilenameFilter filtro = (arch, name) -> ( name.matches(processDateInPershingFormat+"."+idSfl+".ZIP") );
        var directorio	= new File(ftpPershingProperties.getDownloadPath());
        return directorio.list(filtro);
    }

    public String serializaBase64(String ruta, String filename) throws QandeMmiiException {
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(ruta, filename));
        } catch (IOException e) {
            var msg = "Error al serializar base 64 archivo ["+ruta+"] ["+filename+"]: "+e.getMessage();
            CustomLog.getInstance().error(msg);
            throw new QandeMmiiException(e, msg);
        }
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public String obtieneExtension(String nombreArchivo) {
        return FilenameUtils.getExtension(nombreArchivo);
    }

    public String[] arrayDeArchivosToArrayString( File[] listFiles) {
        String[] filePaths = new String[listFiles.length];
        for (int i = 0; i < listFiles.length; i++) {
            filePaths[i] = listFiles[i].getName();
        }
        return filePaths;
    }
    public static String[] arrayDeArchivosToArrayString( File[] listFiles, boolean withFullPath) {
        String[] filePaths = new String[listFiles.length];
        for (int i = 0; i < listFiles.length; i++) {
            if (withFullPath) {
                filePaths[i] = listFiles[i].getAbsolutePath();
            } else {
                filePaths[i] = listFiles[i].getName();
            }
        }
        return filePaths;
    }

    public static List<String> listaArchivosPorExtension(String pathToDirectorio, String extension, boolean withFullPath) {
        var directorio	= new File(pathToDirectorio);
        FilenameFilter filtro = (arch, name) -> ( name.matches(".*"+extension) );
        var listado = directorio.listFiles(filtro);
        Arrays.sort(listado);
        return Arrays.asList(arrayDeArchivosToArrayString(listado, withFullPath));
    }

}
