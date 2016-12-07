package portalefika.comunicao.entidades;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PE_CONTEUDO")
public class Conteudo extends ComponenteComImagem {

    @Lob
    private String texto;

    public Conteudo() {

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
