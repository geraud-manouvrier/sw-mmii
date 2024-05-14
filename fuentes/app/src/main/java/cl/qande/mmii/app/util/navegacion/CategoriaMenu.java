package cl.qande.mmii.app.util.navegacion;


import cl.qande.mmii.app.models.exception.QandeMmiiException;

import java.util.ArrayList;
import java.util.List;

public class CategoriaMenu {

    private String clave;
    private String texto;
    private List<OpcionMenu> listaOpciones;
    private List<String> listaRoles;
    private boolean activo;
    private String claseLink;
    private String claseIcono;
    private String claseIconoExpansion;
    private String rutaUrl;

    public CategoriaMenu(String clave, String texto) {
        this.clave          = clave;
        this.texto          = texto;
        this.inicializaValores();
    }

    public CategoriaMenu(String clave, String texto, boolean activo, String claseIcono, List<OpcionMenu> listaOpciones) {
        this.inicializaValores();
        this.clave = clave;
        this.texto          = texto;
        this.activo = activo;
        this.claseIcono = claseIcono;
        this.listaOpciones  = listaOpciones;
    }
    public CategoriaMenu(String clave, String texto, boolean activo, String claseIcono) {
        this.inicializaValores();
        this.clave = clave;
        this.texto          = texto;
        this.activo = activo;
        this.claseIcono = claseIcono;
    }

    private void inicializaValores() {
        this.rutaUrl        = "#";
        this.activo         = false;
        this.listaOpciones  = new ArrayList<>();
        this.listaRoles     = new ArrayList<>();
        this.claseLink      = "nav-link";
        this.claseIcono     = "nav-icon fas fa-cog";
        this.claseIconoExpansion    = "right fas fa-angle-left";
    }

    public void desativaOpciones() {
        for (OpcionMenu opcionActual : listaOpciones) {
            opcionActual.setActivo(false);
        }
    }

    public String getUrlPorClave(String claveBuscada, boolean cambiaEstado) throws QandeMmiiException {
        var ruta  = "";
        for (OpcionMenu opcionActual : listaOpciones) {
            if(cambiaEstado) {
                opcionActual.setActivo(false);
            }
            if (opcionActual.getClave().equals(claveBuscada)) {
                ruta = opcionActual.getRutaUrl();
                if(cambiaEstado) {
                    opcionActual.setActivo(true);
                }
            }
        }
        return ruta;
    }

    public boolean tieneAcceso(List<String> listaDeRoles) {

        for (String rolActual : listaDeRoles) {
            if (this.listaRoles.contains(rolActual)) {
                return true;
            }
        }
        return false;
    }
    public String getClave() {
        return clave;
    }

    public List<OpcionMenu> getListaOpciones() {
        return listaOpciones;
    }

    public String getClaseIcono() {
        return claseIcono;
    }

    public String getClaseIconoExpansion() {
        return claseIconoExpansion;
    }

    public String getRutaUrl() {
        return rutaUrl;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setListaOpciones(List<OpcionMenu> listaOpciones) {
        this.listaOpciones = listaOpciones;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setClaseLink(String claseLink) {
        this.claseLink = claseLink;
    }

    public void setClaseIcono(String claseIcono) {
        this.claseIcono = claseIcono;
    }

    public void setClaseIconoExpansion(String claseIconoExpansion) {
        this.claseIconoExpansion = claseIconoExpansion;
    }

    public void setRutaUrl(String rutaUrl) {
        this.rutaUrl = rutaUrl;
    }

    public String getClaseLink() {
        if(this.activo) {
            return claseLink.concat(" active");
        }
        return claseLink;
    }

    public boolean isActivo() {
        return activo;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
