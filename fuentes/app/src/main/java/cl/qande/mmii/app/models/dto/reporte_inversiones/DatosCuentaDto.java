package cl.qande.mmii.app.models.dto.reporte_inversiones;

import cl.qande.mmii.app.models.db.rep_inv.entity.RentabilidadCalculada;
import cl.qande.mmii.app.models.dto.ContratoDto;
import cl.qande.mmii.app.models.dto.CuentaDto;
import cl.qande.mmii.app.models.dto.PerfilCuentaDto;

import java.math.BigDecimal;

public class DatosCuentaDto {
    private String custodio;
    private String accountNo;
    private String descripcionObjetivo;
    private String horizonteObjetivo;
    private String perfilInversion;
    private String portafolio;
    private String exencionResponsabilidad;
    private String tipoCuenta;
    private String beneficiarios;
    private BigDecimal advisoryFee;

    private RentabilidadCalculada rentabilidadCuenta;
    private BigDecimal tasaAnualCobro;
    private BigDecimal comisionDevengadaPeriodo;
    private BigDecimal comisionPagadaPeriodo;

    public DatosCuentaDto(ContratoDto contratoDto, CuentaDto cuentaDto, PerfilCuentaDto perfilCuentaDto, RentabilidadCalculada rentabilidadCalculada) {
        //Datos cuenta
        this.custodio               = cuentaDto.getCustodio();
        this.accountNo              = cuentaDto.getIdCuentaCustodio();
        this.descripcionObjetivo    = cuentaDto.getDescripcionObjetivo();
        this.beneficiarios          = cuentaDto.getBeneficiarios();
        this.beneficiarios = cuentaDto.getBeneficiarios();
        //Datos perfil
        this.horizonteObjetivo          = perfilCuentaDto.getHorizonteObjetivo();
        this.perfilInversion            = perfilCuentaDto.getIdPerfil();
        this.portafolio                 = perfilCuentaDto.getPortfolio();
        this.exencionResponsabilidad    = perfilCuentaDto.getExencionResponsabilidad();
        //Datos contrato
        this.tipoCuenta     = contratoDto.getTipoCuenta();
        this.advisoryFee    = contratoDto.getTarifaNegociada();

        //Otros valores
        this.rentabilidadCuenta         = rentabilidadCalculada;
        //TODO: Pendiente mapear
        this.tasaAnualCobro             = BigDecimal.valueOf(0);
        this.comisionDevengadaPeriodo   = BigDecimal.valueOf(0);
        this.comisionPagadaPeriodo      = BigDecimal.valueOf(0);

    }

    public String getCustodio() {
        return custodio;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getDescripcionObjetivo() {
        return descripcionObjetivo;
    }

    public String getHorizonteObjetivo() {
        return horizonteObjetivo;
    }

    public String getPerfilInversion() {
        return perfilInversion;
    }

    public String getPortafolio() {
        return portafolio;
    }

    public String getExencionResponsabilidad() {
        return exencionResponsabilidad;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public String getBeneficiarios() {
        return beneficiarios;
    }

    public BigDecimal getAdvisoryFee() {
        return advisoryFee;
    }

    public RentabilidadCalculada getRentabilidadCuenta() {
        return rentabilidadCuenta;
    }

    public BigDecimal getTasaAnualCobro() {
        return tasaAnualCobro;
    }

    public BigDecimal getComisionDevengadaPeriodo() {
        return comisionDevengadaPeriodo;
    }

    public BigDecimal getComisionPagadaPeriodo() {
        return comisionPagadaPeriodo;
    }

    @Override
    public String toString() {
        return "DatosCuentaDto{" +
                "custodio='" + custodio + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", descripcionObjetivo='" + descripcionObjetivo + '\'' +
                ", horizonteObjetivo='" + horizonteObjetivo + '\'' +
                ", perfilInversion='" + perfilInversion + '\'' +
                ", portafolio='" + portafolio + '\'' +
                ", exencionResponsabilidad='" + exencionResponsabilidad + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                ", beneficiarios='" + beneficiarios + '\'' +
                ", advisoryFee=" + advisoryFee +
                ", rentabilidadCuenta=" + rentabilidadCuenta +
                ", tasaAnualCobro=" + tasaAnualCobro +
                ", comisionDevengadaPeriodo=" + comisionDevengadaPeriodo +
                ", comisionPagadaPeriodo=" + comisionPagadaPeriodo +
                '}';
    }
}
