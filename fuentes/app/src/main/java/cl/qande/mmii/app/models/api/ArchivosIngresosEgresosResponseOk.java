package cl.qande.mmii.app.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ArchivosIngresosEgresosResponseOk extends ApiResponse {
    @JsonProperty("lista-archivos")
    private List<Archivo> listaArchivos;

    public ArchivosIngresosEgresosResponseOk(List<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }

    public ArchivosIngresosEgresosResponseOk() {
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
