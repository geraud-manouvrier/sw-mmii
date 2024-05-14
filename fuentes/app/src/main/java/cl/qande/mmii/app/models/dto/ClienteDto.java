package cl.qande.mmii.app.models.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * DTO for {@link cl.qande.mmii.app.models.db.sura.entity.Cliente}
 */
public class ClienteDto implements Serializable {
    @Size(max = 100)
    private String id;
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    @NotNull
    @Size(max = 100)
    private String nombre;
    @NotNull
    @Size(max = 100)
    private String codPaisResidencia;
    @NotNull
    @Size(max = 100)
    private String mail;
    @NotNull
    @Size(max = 100)
    private String asesorPrincipal;
    @NotNull
    @Size(max = 100)
    private String asesorSecundario;
    @NotNull
    @Size(max = 100)
    private String mailAsesorPrincipal;
    @NotNull
    @Size(max = 100)
    private String mailAsesorSecundario;
    private Integer codPaisAtencion;
    @Size(max = 100)
    private String residenteFiscalUsa;

    public ClienteDto() {
    }

    public ClienteDto(String id, Date fechaNacimiento, String nombre, String codPaisResidencia, String mail, String asesorPrincipal, String asesorSecundario, String mailAsesorPrincipal, String mailAsesorSecundario, Integer codPaisAtencion, String residenteFiscalUsa) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.codPaisResidencia = codPaisResidencia;
        this.mail = mail;
        this.asesorPrincipal = asesorPrincipal;
        this.asesorSecundario = asesorSecundario;
        this.mailAsesorPrincipal = mailAsesorPrincipal;
        this.mailAsesorSecundario = mailAsesorSecundario;
        this.codPaisAtencion = codPaisAtencion;
        this.residenteFiscalUsa = residenteFiscalUsa;
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

    public Integer getCodPaisAtencion() {
        return codPaisAtencion;
    }

    public void setCodPaisAtencion(Integer codPaisAtencion) {
        this.codPaisAtencion = codPaisAtencion;
    }

    public String getResidenteFiscalUsa() {
        return residenteFiscalUsa;
    }

    public void setResidenteFiscalUsa(String residenteFiscalUsa) {
        this.residenteFiscalUsa = residenteFiscalUsa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto entity = (ClienteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fechaNacimiento, entity.fechaNacimiento) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.codPaisResidencia, entity.codPaisResidencia) &&
                Objects.equals(this.mail, entity.mail) &&
                Objects.equals(this.asesorPrincipal, entity.asesorPrincipal) &&
                Objects.equals(this.asesorSecundario, entity.asesorSecundario) &&
                Objects.equals(this.mailAsesorPrincipal, entity.mailAsesorPrincipal) &&
                Objects.equals(this.mailAsesorSecundario, entity.mailAsesorSecundario) &&
                Objects.equals(this.codPaisAtencion, entity.codPaisAtencion) &&
                Objects.equals(this.residenteFiscalUsa, entity.residenteFiscalUsa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaNacimiento, nombre, codPaisResidencia, mail, asesorPrincipal, asesorSecundario, mailAsesorPrincipal, mailAsesorSecundario, codPaisAtencion, residenteFiscalUsa);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fechaNacimiento = " + fechaNacimiento + ", " +
                "nombre = " + nombre + ", " +
                "codPaisResidencia = " + codPaisResidencia + ", " +
                "mail = " + mail + ", " +
                "asesorPrincipal = " + asesorPrincipal + ", " +
                "asesorSecundario = " + asesorSecundario + ", " +
                "mailAsesorPrincipal = " + mailAsesorPrincipal + ", " +
                "mailAsesorSecundario = " + mailAsesorSecundario + ", " +
                "codPaisAtencion = " + codPaisAtencion + ", " +
                "residenteFiscalUsa = " + residenteFiscalUsa + ")";
    }
}