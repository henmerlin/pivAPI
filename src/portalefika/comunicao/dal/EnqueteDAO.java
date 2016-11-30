/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import portalefika.comunicao.entidades.Enquete;

/**
 *
 * @author G0034481
 */
@Stateless
public class EnqueteDAO extends ComponentePortalDAO {
    
    public void cadastrar(Enquete enquete) throws Exception {
        
        try {
            
            super.cadastrar(enquete);
            
        } catch (Exception e) {
            
            throw new Exception("Erro ao cadastrar Enquete");
            
        }
        
    }
    
    public void modificar(Enquete enquete) throws Exception {
        
        try {
            
            super.editar(enquete);
            
        } catch (Exception e) {
            
            throw new Exception("Erro ao modificar Enquete");
            
        }
        
    }
    
    public List<Enquete> listarTodasEnquetes() {
        
        try {
            
            Query query = this.entityManager.createQuery("FROM Enquete e");
            return query.getResultList();
            
        } catch (Exception e) {
            
            return new ArrayList<Enquete>();
            
        }
        
    }
    
    public List<Enquete> listarEnquetesAtivo() {
        
        try {
            
            Date date = new Date();
            
            Query query = this.entityManager.createQuery("FROM Enquete e WHERE e.ativo =:param1 AND e.dataFim < :param2");            
            query.setParameter("param1", true);
            query.setParameter("param2", date);
            
            return query.getResultList();
            
        } catch (Exception e) {
            
            return new ArrayList<Enquete>();
            
        }
        
    }
    
}
