package portalefika.comunicao.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PE_COMUNICACAO_CONTEUDO")
public class Conteudo extends ComponentePortal {

    @Lob
    private String texto;
    
    private Notificacao notificacao;
    
    private TipoConteudo tipo;
    
    private Calendar dataCriacao; 
    
    private ConteudoCategoria categoria;

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

    public void setTipo(TipoConteudo tipo) {
        this.tipo = tipo;
    }

    public TipoConteudo getTipo() {
        return tipo;
    }

    public void setCategoria(ConteudoCategoria categoria) {
        this.categoria = categoria;
    }

    public ConteudoCategoria getCategoria() {
        return categoria;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }
}
