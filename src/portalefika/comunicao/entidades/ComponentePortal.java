package portalefika.comunicao.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class ComponentePortal extends Component{

    @NotEmpty
    @Column
    private String titulo;

    @NotNull
    @Column
    private Boolean ativo;

    public ComponentePortal() {
    }

    public ComponentePortal(Integer id, String titulo, Boolean ativo) {
        this.setId(id);
        this.titulo = titulo;
        this.ativo = ativo;
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
