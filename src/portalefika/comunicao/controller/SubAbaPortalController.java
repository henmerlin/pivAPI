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
import portalefika.comunicao.dal.SubAbaPortalDAO;
import portalefika.comunicao.entidades.ComponentePortal;
import portalefika.comunicao.entidades.SubAbaPortal;
import portalefika.controller.AbstractController;

@Controller
@RequestScoped
public class SubAbaPortalController extends AbstractController {

    @Inject
    private SubAbaPortalDAO saDao;

    public SubAbaPortalController() {

    }

    @Get
    @Path("/comunicacao/subAba/{a.id}")
    public void visualiza(SubAbaPortal a) {
        SubAbaPortal a1 = (SubAbaPortal) saDao.buscarPorId(a);

        if (a1 != null) {
            result.use(Results.json()).from(a1).serialize();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/comunicacao/subAba/")
    public void adiciona(SubAbaPortal subAbaPortal) {
        subAbaPortal.setAtivo(false);
        saDao.cadastrar(subAbaPortal);
    }

    @Get
    @Path("/comunicacao/subAba/")
    public void lista() {

        List<ComponentePortal> l = saDao.listar(new SubAbaPortal());

        if (l != null) {
            result.use(Results.json()).from(l).serialize();
        }
    }

    @Consumes("application/json")
    @Path("/comunicacao/subAba/delete")
    @Post
    public void remove(SubAbaPortal a) {
        saDao.excluir(a);
    }

    @Consumes("application/json")
    @Path("/comunicacao/subAba/update")
    @Post
    public void atualiza(SubAbaPortal subAbaPortal) {
        saDao.editar(subAbaPortal);
    }

}
