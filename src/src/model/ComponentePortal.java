package src.model;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class ComponentePortal {

    @Id
    private Integer id;

    @NotEmpty
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private StatusComponente status;


    public ComponentePortal() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setStatus(StatusComponente status) {
        this.status = status;
    }

    public StatusComponente getStatus() {
        return status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
