package cl.qande.mmii.app.auth.handler;

import cl.qande.mmii.app.models.db.core.entity.EstadoPeticion;
import cl.qande.mmii.app.util.SesionWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private SesionWeb sesionWeb;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var sessionFlashMapManager   = new SessionFlashMapManager();
        var flashMap   = new FlashMap();
        var estadoPeticion =new EstadoPeticion();
        estadoPeticion.setEstadoOk("Bienvenido " + authentication.getName(), "Sesión iniciada correctamente");
        flashMap.put("status", estadoPeticion);
        sessionFlashMapManager.saveOutputFlashMap(flashMap, request, response);

        logger.info("El usuario '"+authentication.getName()+"' ha iniciado sesión con éxito");
        sesionWeb.setAutenticacion(authentication.getName(), authentication.getAuthorities());


        super.onAuthenticationSuccess(request, response, authentication);
    }
}