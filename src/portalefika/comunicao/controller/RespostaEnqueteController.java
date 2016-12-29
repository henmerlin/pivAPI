/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.view.Results;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import portalefika.autenticacao.controller.SessionUsuarioEfika;
import portalefika.comunicao.dal.RespostaEnqueteDAO;
import portalefika.comunicao.entidades.RespostaEnquete;
import portalefika.controller.AbstractController;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class RespostaEnqueteController extends AbstractController {
    
    @ManagedProperty(value = "#{sessionUsuarioEfika}")
    private SessionUsuarioEfika sessionUsuarioEfika;

    @Inject
    private RespostaEnqueteDAO respostaEnqueteDAO;

    @Post
    @Consumes("application/json")
    @Path("/comunicacao/respostaEnquete/cadastrar")
    public void cadastrar(List<RespostaEnquete> respostaEnquetes) {
        try {
            for (RespostaEnquete respostaEnquete : respostaEnquetes) {
                //Adicionar matricula do usuario que está logado.
                respostaEnquete.setUsuario("G0034481");                
                this.respostaEnqueteDAO.cadastrar(respostaEnquete);
            }
            this.result.use(Results.json()).from(respostaEnquetes).serialize();
        } catch (Exception e) {
            this.result.use(Results.json()).from(e).serialize();
        }
    }
    
    public void vevoto() {
        
        
        
    }
}
