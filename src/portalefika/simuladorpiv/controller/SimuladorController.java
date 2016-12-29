/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.simuladorpiv.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import javax.inject.Inject;
import portalefika.autenticacao.annotation.Logado;
import portalefika.autenticacao.controller.SessionUsuarioEfika;
import portalefika.controller.AbstractController;

@Controller
public class SimuladorController extends AbstractController {

    @Inject
    private SessionUsuarioEfika session;

    @Path("/simuladorPiv/")
    @Logado
    public void index() {

    }

}
