package cl.qande.mmii.app.models.service;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.config.ProxySocketFactory;
import cl.qande.mmii.app.config.properties.FtpPershingProperties;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ConnectException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

@Service
public class FtpPershingService {
    //https://www.baeldung.com/java-file-sftp

    @Autowired
    private AppConfig appConfig;
    @Autowired
    private FtpPershingProperties ftpPershingProperties;

    private SSHClient sshClient;
    private SFTPClient sftpClient;

    private static final String ERROR_CONEXION      = "Error al conectarse al servidor SFTP Pershing: ";
    private static final String ERROR_DESCONEXION   = "Error al cerrar conexión al servidor SFTP Pershing: ";
    private static final String ERROR_LISTAR   = "Error al listar directorio desde SFTP Pershing: ";

    public List<RemoteResourceInfo> contenidoDirectorio() throws QandeMmiiException {
        var remotePath	= ftpPershingProperties.getServerPath();
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
    public List<String> downloadAllFiles() throws QandeMmiiException {
        return this.downloadFilesByPattern("");
    }
    public List<String> downloadFilesByPattern(String remoteFilePattern) throws QandeMmiiException {
        List<String> listaDescargados = new ArrayList<>();
        var remotePath	= ftpPershingProperties.getServerPath();
        var downloadPath= ftpPershingProperties.getDownloadPath();
        appConfig.customLog.info("Iniciando listado de ["+remotePath+"]");
        List<RemoteResourceInfo> contenidoDir;

        try {
            this.openConnection();
        } catch (IOException e) {
            appConfig.customLog.error(ERROR_CONEXION+e.getMessage());
            throw new QandeMmiiException(e, ERROR_CONEXION+e.getMessage());
        }
        try {
            contenidoDir    = sftpClient.ls(remotePath);
            appConfig.customLog.info("El directorio del cual se descargarán archivos '*"+remoteFilePattern+"*' contiene ["+contenidoDir.size()+"] elementos: ["+contenidoDir.toString()+"]");
        } catch (IOException e) {
            appConfig.customLog.error(ERROR_LISTAR+e.getMessage());
            throw new QandeMmiiException(e, ERROR_LISTAR+e.getMessage());
        }
        for (var archivoRemoto : contenidoDir) {
            try {
                if (archivoRemoto.getName().contains(remoteFilePattern)) {
                    appConfig.customLog.info("Bajando archivo ["+archivoRemoto.getPath()+"]");
                    sftpClient.get(archivoRemoto.getPath() , downloadPath+archivoRemoto.getName());
                    listaDescargados.add(archivoRemoto.getName());
                } else {
                    appConfig.customLog.info("Omitiendo archivo ["+archivoRemoto.getPath()+"]");
                }

            } catch (IOException e) {
                appConfig.customLog.error("Error bajando archivo ["+archivoRemoto.getPath()+"]");
                throw new RuntimeException(e);
            }
        }
        try {
            closeConnection();
        } catch (IOException e) {
            appConfig.customLog.error(ERROR_DESCONEXION+e.getMessage());
            throw new QandeMmiiException(e, ERROR_DESCONEXION+e.getMessage());
        }
        return listaDescargados;
    }

    public List<RemoteResourceInfo> listDir() throws QandeMmiiException {
        var remotePath	= ftpPershingProperties.getServerPath();
        appConfig.customLog.info("Iniciando listado de ["+remotePath+"]");
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

    private void openConnection() throws IOException {
        Security.addProvider(new BouncyCastleProvider());

        var server		= ftpPershingProperties.getServer();
        int port		= ftpPershingProperties.getPort();
        var username	= ftpPershingProperties.getUsername();
        var password	= ftpPershingProperties.getPassword();
        var sshKey      = ftpPershingProperties.getSshPrivateKey();
        var useSshKey   = ftpPershingProperties.isUseSshKey();
        var proxyPort   = ftpPershingProperties.getUseProxyPort();
        appConfig.customLog.info("Iniciando conexión SFTP Pershing a ["+username+"@"+server+":"+port+"]");

        this.sshClient = new SSHClient();
        this.sshClient.addHostKeyVerifier(new PromiscuousVerifier());

        if (proxyPort>0) {
            appConfig.customLog.info("Usando proxy para SFTP Pershing en puerto ["+proxyPort+"]");
            ProxySocketFactory proxySocketFactory = new ProxySocketFactory("localhost", proxyPort);
            this.sshClient.setSocketFactory(proxySocketFactory);
        }

        try {
            this.sshClient.connect(server, port);
        } catch (ConnectException e) {
            appConfig.customLog.error("Error de conexión a FTP ["+e.getMessage()+"]");
            appConfig.customLog.info("Intentando por segunda vez...");
            this.sshClient.connect(server, port);
        } catch (Exception e) {
            appConfig.customLog.error("Error desconocido conexión a FTP ["+e.getMessage()+"]; cause: "+e.getCause());
            throw e;
        }

        if (useSshKey) {
            appConfig.customLog.info("Usando autenticación con SSH KEY en ["+sshKey+"]");
            this.sshClient.authPublickey(username, sshKey);
        } else {
            appConfig.customLog.info("Usando autenticación con password");
            this.sshClient.authPassword(username, password);
        }
        this.sftpClient = this.sshClient.newSFTPClient();

    }

    private void closeConnection() throws IOException {
        this.sftpClient.close();
        this.sshClient.disconnect();
    }
}
