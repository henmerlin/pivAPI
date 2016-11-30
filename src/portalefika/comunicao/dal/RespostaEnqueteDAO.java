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
import portalefika.comunicao.entidades.RespostaEnquete;

/**
 *
 * @author G0034481
 */
@Stateless
public class RespostaEnqueteDAO extends AbstractDAO {
    
    public void cadastrar(RespostaEnquete respostaEnquete) throws Exception {
        
        try {
            
            super.cadastrar(respostaEnquete);
            
        } catch (Exception e) {
            
            throw new Exception("Erro ao cadastrar resposta enquete.");
            
        }
        
    }
    
    public void modificar(RespostaEnquete respostaEnquete) throws Exception {
        
        try {
                       
            super.modificar(respostaEnquete);
            
        } catch (Exception e) {
            
            throw new Exception("Erro ao modificar resposta enquete.");
            
        }
        
    }    
    
    public List<RespostaEnquete> listarRespostaEnquete(Enquete enquete) {
        
        try {
            
            Query query = this.entityManager.createQuery("FROM RespostaEnquete r WHERE r.enquete =:param1");
            query.setParameter("param1", enquete);
            return query.getResultList();
            
        } catch (Exception e) {
            
            return new ArrayList<RespostaEnquete>();
            
        }
        
    }
    
    
    
}
