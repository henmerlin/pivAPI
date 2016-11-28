package portalefika.comunicao.entidades;

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
