package portalefika.comunicao.entidades;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class ComponentePortal {

    @Id
    private Integer id;

    @NotEmpty
    private String titulo;

    @NotNull
    private Boolean ativo = true;


    public ComponentePortal() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}


