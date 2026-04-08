package cl.qande.mmii.app.util;

import cl.qande.mmii.app.util.helper.CustomLog;
import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PreDestroy;
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
    private final List<Notification> notifications = new ArrayList<>();

    @PreDestroy
    public void onSessionDestroy() {
        clearNotifications();
    }


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
    public List<Notification> getNotifications() {
        return notifications;
    }
    public void clearNotifications() {
        getNotifications().clear();
    }
    //TODO: Migrar notififaciones por Log (Log agregará notififcación)
    public void addNotification(String message) {
        addNotification(message, NotificationType.INFO);
    }
    // Nuevo método: acepta tipo
    public void addNotification(String message, NotificationType type) {
        if (notifications.size() >= MAX_CANT_NOTIF) {
            notifications.remove(0);
        }
        Notification n = new Notification(message, type);
        notifications.add(n);
        CustomLog.getInstance().info("[" + type + "]: " + message, false);
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
