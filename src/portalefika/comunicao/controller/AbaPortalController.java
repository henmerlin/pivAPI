/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.view.Results;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import portalefika.comunicao.dal.AbaPortalDAO;
import portalefika.comunicao.entidades.AbaPortal;
import portalefika.comunicao.entidades.ComponentePortal;
import portalefika.controller.AbstractController;

@Controller
@RequestScoped
public class AbaPortalController extends AbstractController {

    @Inject
    private AbaPortalDAO abaDao;

    public AbaPortalController() {

    }

    @Get
    @Path("/comunicacao/aba/{a.id}")
    public void visualiza(AbaPortal a) {
        AbaPortal a1 = (AbaPortal) abaDao.buscarPorId(a);
        result.use(Results.json()).from(a1).serialize();
    }

    @Post("/comunicacao/aba/")
    @Consumes("application/json")
    public void adiciona(AbaPortal a) {
    }

    @Path("/comunicacao/aba/")
    public void lista() {

        List<ComponentePortal> l = abaDao.listar(AbaPortal.class);

        if (l != null) {
            result.use(Results.json()).from(l).serialize();
        }
    }

    @Delete("/comunicacao/aba/{a.id}")
    public void remove(AbaPortal a) {
    }

    @Put("/comunicacao/aba/{a.id}")
    @Consumes("application/json")
    public void atualiza(AbaPortal a) {
    }

}
