package cl.qande.mmii.app.models.dto.reporte_inversiones;

import cl.qande.mmii.app.models.dto.ClienteDto;

public class DatosClienteDto {

    private String nombreCliente;
    private String mailCliente;
    private String nombreAsesor;
    private String mailAsesor;
    private String residenteFiscalUsa;
    private String paisCiudadania;



    public DatosClienteDto(ClienteDto cliente) {
        this.nombreCliente = cliente.getNombre();
        this.mailCliente = cliente.getMail();
        this.nombreAsesor = cliente.getAsesorPrincipal();
        this.mailAsesor = cliente.getMailAsesorPrincipal();
        this.residenteFiscalUsa = cliente.getResidenteFiscalUsa();
        this.paisCiudadania = cliente.getCodPaisResidencia();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getMailCliente() {
        return mailCliente;
    }

    public String getNombreAsesor() {
        return nombreAsesor;
    }

    public String getMailAsesor() {
        return mailAsesor;
    }

    public String getResidenteFiscalUsa() {
        return residenteFiscalUsa;
    }

    public String getPaisCiudadania() {
        return paisCiudadania;
    }

    @Override
    public String toString() {
        return "DatosClienteDto{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", mailCliente='" + mailCliente + '\'' +
                ", nombreAsesor='" + nombreAsesor + '\'' +
                ", mailAsesor='" + mailAsesor + '\'' +
                ", residenteFiscalUsa='" + residenteFiscalUsa + '\'' +
                ", paisCiudadania='" + paisCiudadania + '\'' +
                '}';
    }
}
