package cl.qande.mmii.app.models.api.reportes_maestros;

import cl.qande.mmii.app.models.api.ApiResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ReporteMaestrosResponseOk extends ApiResponse {

    @JsonProperty("maestro-movimientos")
    private List<MaestroMovimientosApiDto> maestroMovimientos;
    @JsonProperty("maestro-saldos")
    private List<MaestroSaldosApiDto> maestroSaldos;
    @JsonProperty("maestro-relacionado-cuenta")
    private List<MaestroRelacionadosApiDto> maestroRelacionados;

    public ReporteMaestrosResponseOk(List<MaestroMovimientosApiDto> maestroMovimientos, List<MaestroSaldosApiDto> maestroSaldos, List<MaestroRelacionadosApiDto> maestroRelacionados) {
        this.maestroMovimientos = maestroMovimientos;
        this.maestroSaldos = maestroSaldos;
        this.maestroRelacionados = maestroRelacionados;
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }

    public ReporteMaestrosResponseOk() {
        this.maestroMovimientos = new ArrayList<>();
        this.maestroSaldos = new ArrayList<>();
        this.maestroRelacionados = new ArrayList<>();
        this.setCode(0);
        this.setMessage("Mensaje recibido correctamente");
    }

    public List<MaestroMovimientosApiDto> getMaestroMovimientos() {
        return maestroMovimientos;
    }

    public void setMaestroMovimientos(List<MaestroMovimientosApiDto> maestroMovimientos) {
        this.maestroMovimientos = maestroMovimientos;
    }

    public List<MaestroSaldosApiDto> getMaestroSaldos() {
        return maestroSaldos;
    }

    public void setMaestroSaldos(List<MaestroSaldosApiDto> maestroSaldos) {
        this.maestroSaldos = maestroSaldos;
    }

    public List<MaestroRelacionadosApiDto> getMaestroRelacionados() {
        return maestroRelacionados;
    }

    public void setMaestroRelacionados(List<MaestroRelacionadosApiDto> maestroRelacionados) {
        this.maestroRelacionados = maestroRelacionados;
    }
}
