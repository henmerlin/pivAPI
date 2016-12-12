package portalefika.comunicao.entidades;

import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PE_COMUNICACAO_IMAGEM_PORTAL")
public class ImagemPortal extends Component {

    private Blob base64;

    public ImagemPortal() {
    }

    public Blob getBase64() {
        return base64;
    }

    public void setBase64(Blob base64) {
        this.base64 = base64;
    }

}
