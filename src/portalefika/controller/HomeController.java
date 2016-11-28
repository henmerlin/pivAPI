package portalefika.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import portalefika.autenticacao.annotation.Logado;

@Controller
public class HomeController extends AbstractController {

    public HomeController() {

    }

    @Path("/")
    @Logado
    public void index() {

    }

    public void restrito() {
    }

}
