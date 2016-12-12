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
import portalefika.autenticacao.annotation.Logado;
import portalefika.comunicao.dal.AbaPortalDAO;
import portalefika.comunicao.dal.exception.PersistenciaException;
import portalefika.comunicao.entidades.ComponentePortal;
import portalefika.comunicao.entidades.Conteudo;
import portalefika.controller.AbstractController;
import portalefika.dal.ArquivoManager;

@Controller
@RequestScoped
public class ConteudoController extends AbstractController {

    @Inject
    private AbaPortalDAO dao;

    @Inject
    private ArquivoManager am;

    public ConteudoController() {

    }

    public void create() {

    }

    @Get
    @Path("/comunicacao/conteudo/{a.id}")
    public void visualiza(Conteudo a) {
        Conteudo a1 = (Conteudo) dao.buscarPorId(a);

        if (a1 != null) {
            result.use(Results.json()).from(a1).serialize();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/comunicacao/conteudo/cadastrar")
    public void adiciona(Conteudo c) {
        try {
            dao.cadastrar(c);
            result.use(Results.json()).from(c).serialize();
        } catch (PersistenciaException e) {
            result.use(Results.json()).from(e).serialize();
        }
    }

//    @Post
//    @Path("/comunicacao/conteudo/upload")
//    public void upload(Conteudo c, UploadedFile imagem) {
//
//        try {
//            c = (Conteudo) dao.buscarPorId(c);
//            //c.setImagem(am.upload(imagem));
//            dao.editar(c);
//            result.use(Results.json()).from(c).serialize();
//        } catch (PersistenciaException | UploadException e) {
//            result.use(Results.json()).from(e).serialize();
//        }
//    }
    @Get
    @Path("/comunicacao/conteudo/lista")
    public void lista() {

        List<ComponentePortal> l = dao.listar(new Conteudo());

        if (l != null) {
            result.use(Results.json()).from(l).serialize();
        }
    }

    @Consumes("application/json")
    @Path("/comunicacao/conteudo/excluir")
    @Post
    public void remove(Conteudo a) {
        try {
            this.dao.excluir(a);
        } catch (PersistenciaException e) {
            result.use(Results.json()).from(a).serialize();
        }
    }

    @Consumes("application/json")
    @Path("/comunicacao/conteudo/modificar")
    @Post
    public void atualiza(Conteudo c) {

        try {
            this.dao.editar(c);
            this.result.use(Results.json()).from(c).serialize();
        } catch (PersistenciaException e) {
            this.result.use(Results.json()).from(e).serialize();
        }
    }

    public void exibir() {

    }

    public void uploader() {

    }

}
