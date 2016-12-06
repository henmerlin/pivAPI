package portalefika.comunicao.entidades;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ComponenteComImagem extends ComponentePortal {

    private String imagemUrl;

    public ComponenteComImagem() {
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
