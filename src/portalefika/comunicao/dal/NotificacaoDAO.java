/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import portalefika.comunicao.entidades.Notificacao;

/**
 *
 * @author G0034481
 */
public class NotificacaoDAO extends ComponentePortalDAO{

    public NotificacaoDAO() {
    }
    
    public List<Notificacao> listar() {
        
        try {
            
            Query query = this.entityManager.createQuery("FROM Notificacao n");
            return query.getResultList();
            
        } catch (Exception e) {
            
            return new ArrayList<>();
            
        }
        
    }
    
}
