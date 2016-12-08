package portalefika.comunicao.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PE_COMUNICACAO_CONTEUDO")
public class Conteudo extends ComponentePortal {

    @Lob
    private String texto;
    
    @NotNull
    @ManyToOne
    private Notificacao notificacao;
    
    @NotNull
    private TipoConteudo tipo;
    
    @NotEmpty
    private Calendar dataCriacao; 
    
    @NotNull
    @ManyToOne
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
