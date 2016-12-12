package portalefika.comunicao.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.view.Results;
import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import portalefika.comunicao.dal.AbaPortalDAO;
import portalefika.comunicao.dal.exception.PersistenciaException;
import portalefika.comunicao.entidades.Component;
import portalefika.comunicao.entidades.Conteudo;
import portalefika.comunicao.entidades.ImagemPortal;
import portalefika.controller.AbstractController;

@Controller
@RequestScoped
public class ImagemPortalController extends AbstractController {

    @Inject
    private AbaPortalDAO dao;

    public ImagemPortalController() {

    }

    public void create() {

    }

    @Get
    @Path("/comunicacao/imagemPortal/{a.id}")
    public void visualiza(ImagemPortal a) {
        ImagemPortal a1 = (ImagemPortal) dao.buscarPorId(a);

        if (a1 != null) {
            includeSerializer(a1);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/comunicacao/imagemPortal/cadastrar")
    public void adiciona(ImagemPortal c) {
        try {
            Calendar calendar = Calendar.getInstance();
            c.setDataUpload(calendar);
            dao.cadastrar(c);
            includeSerializer(c);
        } catch (PersistenciaException e) {
            result.use(Results.json()).from(e).serialize();
        }
    }

    @Get
    @Path("/comunicacao/imagemPortal/lista")
    public void lista() {

        List<Component> l = dao.listar(new Conteudo());

        if (l != null) {
            includeSerializer(l);
        }
    }

    @Consumes("application/json")
    @Path("/comunicacao/imagemPortal/excluir")
    @Post
    public void remove(Conteudo a) {
        try {
            this.dao.excluir(a);
        } catch (PersistenciaException e) {
            result.use(Results.json()).from(e).serialize();
        }
    }

    @Consumes("application/json")
    @Path("/comunicacao/imagemPortal/modificar")
    @Post
    public void atualiza(Conteudo c) {

        try {
            this.dao.editar(c);
            includeSerializer(c);
        } catch (PersistenciaException e) {
            this.result.use(Results.json()).from(e).serialize();
        }
    }

    private void includeSerializer(Object a) {
        result.use(Results.json()).from(a).serialize();
    }
}
