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
import portalefika.autenticacao.annotation.Admin;
import portalefika.comunicao.dal.AbaPortalDAO;
import portalefika.comunicao.dal.exception.PersistenciaException;
import portalefika.comunicao.entidades.Component;
import portalefika.comunicao.entidades.Conteudo;
import portalefika.controller.AbstractController;

@Controller
@RequestScoped
public class ConteudoController extends AbstractController {

    @Inject
    private AbaPortalDAO dao;

    public ConteudoController() {

    }

    @Admin
    public void create() {
    }

    @Get
    @Path("/comunicacao/conteudo/{a.id}")
    public void visualiza(Conteudo a) {
        Conteudo a1 = (Conteudo) dao.buscarPorId(a);

        if (a1 != null) {
            includeSerializer(a1);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/comunicacao/conteudo/cadastrar")
    public void adiciona(Conteudo c) {
        try {
            Calendar calendar = Calendar.getInstance();
            c.setDataCriacao(calendar);
            dao.cadastrar(c);
            includeSerializer(c);
        } catch (PersistenciaException e) {
            result.use(Results.json()).from(e).serialize();
        }
    }

    @Get
    @Path("/comunicacao/conteudo/lista")
    public void lista() {

        List<Component> l = dao.listar(new Conteudo());

        if (l != null) {
            includeSerializer(l);
        }
    }

    @Consumes("application/json")
    @Path("/comunicacao/conteudo/excluir")
    @Post
    public void remove(Conteudo a) {
        try {
            this.dao.excluir(a);
            this.result.use(Results.json()).from(a).serialize();
        } catch (PersistenciaException e) {
            result.use(Results.json()).from(e).serialize();
        }
    }

    @Consumes("application/json")
    @Path("/comunicacao/conteudo/modificar")
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
        result.use(Results.json()).from(a).include("categoria").include("imagem").serialize();
    }

    public void exibir() {

    }

    public void uploader() {

    }

}
