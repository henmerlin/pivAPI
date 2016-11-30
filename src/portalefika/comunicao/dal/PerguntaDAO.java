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
import portalefika.comunicao.entidades.Enquete;
import portalefika.comunicao.entidades.Pergunta;

/**
 *
 * @author G0034481
 */
@Stateless
public class PerguntaDAO extends ComponentePortalDAO {
    
    public void cadastrar(Pergunta pergunta) throws Exception {
        
        try {
            
            super.cadastrar(pergunta);
            
        } catch (Exception e) {
            
            throw new Exception("Erro ao cadastrar Pergunta");
            
        }
        
    }
    
    public void modificar(Pergunta pergunta) throws Exception {
        
        try {
            
            super.editar(pergunta);
            
        } catch (Exception e) {
            
            throw new Exception("Erro ao modificar Pergunta");
            
        }
        
    }
    
    public List<Pergunta> listarPerguntasEnquete(Enquete enquete) {
        
        try {
            
            Query query = this.entityManager.createQuery("FROM Pergunta p WHERE p.enquete =:param1");
            query.setParameter("param1", enquete);
            return query.getResultList();
            
        } catch (Exception e) {
            
            return new ArrayList<Pergunta>();
            
        }
        
    }
    
}
