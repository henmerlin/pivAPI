/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author G0034481
 */
@Entity
@Table(name = "PE_COMUNICACAO_RESPOSTA_ENQUETE")
public class RespostaEnquete implements Serializable {

    public RespostaEnquete() {
    }  
        
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotEmpty
    private String resposta;
    
    @NotNull
    @ManyToOne
    private Pergunta pergunta;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }  
    
}
