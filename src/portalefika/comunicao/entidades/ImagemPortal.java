package portalefika.comunicao.entidades;

import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PE_COMUNICACAO_IMAGEM_PORTAL")
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
