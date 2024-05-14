package cl.qande.mmii.app.controllers;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.dao.IUsuarioDao;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.UsuariosHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class UsuarioRolController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String URL_BASE    = "usuarios/panel_usuario";
    private static final String MSG_ERROR_CLAVE    = "Error al modificar clave";

    @Autowired
    private IUsuarioDao usuarioDao;
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private UsuariosHelper usuariosHelper;

    @GetMapping({"/usuario"})
    public String panelUsuario(
            Model model) throws QandeMmiiException {

        appConfig.customLog.info("Pasando por método /usuario: ["+sesionWeb.getUsuario()+"]");
        model.addAttribute(CAMPO_TITULO, "Panel Usuario");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        sesionWeb.getAppMenu().cambiaNavegacion("", false);
        return URL_BASE;
    }

    @PostMapping({"/usuario/clave"})
    public String cambioClave(
            Model model,
            Principal principal,
            @RequestParam(value= "passwd") String passwd,
            @RequestParam(value= "passwd_repeat") String passwdRepeat) throws QandeMmiiException {
        appConfig.customLog.info("Modificando clave: ["+sesionWeb.getUsuario()+"]");
        var estadoPeticion   = new EstadoPeticion();
        if (principal!= null) {
            if (passwd.equals(passwdRepeat)) {
                var validacion  = usuariosHelper.validaClave(passwd);
                if(validacion.isEmpty()) {
                    var encodedPass = usuariosHelper.generaEncodedPassword(passwd);
                    var usuarioBd   =usuarioDao.findByUsername(sesionWeb.getUsuario());
                    usuarioBd.setPassword(encodedPass);
                    try {
                        usuarioDao.save(usuarioBd);
                        estadoPeticion.setEstadoOk("Clave modificada", "Contraseña modificada correctamente");
                    } catch (Exception e) {
                        estadoPeticion.setEstadoError(MSG_ERROR_CLAVE, "Hubo un error, intente nuevamente.");
                    }
                } else {
                    estadoPeticion.setEstadoError(MSG_ERROR_CLAVE, "La contraseñas no cumple requisitos mínimos: "+validacion);
                }
            } else {
                estadoPeticion.setEstadoError(MSG_ERROR_CLAVE, "Las contraseñas no son iguales.");
            }

        } else {
            estadoPeticion.setEstadoError(MSG_ERROR_CLAVE, "Hubo un error al validar el usuario.");
        }
        if (estadoPeticion.getCodigo().equals(0)) {
            appConfig.customLog.info("Modifcación contraseña: "+estadoPeticion.getDetalle());
        } else {
            appConfig.customLog.error("Error Modifcación contraseña: "+estadoPeticion.getDetalle());
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return panelUsuario(model);
    }

}
