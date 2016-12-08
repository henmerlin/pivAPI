package portalefika.comunicao.entidades;


public enum DimensaoImagemPortal {
    
    Pequena(150, 200),
    Media(250, 500),
    Grande(500, 1200);

    Integer altura;
    Integer largura;

    DimensaoImagemPortal( Integer altura, Integer largura) {
        this.altura = altura;
        this.largura = largura;
    }
    
    
    
}
