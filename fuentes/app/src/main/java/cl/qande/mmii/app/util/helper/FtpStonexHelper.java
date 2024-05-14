package cl.qande.mmii.app.util.helper;

import cl.qande.mmii.app.config.properties.FtpStonexProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FtpStonexHelper {

    @Autowired
    private FtpStonexProperties ftpStonexProperties;

    public String generateRemoteFilename(String processDateYyyymmdd) {
        return this.generateBaseFileName(processDateYyyymmdd);
    }
    public String generateLocalFilename(String baseName) {
        return this.generateBaseFileName(baseName);
    }
    public String generateSourceZipFileName(String baseName) {
        return ftpStonexProperties.getDownloadPath()+this.generateBaseFileName(baseName);
    }
    public String generateDestZipFolderName(String baseName) {
        return ftpStonexProperties.getWorkPath()+baseName;
    }
    private String generateBaseFileName(String baseName) {
        return ftpStonexProperties.getPreffixFileName()+baseName+ftpStonexProperties.getZipExtension();
    }
}
