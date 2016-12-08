package portalefika.comunicao.entidades;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Banner extends ComponentePortal {

    @NotNull
    private BannerLocais local;

    @NotNull
    private Date entrada;

    @NotNull
    private Date saida;
    
    private Conteudo conteudo;
    
    private Integer ordem;
    

    public Banner() {

    }

    public void setLocal(BannerLocais local) {
        this.local = local;
    }

    public BannerLocais getLocal() {
        return local;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Date getSaida() {
        return saida;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }
}
