package portalefika.comunicao.entidades;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PE_COMUNICACAO_CATEGORIA_CONTEUDO")
public class ConteudoCategoria extends ComponentePortal {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Conteudo> conteudos;

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }
}
