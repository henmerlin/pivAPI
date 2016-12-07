/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.dal;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import portalefika.comunicao.entidades.EscolhaPergunta;
import portalefika.comunicao.entidades.Pergunta;

/**
 *
 * @author G0034481
 */
@Stateless
public class EscolhaPerguntaDAO extends ComponentePortalDAO {
    
    public void cadastrar(EscolhaPergunta escolhaPergunta) throws Exception {
        
        try {
            
            super.cadastrar(escolhaPergunta);
            
        } catch (Exception e) {
            
            throw new Exception("Erro ao cadastrar Escolha para a Pergunta");
            
        }
        
    }
    
    public void modificar(EscolhaPergunta escolhaPergunta) throws Exception {
        
        try {
            
            super.editar(escolhaPergunta);
            
        } catch (Exception e) {
            
            throw new Exception("Erro ao modificar Escolha para a Pergunta");
            
        }
        
    }
    
    public List<EscolhaPergunta> listarEscolhasPerguntas(Pergunta pergunta) {
        
        try {
            
            Query query = this.entityManager.createQuery("FROM EscolhaPergunta e WHERE e.pergunta.id =:param1");
            query.setParameter("param1", pergunta.getId());
            return query.getResultList();
            
        } catch (Exception e) {
            
            return new ArrayList<EscolhaPergunta>();
            
        }
        
    }
    
}
