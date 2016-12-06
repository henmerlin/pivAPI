/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.view.Results;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import portalefika.comunicao.dal.PerguntaDAO;
import portalefika.comunicao.entidades.Enquete;
import portalefika.comunicao.entidades.Pergunta;
import portalefika.controller.AbstractController;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class PerguntaController extends AbstractController {
    
    @Inject
    private PerguntaDAO perguntaDAO;

    public PerguntaController() {
    }
    
    public void create() {
        
        
    }
    
    @Get
    @Path("/comunicacao/pergunta/lista/{e.id}")
    public void visualiza(Enquete e) {
        
        List<Pergunta> l = this.perguntaDAO.listarPerguntasEnquete(e);
        
        if (l != null) {
            
            this.result.use(Results.json()).from(l).serialize();
            
        }
        
    }
    
    @Post
    @Consumes("application/json")
    @Path("/comunicacao/pergunta/cadastrar")
    public void cadastrar(Pergunta pergunta) {
        
        try {
            
            this.perguntaDAO.cadastrar(pergunta);
            this.result.use(Results.json()).from(pergunta).serialize();
            
        } catch (Exception e) {
            
            this.result.use(Results.json()).from(e).serialize();
            
        }
        
    }
    
}
