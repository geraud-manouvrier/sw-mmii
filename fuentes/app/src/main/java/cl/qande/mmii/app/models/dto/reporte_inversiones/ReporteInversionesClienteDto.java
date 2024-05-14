package cl.qande.mmii.app.models.dto.reporte_inversiones;

import cl.qande.mmii.app.models.db.rep_inv.entity.RentabilidadCalculada;
import cl.qande.mmii.app.models.dto.ClienteDto;
import cl.qande.mmii.app.models.dto.ContratoDto;
import cl.qande.mmii.app.models.dto.CuentaDto;
import cl.qande.mmii.app.models.dto.PerfilCuentaDto;

import java.util.ArrayList;
import java.util.List;

public class ReporteInversionesClienteDto {

    private String processDate;
    private String idCliente;
    private String nombreArchivo;
    private String nombreGraficoBarras;
    private String nombreGraficoLineas;
    //Pueden ir otros campos necesarios para distribución u otros propósitos

    private DatosClienteDto datosCliente;
    private RentabilidadCalculada rentabilidadCliente;
    private List<RentabilidadCalculada> rentabilidadAnualBase100;
    private List<DatosCuentaDto> datosCuentas;



    public ReporteInversionesClienteDto(String idCliente, String processDate) {
        this.idCliente = idCliente;
        this.processDate = processDate;
        this.datosCuentas = new ArrayList<>();

    }

    public void addDatosCuenta(ContratoDto contratoDto, CuentaDto cuentaDto, PerfilCuentaDto perfilCuentaDto, RentabilidadCalculada rentabilidadCalculada) {
        DatosCuentaDto datosCuentaDto = new DatosCuentaDto(contratoDto, cuentaDto, perfilCuentaDto, rentabilidadCalculada);
        this.datosCuentas.add(datosCuentaDto);
    }
    public void initialize(ClienteDto cliente, RentabilidadCalculada rentabilidadCliente, List<RentabilidadCalculada> rentabilidadAnualBase100) {
        this.generaNombreArchivos();
        //Datos de cliente
        this.datosCliente = new DatosClienteDto(cliente);
        this.rentabilidadCliente = rentabilidadCliente;
        this.rentabilidadAnualBase100 = rentabilidadAnualBase100;


    }
    private void generaNombreArchivos() {
        String baseName = "ReporteInversiones_" + idCliente + "_" + processDate;
        this.nombreArchivo = baseName + ".pdf";
        this.nombreGraficoBarras = baseName + "_ImgBars.png";
        this.nombreGraficoLineas = baseName + "_ImgLines.png";
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getNombreGraficoBarras() {
        return nombreGraficoBarras;
    }

    public String getNombreGraficoLineas() {
        return nombreGraficoLineas;
    }

    public String getProcessDate() {
        return processDate;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public DatosClienteDto getDatosCliente() {
        return datosCliente;
    }

    public RentabilidadCalculada getRentabilidadCliente() {
        return rentabilidadCliente;
    }

    public List<DatosCuentaDto> getDatosCuentas() {
        return datosCuentas;
    }

    public List<RentabilidadCalculada> getRentabilidadAnualBase100() {
        return rentabilidadAnualBase100;
    }

    @Override
    public String toString() {
        return "ReporteInversionesClienteDto{" +
                "processDate='" + processDate + '\'' +
                ", idCliente='" + idCliente + '\'' +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                ", nombreGraficoBarras='" + nombreGraficoBarras + '\'' +
                ", nombreGraficoLineas='" + nombreGraficoLineas + '\'' +
                ", datosCliente=" + datosCliente +
                ", rentabilidadCliente=" + rentabilidadCliente +
                ", rentabilidadAnualBase100=" + rentabilidadAnualBase100 +
                ", datosCuentas=" + datosCuentas +
                '}';
    }
}
