package src.br.net.gvt.portalefika;


public abstract class ComponenteComImagem extends ComponentePortal {
    
    private String imagemUrl;


    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
