package cl.qande.mmii.app.controllers;

import cl.qande.mmii.app.config.AppConfig;
import cl.qande.mmii.app.models.db.core.dao.IUsuarioDao;
import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.models.exception.QandeMmiiException;
import cl.qande.mmii.app.util.SesionWeb;
import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.helper.UsuariosHelper;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios/admin_users")
public class AdminUsersController {

    private static final String CAMPO_TITULO    = "titulo";
    private static final String CAMPO_STATUS    = "status";
    private static final String CAMPO_SESION    = "sesionWeb";
    private static final String MSG_ERROR_CLAVE    = "Error al modificar clave";

    @Autowired
    private IUsuarioDao usuarioDao;
    @Autowired
    private SesionWeb sesionWeb;
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private UsuariosHelper usuariosHelper;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({""})
    public String listaUsuarios(
            Model model) throws QandeMmiiException {

        CustomLog.getInstance().info("Pasando por método listado: ["+sesionWeb.getUsuario()+"]");
        try {
        model.addAttribute("listaUsuarios", usuarioDao.findAll());
        } catch (Exception e) {
            CustomLog.getInstance().error("Error al listar usuarios: "+e.getMessage());
        }
        model.addAttribute(CAMPO_TITULO, "Lista Usuarios");
        model.addAttribute(CAMPO_SESION, sesionWeb);
        return sesionWeb.getAppMenu().cambiaNavegacion(Menu.USUARIOS_CUENTAS, false);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping({"/reset_passwd/{username}"})
    public String cambioClave(
            @PathVariable(value= "username") String username,
            Model model) throws QandeMmiiException {
        CustomLog.getInstance().info("Reseteando clave por ["+sesionWeb.getUsuario()+"] para ["+username+"]");
        var estadoPeticion   = new EstadoPeticion();

        var defaultPwd  = appConfig.appConfigProperties.getDefaultPwd();
        var encodedPass = usuariosHelper.generaEncodedPassword(defaultPwd);
        var usuarioBd   =usuarioDao.findByUsername(username);
        usuarioBd.setPassword(encodedPass);
        try {
            usuarioDao.save(usuarioBd);
            estadoPeticion.setEstadoOk("Clave reseteada", "Contraseña reseteada correctamente ["+defaultPwd+"]");
        } catch (Exception e) {
            estadoPeticion.setEstadoError(MSG_ERROR_CLAVE, "Hubo un error, intente nuevamente.");
        }

        model.addAttribute(CAMPO_STATUS, estadoPeticion);
        return this.listaUsuarios(model);
    }

}
