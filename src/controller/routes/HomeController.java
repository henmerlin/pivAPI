package controller.routes;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class HomeController extends AbstractCrudController {

    public HomeController() {

    }

    @Path("/")
    public void index() {

    }

    public void restrito() {
    }

}
