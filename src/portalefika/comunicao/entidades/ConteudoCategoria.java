package portalefika.comunicao.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PE_COMUNICACAO_CATEGORIA_CONTEUDO")
public class ConteudoCategoria {

    private List<Conteudo> categorias;

    public void setCategorias(List<Conteudo> categorias) {
        this.categorias = categorias;
    }

    public List<Conteudo> getCategorias() {
        return categorias;
    }
}
