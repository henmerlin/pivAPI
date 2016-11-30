package portalefika.comunicao.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PE_ABA")
public class AbaPortal extends ComponentePortal {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "abaPortal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubAbaPortal> subAbas;

    public AbaPortal() {
        this.subAbas = new ArrayList<>();
    }

    public AbaPortal(List<SubAbaPortal> subAbas, Integer id, String titulo, Boolean ativo) {
        super(id, titulo, ativo);
        this.subAbas = new ArrayList<>();
    }

    public void setSubAbas(List<SubAbaPortal> subAbas) {
        this.subAbas = subAbas;
    }

    public List<SubAbaPortal> getSubAbas() {
        return subAbas;
    }
}
