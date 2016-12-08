package portalefika.comunicao.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PE_COMUNICACAO_NOTIFICACAO")
public class Notificacao extends ComponentePortalExpiravel {
    
    @NotEmpty
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
