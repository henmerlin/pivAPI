package portalefika.comunicao.entidades;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "PE_COMUNICACAO_BANNER")
public class Banner extends ComponentePortalExpiravel {

    @NotNull
    private BannerLocal local;
    
    private Conteudo conteudo;
        
    @NotNull
    private ImagemPortal imagem;
    
    private Calendar dataCriacao;
    

    public Banner() {

    }

    public void setLocal(BannerLocal local) {
        this.local = local;
    }

    public BannerLocal getLocal() {
        return local;
    }


    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setImagem(ImagemPortal imagem) {
        this.imagem = imagem;
    }

    public ImagemPortal getImagem() {
        return imagem;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }
}
