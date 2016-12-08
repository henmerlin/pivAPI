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
@Table(name = "PE_COMUNICACAO_ESCOLHA_PERGUNTA")
public class EscolhaPergunta extends ComponentePortal {

    public EscolhaPergunta() {
    }   
    
    @NotNull
    @ManyToOne
    private Pergunta pergunta;

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }  
    
}
