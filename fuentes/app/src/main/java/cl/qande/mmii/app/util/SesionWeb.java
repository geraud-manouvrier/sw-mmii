package cl.qande.mmii.app.util;

import cl.qande.mmii.app.util.navegacion.Menu;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Component
@SessionScope
public class SesionWeb {

    private UUID uuid = UUID.randomUUID();
    private String appUsuario;
    private Collection<? extends GrantedAuthority> appRoles;

    private Menu appMenu;


    @PostConstruct
    public void inicializar() {
        //TODO: Inicializar con token y otros elementos
        this.uuid = UUID.randomUUID();
    }
    public void setAutenticacion(String username, Collection<? extends GrantedAuthority> roles) {
        this.appUsuario = username;
        this.appRoles = roles;
        this.appMenu    = new Menu();
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

    private boolean tieneRol(String role) {
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


}
