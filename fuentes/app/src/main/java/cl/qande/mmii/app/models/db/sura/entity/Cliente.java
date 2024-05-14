package cl.qande.mmii.app.models.db.sura.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cliente", schema = "sura")
public class Cliente {
    @Id
    @Size(max = 100)
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    @Size(max = 100)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "cod_pais_residencia", nullable = false, length = 100)
    private String codPaisResidencia;

    @Size(max = 100)
    @NotNull
    @Column(name = "mail", nullable = false, length = 100)
    private String mail;

    @Size(max = 100)
    @NotNull
    @Column(name = "asesor_principal", nullable = false, length = 100)
    private String asesorPrincipal;

    @Size(max = 100)
    @NotNull
    @Column(name = "asesor_secundario", nullable = false, length = 100)
    private String asesorSecundario;

    @Size(max = 100)
    @NotNull
    @Column(name = "mail_asesor_principal", nullable = false, length = 100)
    private String mailAsesorPrincipal;

    @Size(max = 100)
    @NotNull
    @Column(name = "mail_asesor_secundario", nullable = false, length = 100)
    private String mailAsesorSecundario;

    @Column(name = "cod_pais_atencion")
    private Integer codPaisAtencion;

    @Size(max = 100)
    @Column(name = "residente_fiscal_usa", length = 100)
    private String residenteFiscalUsa;

    public String getResidenteFiscalUsa() {
        return residenteFiscalUsa;
    }

    public void setResidenteFiscalUsa(String residenteFiscalUsa) {
        this.residenteFiscalUsa = residenteFiscalUsa;
    }

    public Integer getCodPaisAtencion() {
        return codPaisAtencion;
    }

    public void setCodPaisAtencion(Integer codPaisAtencion) {
        this.codPaisAtencion = codPaisAtencion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodPaisResidencia() {
        return codPaisResidencia;
    }

    public void setCodPaisResidencia(String codPaisResidencia) {
        this.codPaisResidencia = codPaisResidencia;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAsesorPrincipal() {
        return asesorPrincipal;
    }

    public void setAsesorPrincipal(String asesorPrincipal) {
        this.asesorPrincipal = asesorPrincipal;
    }

    public String getAsesorSecundario() {
        return asesorSecundario;
    }

    public void setAsesorSecundario(String asesorSecundario) {
        this.asesorSecundario = asesorSecundario;
    }

    public String getMailAsesorPrincipal() {
        return mailAsesorPrincipal;
    }

    public void setMailAsesorPrincipal(String mailAsesorPrincipal) {
        this.mailAsesorPrincipal = mailAsesorPrincipal;
    }

    public String getMailAsesorSecundario() {
        return mailAsesorSecundario;
    }

    public void setMailAsesorSecundario(String mailAsesorSecundario) {
        this.mailAsesorSecundario = mailAsesorSecundario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nombre='" + nombre + '\'' +
                ", codPaisResidencia='" + codPaisResidencia + '\'' +
                ", mail='" + mail + '\'' +
                ", asesorPrincipal='" + asesorPrincipal + '\'' +
                ", asesorSecundario='" + asesorSecundario + '\'' +
                ", mailAsesorPrincipal='" + mailAsesorPrincipal + '\'' +
                ", mailAsesorSecundario='" + mailAsesorSecundario + '\'' +
                ", codPaisAtencion=" + codPaisAtencion +
                '}';
    }
}