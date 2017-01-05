package portalefika.comunicao.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PE_COMUNICACAO_NOTIFICACAO")
public class Notificacao extends ComponentePortalExpiravel {
    
    @NotEmpty
    private String usuario;
    
    @Lob
    @NotEmpty
    private String mensagem;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Conteudo conteudo;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }    
    
}
