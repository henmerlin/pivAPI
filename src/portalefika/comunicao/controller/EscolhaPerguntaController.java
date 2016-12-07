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
import portalefika.comunicao.dal.EscolhaPerguntaDAO;
import portalefika.comunicao.entidades.EscolhaPergunta;
import portalefika.comunicao.entidades.Pergunta;
import portalefika.controller.AbstractController;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class EscolhaPerguntaController extends AbstractController {
    
    @Inject
    private EscolhaPerguntaDAO escolhaPerguntaDAO;

    public EscolhaPerguntaController() {        
    }
    
    public void create() {       
        
    }
    
    @Get
    @Path("/comunicacao/escolhapergunta/lista/{p.id}")
    public void visualizar(Pergunta p) {
                                
        List<EscolhaPergunta> l = this.escolhaPerguntaDAO.listarEscolhasPerguntas(p);
        
        if (l != null) {
            
            this.result.use(Results.json()).from(l).serialize();
            
        }
        
    }
    
    @Post
    @Consumes("application/json")
    @Path("/comunicacao/escolhapergunta/cadastrar")
    public void cadastrar(EscolhaPergunta escolhaPergunta) {
        
        try {
            
            this.escolhaPerguntaDAO.cadastrar(escolhaPergunta);
            this.result.use(Results.json()).from(escolhaPergunta).serialize();
            
        } catch (Exception e) {
            
            this.result.use(Results.json()).from(e).serialize();
                        
        }
        
    }
    
    @Post
    @Consumes("application/json")
    @Path("/comunicacao/escolhapergunta/modificar")
    public void modificar(EscolhaPergunta escolhaPergunta) {
        
        try {
            
            this.escolhaPerguntaDAO.modificar(escolhaPergunta);
            this.result.use(Results.json()).from(escolhaPergunta).serialize();
            
        } catch (Exception e) {
            
            this.result.use(Results.json()).from(e).serialize();
            
        }
        
    }
    
}
