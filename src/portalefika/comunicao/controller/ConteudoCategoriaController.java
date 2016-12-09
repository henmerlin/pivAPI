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
import portalefika.comunicao.dal.ConteudoCategoriaDAO;
import portalefika.comunicao.entidades.ConteudoCategoria;
import portalefika.controller.AbstractController;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class ConteudoCategoriaController extends AbstractController {
    
    @Inject
    private ConteudoCategoriaDAO conteudoCategoriaDAO;

    public ConteudoCategoriaController() {
    }
    
    public void create() {
    }
    
    @Get
    @Path("/comunicacao/conteudocategoria/listar")
    public void lista() {
        
        List<ConteudoCategoria> l = this.conteudoCategoriaDAO.listar();
        
        if (l != null) {
            
            this.result.use(Results.json()).from(l).serialize();
            
        }
        
    }
    
    @Post
    @Consumes("application/json")
    @Path("/comunicacao/conteudocategoria/cadastrar")
    public void cadastrar(ConteudoCategoria conteudoCategoria) {
        
        try {
                        
            this.conteudoCategoriaDAO.cadastrar(conteudoCategoria);
            this.result.use(Results.json()).from(conteudoCategoria).serialize();
            
        } catch (Exception e) {
            
            this.result.use(Results.json()).from(e).serialize();
            
        }
        
    }
    
    @Post
    @Consumes("application/json")
    @Path("/comunicacao/conteudocategoria/modificar")
    public void modificar(ConteudoCategoria conteudoCategoria) {
        
        try {
            
            this.conteudoCategoriaDAO.editar(conteudoCategoria);
            this.result.use(Results.json()).from(conteudoCategoria).serialize();
            
        } catch (Exception e) {
            
            this.result.use(Results.json()).from(e).serialize();
            
        }
        
    }
    
    @Post
    @Consumes("application/json")
    @Path("/comunicacao/conteudocategoria/excluir")
    public void excluir(ConteudoCategoria conteudoCategoria) {
        
        try {
            
            this.conteudoCategoriaDAO.excluir(conteudoCategoria);
            this.result.use(Results.json()).from(conteudoCategoria).serialize();
            
        } catch (Exception e) {
            
            this.result.use(Results.json()).from(e).serialize();
            
        }
        
    }
    
}
