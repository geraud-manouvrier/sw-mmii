package cl.qande.mmii.app.util.navegacion;

import cl.qande.mmii.app.models.exception.QandeMmiiException;

import java.util.ArrayList;
import java.util.List;

public class OpcionMenu {

    private static final String DEFAULT_CLASS_ICON = "far fa-circle nav-icon";
    private static final String DEFAULT_CLASS_LINK = "nav-link";
    private String clave;
    private String texto;
    private String rutaUrl;
    private String claseLink;
    private String claseIcono;
    private boolean activo;

    private List<String> listaRoles;

    public OpcionMenu(String clave, String texto, String rutaUrl, String claseLink, String claseIcono, Boolean activo) {
        this.clave = clave;
        this.texto = texto;
        this.rutaUrl = rutaUrl;
        this.claseLink = claseLink;
        this.claseIcono = claseIcono;
        this.activo = activo;
    }

    public OpcionMenu(String clave, String texto) {
        this.clave      = clave;
        this.texto = texto;
        this.claseIcono = DEFAULT_CLASS_ICON;
        this.claseLink  = DEFAULT_CLASS_LINK;
        this.activo     = false;
    }

    public OpcionMenu(String clave, String texto, String rutaUrl, boolean activo) {
        this.clave = clave;
        this.texto = texto;
        this.rutaUrl = rutaUrl;
        this.activo = activo;
        this.claseIcono = DEFAULT_CLASS_ICON;
        this.claseLink  = DEFAULT_CLASS_LINK;
        this.listaRoles = new ArrayList<>();
        this.listaRoles.add(Menu.roleOp(clave));
    }

    public OpcionMenu(String clave, String texto, String rutaUrl, boolean activo, List<String> listaRoles) {
        this.clave = clave;
        this.texto = texto;
        this.rutaUrl = rutaUrl;
        this.activo = activo;
        this.claseIcono = DEFAULT_CLASS_ICON;
        this.claseLink  = DEFAULT_CLASS_LINK;
        this.listaRoles = listaRoles;
    }

    public OpcionMenu(String clave, String texto, String rutaUrl, boolean activo, String role) {
        this.clave = clave;
        this.texto = texto;
        this.rutaUrl = rutaUrl;
        this.activo = activo;
        this.claseIcono = DEFAULT_CLASS_ICON;
        this.claseLink  = DEFAULT_CLASS_LINK;
        this.listaRoles = new ArrayList<>();
        this.listaRoles.add(role);

    }


    public String getClave() {
        return clave;
    }

    public String getTexto() throws QandeMmiiException {
        if (texto == null) {
            throw new QandeMmiiException("El campo texto del menú "+this.clave+" no ha sido inicializado");
        }
        return texto;
    }

    public String getRutaUrl() throws QandeMmiiException {
        if (rutaUrl == null) {
            throw new QandeMmiiException("El campo URL del menú "+this.clave+" no ha sido inicializado");
        }
        return rutaUrl;
    }

    public String getClaseLink() {
        if(this.getActivo()) {
            return claseLink.concat(" active");
        }
        return claseLink;
    }

    public String getClaseIcono() {
        return claseIcono;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setRutaUrl(String rutaUrl) {
        this.rutaUrl = rutaUrl;
    }

    public void setClaseLink(String claseLink) {
        this.claseLink = claseLink;
    }

    public void setClaseIcono(String claseIcono) {
        this.claseIcono = claseIcono;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    public List<String> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<String> listaRoles) {
        this.listaRoles = listaRoles;
    }

    public String getListaRolesAsString() {
        if(listaRoles == null || listaRoles.isEmpty()) {
            return null;
        }
        var commaseparatedlist = listaRoles.toString();

        commaseparatedlist
                = commaseparatedlist.replace("[", "'")
                .replace("]", "'")
                .replace(",", "','");
        return commaseparatedlist;
    }
    public boolean tieneAcceso(List<String> listaDeRoles) {

        for (String rolActual : listaDeRoles) {
            if (this.listaRoles.contains(rolActual)) {
                return true;
            }
        }
        return false;
    }
}
