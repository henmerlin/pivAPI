package portalefika.comunicao.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PE_CONTEUDO")
public class Conteudo extends ComponenteComImagem {

    @ManyToOne(fetch = FetchType.EAGER)
    private SubAbaPortal subAba;

    public Conteudo() {

    }

    public void setSubAba(SubAbaPortal subAba) {
        this.subAba = subAba;
    }

    public SubAbaPortal getSubAba() {
        return subAba;
    }
}
