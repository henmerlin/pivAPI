package portalefika.comunicao.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "PE_ABA")
public class AbaPortal extends ComponentePortal {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "abaPortal", cascade = CascadeType.REFRESH)
    private List<SubAbaPortal> subAbas;

    public void setSubAbas(List<SubAbaPortal> subAbas) {
        this.subAbas = subAbas;
    }

    @XmlTransient
    public List<SubAbaPortal> getSubAbas() {
        return subAbas;
    }
}
