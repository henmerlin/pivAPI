package portalefika.comunicao.entidades;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "PE_COMUNICACAO_IMAGEM_PORTAL")
public class ImagemPortal extends Component {

    @Lob
    private String base64;

    private Calendar dataUpload;

    public ImagemPortal() {
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public Calendar getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(Calendar dataUpload) {
        this.dataUpload = dataUpload;
    }

}
