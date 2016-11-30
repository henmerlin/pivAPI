/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author G0034481
 */
@Entity
@Table(name = "PE_PERGUNTA_ENQUETE")
public class Pergunta extends ComponentePortal {

    public Pergunta() {
    }
    
    @NotNull
    @ManyToOne
    private Enquete enquete;
    
    @NotNull
    private Boolean tipoPergunta;

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

    public Boolean getTipoPergunta() {
        return tipoPergunta;
    }

    public void setTipoPergunta(Boolean tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }   
    
}
