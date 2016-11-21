package model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Banner extends ComponenteComImagem {

    @NotNull
    private BannerLocais local;

    @NotNull
    private Date entrada;

    @NotNull
    private Date saida;

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
}
