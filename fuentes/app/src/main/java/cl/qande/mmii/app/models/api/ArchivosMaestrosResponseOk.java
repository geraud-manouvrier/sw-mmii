package cl.qande.mmii.app.models.api;

import java.util.ArrayList;
import java.util.List;

public class ArchivosMaestrosResponseOk extends ApiResponse {
    private List<Archivo> listaArchivos;

    public ArchivosMaestrosResponseOk(List<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }

    public ArchivosMaestrosResponseOk() {
        this.listaArchivos = new ArrayList<>();
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }

    public List<Archivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(List<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }
}
