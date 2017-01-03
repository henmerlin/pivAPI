/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author G0034481
 */
@Entity
@Table(name = "PE_COMUNICACAO_PERGUNTA_ENQUETE")
public class Pergunta extends ComponentePortal {

    public Pergunta() {        
        this.escolhaPerguntas = new ArrayList<>();        
    }
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pergunta", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<EscolhaPergunta> escolhaPerguntas;
    
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Enquete enquete;
    
    @NotEmpty
    private String tipoPergunta;
    
    @NotEmpty
    private String tipoCampo;

    public Enquete getEnquete() {
        return enquete;
    }

    public void setEnquete(Enquete enquete) {
        this.enquete = enquete;
    }

    public String getTipoPergunta() {
        return tipoPergunta;
    }

    public void setTipoPergunta(String tipoPergunta) {
        this.tipoPergunta = tipoPergunta;
    }   

    public List<EscolhaPergunta> getEscolhaPerguntas() {
        return escolhaPerguntas;
    }

    public void setEscolhaPerguntas(List<EscolhaPergunta> escolhaPerguntas) {
        this.escolhaPerguntas = escolhaPerguntas;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipoCampo) {
        this.tipoCampo = tipoCampo;
    }    
    
}
