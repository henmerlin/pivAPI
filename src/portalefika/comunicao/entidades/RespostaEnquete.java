/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import portalefika.autenticacao.dal.webservice.Usuario;

/**
 *
 * @author G0034481
 */
@Entity
@Table(name = "PE_RESPOSTA_ENQUETE")
public class RespostaEnquete implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotEmpty
    private String resposta;
    
    @NotNull
    @ManyToOne
    private Pergunta pergunta;

    @NotNull
    @ManyToOne
    private Usuario usuario;
    
    @NotNull
    @ManyToOne
    private Enquete enquete;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }   
    
}
