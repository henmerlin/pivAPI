package portalefika.comunicao.entidades;

import java.sql.Blob;

public class ImagemPortal extends Component {

    private Blob imagem;

    public ImagemPortal() {
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    public Blob getImagem() {
        return imagem;
    }

}
