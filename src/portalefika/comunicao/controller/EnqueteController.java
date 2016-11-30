/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import portalefika.comunicao.dal.EnqueteDAO;
import portalefika.comunicao.entidades.Enquete;
import portalefika.controller.AbstractController;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class EnqueteController extends AbstractController {
    
    @Inject
    private EnqueteDAO enqueteDAO;

    public EnqueteController() {
    }
    
    public void create() {
        
        
        
    }
    
    @Post
    @Consumes("application/json")
    public void cadastrar(Enquete enquete) {
        
        try {
            
            this.enqueteDAO.cadastrar(enquete);
            
        } catch (Exception e) {
        }
        
    }
    
    public void listar() {
        
        
        
    }
    
}
