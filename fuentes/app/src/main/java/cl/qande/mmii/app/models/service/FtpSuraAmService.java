package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.ProxySocketFactory;
import cl.qande.mmii.app.config.properties.FtpSuraAmProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Security;
import java.util.List;

@Service
public class FtpSuraAmService {
    //https://www.baeldung.com/java-file-sftp

    @Autowired
    private FtpSuraAmProperties ftpSuraAmProperties;
    @Autowired
    private AppConfig appConfig;

    private SSHClient sshClient;
    private SFTPClient sftpClient;

    private static final String ERROR_CONEXION      = "Error al conectarse al servidor SFTP SURA Chile: ";
    private static final String ERROR_DESCONEXION   = "Error al cerrar conexión al servidor SFTP SURA Chile: ";
    private static final String ERROR_LISTAR   = "Error al listar directorio desde SFTP SURA Chile: ";


    public List<RemoteResourceInfo> contenidoDirectorio() throws QandeMmiiException {
        var remotePath	= ftpSuraAmProperties.getServerPath();
        List<RemoteResourceInfo> contenidoDir;
        try {
            this.openConnection();
        } catch (IOException e) {
            appConfig.customLog.error(ERROR_CONEXION+e.getMessage());
            throw new QandeMmiiException(e, ERROR_CONEXION+e.getMessage());
        }
        try {
            contenidoDir    = sftpClient.ls(remotePath);
        } catch (IOException e) {
            appConfig.customLog.error(ERROR_LISTAR+e.getMessage());
            throw new QandeMmiiException(e, ERROR_LISTAR+e.getMessage());
        }
        try {
            closeConnection();
        } catch (IOException e) {
            appConfig.customLog.error(ERROR_DESCONEXION+e.getMessage());
            throw new QandeMmiiException(e, ERROR_DESCONEXION+e.getMessage());
        }
        return contenidoDir;
    }

    public void cargarArchivo(String rutaArchivoLocal) throws QandeMmiiException {
        try {
            this.openConnection();
        } catch (IOException e) {
            throw new QandeMmiiException(e, ERROR_CONEXION+e.getMessage());
        }
        try {
            sftpClient.put(rutaArchivoLocal, ftpSuraAmProperties.getServerPath());
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error al subir archivo ["+rutaArchivoLocal+"] a SFTP SURA: ["+e.getMessage()+"]");
        }
        try {
            closeConnection();
        } catch (IOException e) {
            throw new QandeMmiiException(e, ERROR_DESCONEXION+e.getMessage());
        }
    }

    public void eliminaArchivo(String nombreArchivoRemoto) throws QandeMmiiException {
        try {
            this.openConnection();
        } catch (IOException e) {
            throw new QandeMmiiException(e, ERROR_CONEXION+e.getMessage());
        }
        var archivoPorEliminar  = ftpSuraAmProperties.getServerPath()+nombreArchivoRemoto;
        try {
            sftpClient.rm(archivoPorEliminar);
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error al eliminar archivo ["+archivoPorEliminar+"] a SFTP SURA: ["+e.getMessage()+"]");
        }
        try {
            closeConnection();
        } catch (IOException e) {
            throw new QandeMmiiException(e, ERROR_DESCONEXION+e.getMessage());
        }
    }
    public List<RemoteResourceInfo> listDir() throws QandeMmiiException {
        var remotePath	= ftpSuraAmProperties.getServerPath();
        List<RemoteResourceInfo> contenidoDir;

        try {
            this.openConnection();
        } catch (IOException e) {
            throw new QandeMmiiException(e, ERROR_CONEXION+e.getMessage());
        }
        try {
            contenidoDir    = sftpClient.ls(remotePath);
        } catch (IOException e) {
            throw new QandeMmiiException(e, "Error al listar directorio desde SFTP: "+e.getMessage());
        }
        try {
            closeConnection();
        } catch (IOException e) {
            throw new QandeMmiiException(e, ERROR_DESCONEXION+e.getMessage());
        }
        return contenidoDir;
    }

    private void openConnection() throws IOException {
        Security.addProvider(new BouncyCastleProvider());

        var server		= ftpSuraAmProperties.getServer();
        int port		= ftpSuraAmProperties.getPort();
        var username	= ftpSuraAmProperties.getUsername();
        var password	= ftpSuraAmProperties.getPassword();

        this.sshClient = new SSHClient();
        this.sshClient.addHostKeyVerifier(new PromiscuousVerifier());

        if (ftpSuraAmProperties.getUseProxyPort()>0) {
            ProxySocketFactory proxySocketFactory = new ProxySocketFactory("localhost", ftpSuraAmProperties.getUseProxyPort());
            this.sshClient.setSocketFactory(proxySocketFactory);
        }

        this.sshClient.connect(server, port);
        this.sshClient.authPassword(username, password);
        this.sftpClient = this.sshClient.newSFTPClient();

    }

    private void closeConnection() throws IOException {
        this.sftpClient.close();
        this.sshClient.disconnect();
    }
}
