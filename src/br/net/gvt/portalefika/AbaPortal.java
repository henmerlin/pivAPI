package src.br.net.gvt.portalefika;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PE_ABA")
public class AbaPortal extends ComponentePortal {
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="abaPortal", cascade=CascadeType.REFRESH)
    private List<SubAbaPortal> subAbas;

    public void setSubAbas(List<SubAbaPortal> subAbas) {
        this.subAbas = subAbas;
    }

    public List<SubAbaPortal> getSubAbas() {
        return subAbas;
    }
}
