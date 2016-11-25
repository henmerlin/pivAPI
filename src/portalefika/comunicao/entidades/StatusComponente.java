package portalefika.comunicao.entidades;

public enum StatusComponente {
    
    Ativo(1), Inativo(2);

    int id;
    
    StatusComponente(Integer i) {
        this.id = i;
    }
    
}
