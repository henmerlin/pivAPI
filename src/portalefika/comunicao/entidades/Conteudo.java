package portalefika.comunicao.entidades;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PE_CONTEUDO")
public class Conteudo extends ComponentePortal {

    @Lob
    private String texto;
    
    private Notificacao notificacao;

    public Conteudo() {

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }
}
