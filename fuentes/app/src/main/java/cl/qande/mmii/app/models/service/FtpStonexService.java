package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.ProxySocketFactory;
import cl.qande.mmii.app.config.properties.FtpStonexProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.exception.SchemaStonexException;
import cl.qande.mmii.app.util.helper.FtpStonexHelper;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.sftp.Response;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.sftp.SFTPException;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FtpStonexService {
    //https://www.baeldung.com/java-file-sftp

    @Autowired
    private FtpStonexProperties ftpStonexProperties;
    @Autowired
    private FtpStonexHelper ftpStonexHelper;
    @Autowired
    private NotificacionEmail notificacionEmail;
    @Autowired
    private AppConfig appConfig;

    private SSHClient sshClient;
    private SFTPClient sftpClient;

    private static final String ERROR_CONEXION      = "Error al conectarse al servidor SFTP Stonex: ";
    private static final String ERROR_DESCONEXION   = "Error al cerrar conexión al servidor SFTP Stonex: ";
    private static final String ERROR_LISTAR   = "Error al listar directorio desde SFTP Stonex: ";


    public List<RemoteResourceInfo> contenidoDirectorio() throws QandeMmiiException {
        var remotePath	= ftpStonexProperties.getServerPath();
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
    public void downloadByDate(String processDate, String processStamp) throws QandeMmiiException {
        var remotePath	= ftpStonexProperties.getServerPath();
        var remoteFile  = ftpStonexHelper.generateRemoteFilename(processDate);
        var localPath   = ftpStonexProperties.getDownloadPath();
        var localFile   = ftpStonexHelper.generateLocalFilename(processDate+processStamp);

        try {
            openConnection();
        } catch (IOException e) {
            notificacionEmail.notificarErrorProcesoSchemasStonex(processDate, "Error conexión SFTP");
            throw new SchemaStonexException(e, ERROR_CONEXION+e.getMessage(), processDate, processStamp);
        }
        try {
            sftpClient.get(remotePath+remoteFile, localPath + localFile);
        } catch (IOException e) {
            if ( (e instanceof SFTPException) && ( ((SFTPException) e).getStatusCode().equals(Response.StatusCode.NO_SUCH_FILE) ) ) {
                appConfig.customLog.info("Archivo no encontrado ["+remotePath+remoteFile+"]; omitiendo excepción");
            } else {
                notificacionEmail.notificarErrorProcesoSchemasStonex(processDate, "Error descarga desde SFTP");
                throw new SchemaStonexException(e, "Error al descargar archivo desde SFTP: "+e.getMessage(), processDate, processStamp);
            }
        }
        try {
            closeConnection();
        } catch (IOException e) {
            notificacionEmail.notificarErrorProcesoSchemasStonex(processDate, "Error cerrando conexión SFTP");
            throw new SchemaStonexException(e, ERROR_DESCONEXION+e.getMessage(), processDate, processStamp);
        }
    }

    private void openConnection() throws IOException {
        var server		= ftpStonexProperties.getServer();
        int port		= ftpStonexProperties.getPort();
        var username	= ftpStonexProperties.getUsername();
        var password	= ftpStonexProperties.getPassword();

        this.sshClient = new SSHClient();
        this.sshClient.addHostKeyVerifier(new PromiscuousVerifier());

        if (ftpStonexProperties.getUseProxyPort()>0) {
            ProxySocketFactory proxySocketFactory = new ProxySocketFactory("localhost", ftpStonexProperties.getUseProxyPort());
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
