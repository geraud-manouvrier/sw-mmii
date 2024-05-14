package cl.qande.mmii.app.models.db.sura.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "base_instrumento", schema = "sura")
public class BaseInstrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "nombre_serie", nullable = false, length = 100)
    private String nombreSerie;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @Column(name = "sec_id", length = 100)
    private String secId;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "administradora", nullable = false, length = 100)
    private String administradora;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @Column(name = "ticker", length = 100)
    private String ticker;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @NotNull(message = "Debe ser valor no nulo")
    @Column(name = "isin", nullable = false, length = 100)
    private String isin;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @Column(name = "id_sub_sub_tipo_activo", length = 100)
    private String idSubSubTipoActivo;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @Column(name = "id_sub_tipo_activo", length = 100)
    private String idSubTipoActivo;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @Column(name = "id_tipo_activo", length = 100)
    private String idTipoActivo;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @Column(name = "nombre_sub_sub_tipo_activo", length = 100)
    private String nombreSubSubTipoActivo;

    @Size(max = 100, message = "Debe ser máximo largo 100")
    @Column(name = "product_type", length = 100)
    private String productType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreSerie() {
        return nombreSerie;
    }

    public void setNombreSerie(String nombreSerie) {
        this.nombreSerie = nombreSerie;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public String getAdministradora() {
        return administradora;
    }

    public void setAdministradora(String administradora) {
        this.administradora = administradora;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIdSubSubTipoActivo() {
        return idSubSubTipoActivo;
    }

    public void setIdSubSubTipoActivo(String idSubSubTipoActivo) {
        this.idSubSubTipoActivo = idSubSubTipoActivo;
    }

    public String getIdSubTipoActivo() {
        return idSubTipoActivo;
    }

    public void setIdSubTipoActivo(String idSubTipoActivo) {
        this.idSubTipoActivo = idSubTipoActivo;
    }

    public String getIdTipoActivo() {
        return idTipoActivo;
    }

    public void setIdTipoActivo(String idTipoActivo) {
        this.idTipoActivo = idTipoActivo;
    }

    public String getNombreSubSubTipoActivo() {
        return nombreSubSubTipoActivo;
    }

    public void setNombreSubSubTipoActivo(String nombreSubSubTipoActivo) {
        this.nombreSubSubTipoActivo = nombreSubSubTipoActivo;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "BaseInstrumento{" +
                "id=" + id +
                ", nombreSerie='" + nombreSerie + '\'' +
                ", secId='" + secId + '\'' +
                ", administradora='" + administradora + '\'' +
                ", ticker='" + ticker + '\'' +
                ", isin='" + isin + '\'' +
                ", idSubSubTipoActivo='" + idSubSubTipoActivo + '\'' +
                ", idSubTipoActivo='" + idSubTipoActivo + '\'' +
                ", idTipoActivo='" + idTipoActivo + '\'' +
                ", nombreSubSubTipoActivo='" + nombreSubSubTipoActivo + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }
}