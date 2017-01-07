/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.simuladorpiv.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import portalefika.autenticacao.annotation.Logado;
import portalefika.controller.AbstractController;

@Controller
public class SimuladorController extends AbstractController {

    @Path("/")
    @Logado
    public void index() {

    }

}
