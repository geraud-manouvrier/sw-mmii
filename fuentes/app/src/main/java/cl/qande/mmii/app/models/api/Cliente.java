package cl.qande.mmii.app.models.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Cliente {
    private String id;
    @JsonProperty("fecha-nacimiento")
    private String fechaNacimiento;
    private String nombre;
    @JsonProperty("pais-residencia")
    private String paisResidencia;
    private String mail;
    @JsonProperty("asesor-principal")
    private String asesorPrincipal;
    @JsonProperty("asesor-secundario")
    private String asesorSecundario;
    @JsonProperty("mail-asesor-principal")
    private String mailAsesorPrincipal;
    @JsonProperty("mail-asesor-secundario")
    private String mailAsesorSecundario;
    private List<Contrato> contratos;

    @JsonProperty("cod-pais-atencion")
    private Integer codPaisAtencion;
    @JsonProperty("residente-fiscal-usa")
    private String residenteFiscalUsa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
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

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
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
    public String toString() {
        return "Cliente{" +
                "id='" + id + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paisResidencia='" + paisResidencia + '\'' +
                ", mail='" + mail + '\'' +
                ", asesorPrincipal='" + asesorPrincipal + '\'' +
                ", asesorSecundario='" + asesorSecundario + '\'' +
                ", mailAsesorPrincipal='" + mailAsesorPrincipal + '\'' +
                ", mailAsesorSecundario='" + mailAsesorSecundario + '\'' +
                ", contratos=" + contratos +
                ", codPaisAtencion=" + codPaisAtencion +
                ", residenteFiscalUsa='" + residenteFiscalUsa + '\'' +
                '}';
    }
}
