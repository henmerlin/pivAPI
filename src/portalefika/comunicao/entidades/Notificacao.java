package portalefika.comunicao.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

import portalefika.autenticacao.dal.webservice.Usuario;

@Entity
@Table(name = "PE_COMUNICACAO_NOTIFICACAO")
public class Notificacao extends ComponentePortalExpiravel {
    
    private Usuario criador;

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public Usuario getCriador() {
        return criador;
    }
}
