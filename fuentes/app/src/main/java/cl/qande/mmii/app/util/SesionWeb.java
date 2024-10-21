package cl.qande.mmii.app.util;

import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Component
@SessionScope
public class SesionWeb {

    private static final int MAX_CANT_NOTIF    = 100;
    private UUID uuid = UUID.randomUUID();
    private String appUsuario;
    private Collection<? extends GrantedAuthority> appRoles;

    private Menu appMenu;
    private List<String> notifications = new ArrayList<>();


    public void setAutenticacion(String username, Collection<? extends GrantedAuthority> roles) {
        this.appUsuario = username;
        this.appRoles = roles;
        this.appMenu    = new Menu();
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Menu getAppMenu() {
        return appMenu;
    }

    public List<String> listaDeRoles() {

        List<String> roles = new ArrayList<>();
        for (GrantedAuthority rolActual : this.appRoles) {
            roles.add(rolActual.getAuthority());
        }
        return roles;
    }

    public String getUsuario() {
        return appUsuario;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return appRoles;
    }

    public boolean tieneRol(String role) {
        var context = SecurityContextHolder.getContext();
        if (context == null) {
            return false;
        }
        var auth = context.getAuthentication();
        if (auth == null) {
            return false;
        }
        Collection<? extends GrantedAuthority> authorities	= auth.getAuthorities();
        for (GrantedAuthority authority: authorities) {
            if(role.equals(authority.getAuthority())) {
                return true;
            }
        }
        return false;

    }
    public List<String> getNotifications() {
        return notifications;
    }
    public void clearNotifications() {
        getNotifications().clear();
    }
    public void addNotification(String message) {
        if (getNotifications().size() >= MAX_CANT_NOTIF) {
            getNotifications().remove(0);
        }
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = horaActual.format(formatoHora);
        getNotifications().add(horaFormateada+" - "+message);
    }

    public void addNotification(List<FieldError> listOfErrors) {
        for ( var error : listOfErrors ) {
            var rejectedVal = error.getRejectedValue();
            if (rejectedVal!=null)
                addNotification("Campo "+error.getField()+" no admite valor ["+rejectedVal+"]");
            else
                addNotification("Campo "+error.getField()+" es obligatorio]");
        }
    }

}
