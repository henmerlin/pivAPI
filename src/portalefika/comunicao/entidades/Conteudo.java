package portalefika.comunicao.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PE_COMUNICACAO_CONTEUDO")
public class Conteudo extends ComponentePortal {

    @Lob
    private String texto;

    @NotNull
    private Calendar dataCriacao;

    @ManyToOne
    private ConteudoCategoria categoria;

    @ManyToOne
    private ImagemPortal imagem;

    public Conteudo() {

    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public ImagemPortal getImagem() {
        return imagem;
    }

    public void setImagem(ImagemPortal imagem) {
        this.imagem = imagem;
    }

}
