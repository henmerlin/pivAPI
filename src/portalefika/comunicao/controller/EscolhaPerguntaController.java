/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.controller;

import br.com.caelum.vraptor.Controller;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import portalefika.comunicao.dal.EscolhaPerguntaDAO;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class EscolhaPerguntaController {
    
    @Inject
    private EscolhaPerguntaDAO escolhaPerguntaDAO;

    public EscolhaPerguntaController() {
        
    }
    
    public void create() {
        
        
        
    }
    
}
