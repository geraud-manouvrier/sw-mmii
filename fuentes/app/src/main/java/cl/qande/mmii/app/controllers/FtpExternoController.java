package cl.qande.mmii.app.controllers;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.models.service.FtpPershingService;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.navegacion.Menu;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ftp_externo")
public class FtpExternoController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String URL_BASE    = "lista_archivos_ftp";
    private static final String OK_MSG    = "Listado ok";
    private static final String OK_DET    = "Directorio listado correctamente";
    private static final String ERR_MSG    = "Listado con errores";
    private static final String ERR_DET    = "Directorio no pudo ser listado";
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private FtpPershingService ftpPershingService;
    @GetMapping({"/{ftpName}/listar"})
    public String listarFtpStonex(
            @PathVariable String ftpName,
            Model model) throws QandeMmiiException {
        var estadoPeticion   = new EstadoPeticion();
        List<RemoteResourceInfo> listaArchivos  = null;
        try {
            estadoPeticion.setEstadoOk(OK_MSG, OK_DET);
            switch (ftpName) {
                case "pershing":
                    sesionWeb.getAppMenu().cambiaNavegacion(Menu.LS_FTP_PERSHING, false);
                    listaArchivos = ftpPershingService.contenidoDirectorio();
                    break;
                default:
                    estadoPeticion.setEstadoWarning("Nombre FTP incorrecto", "El nombre del FTP ["+ftpName+"] es inválido");
                    appConfig.customLog.error("El nombre del FTP ["+ftpName+"] es inválido");
                    break;
            }
            if(listaArchivos!=null) {
                appConfig.customLog.info("Contenido FTP "+ftpName+": "+listaArchivos.toString());
            }
        } catch (Exception e) {
            appConfig.customLog.error("Error al listar contenido FTP "+ftpName+": "+e.getMessage());
            estadoPeticion.setEstadoError(ERR_MSG, ERR_DET);
        }
        model.addAttribute("listaArchivos", listaArchivos);
        model.addAttribute(CAMPO_TITULO, ftpName);
        model.addAttribute(CAMPO_SESION, sesionWeb);
        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return URL_BASE;
    }


}
