package cl.qande.mmii.app.controllers;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping({"/login"})
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model, Principal principal, RedirectAttributes flash) {

        model.addAttribute("titulo", "Login");
        EstadoPeticion estadoPeticion =new EstadoPeticion();

        if(principal != null) {
            flash.addAttribute("info", "Ya ha iniciado sesión");
            model.addAttribute("info", "Ya ha iniciado sesión previamente");
            log.info("Sesión iniciada");
            return "redirect:/home";
        }
        if(error != null) {
            estadoPeticion.setCodigo(1);
            estadoPeticion.setMensaje("Error al iniciar sesión");
            estadoPeticion.setDetalle("Nombre de usuario o contraseña incorrecto.");
            estadoPeticion.setTipo("ERROR");
            model.addAttribute("status", estadoPeticion);
            model.addAttribute("error", "Error en el login: nombre de usuario o clave incorrecto");
            log.info("Error en login");
        }


        if(logout != null) {
            estadoPeticion.setCodigo(0);
            estadoPeticion.setMensaje("Sesión cerrada");
            estadoPeticion.setDetalle("Su sesión ha finalizado correctamente.");
            estadoPeticion.setTipo("INFO");
            model.addAttribute("status", estadoPeticion);
            model.addAttribute("success", "Ha cerrado sesión con éxito");
            log.info("Sesión cerrada");
        }

        return "login";

    }


}
