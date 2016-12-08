package portalefika.comunicao.entidades;

import java.sql.Blob;

public class ImagemPortal {
    
    
    private Blob imagem;
    
    private DimensaoImagemPortal dimensao;

    public ImagemPortal() {
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    public Blob getImagem() {
        return imagem;
    }

    public void setDimensao(DimensaoImagemPortal dimensao) {
        this.dimensao = dimensao;
    }

    public DimensaoImagemPortal getDimensao() {
        return dimensao;
    }
}
