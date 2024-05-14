package cl.qande.mmii.app.models.db.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "parametro")
public class Parametro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "id_parametro", nullable = false, length = 100)
    private String idParametro;

    @Size(max = 100)
    @NotNull
    @Column(name = "sub_id_parametro", nullable = false, length = 100)
    private String subIdParametro;

    @Size(max = 1000)
    @NotNull
    @Column(name = "valor_parametro", nullable = false, length = 1000)
    private String valorParametro;

    @Size(max = 100)
    @NotNull
    @Column(name = "comentario", nullable = false, length = 100)
    private String comentario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(String idParametro) {
        this.idParametro = idParametro;
    }

    public String getSubIdParametro() {
        return subIdParametro;
    }

    public void setSubIdParametro(String subIdParametro) {
        this.subIdParametro = subIdParametro;
    }

    public String getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(String valorParametro) {
        this.valorParametro = valorParametro;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}