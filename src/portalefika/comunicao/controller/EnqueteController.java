/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import portalefika.comunicao.dal.EnqueteDAO;
import portalefika.comunicao.dal.exception.PersistenciaException;
import portalefika.comunicao.entidades.Enquete;
import portalefika.controller.AbstractController;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class EnqueteController extends AbstractController {

    @Inject
    private EnqueteDAO enqueteDAO;

    public EnqueteController() {
    }

    public void create() {

    }

    @Get
    @Path("/comunicacao/enquete/{enquete.id}")
    public void visualiza(Enquete enquete) {
        Enquete a1 = (Enquete) this.enqueteDAO.buscarPorId(enquete);

        if (a1 != null) {
            this.result.use(Results.json()).from(a1).serialize();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/comunicacao/enquete/cadastrar")
    public void cadastrar(Enquete addEnquetes) {
        try {
            this.enqueteDAO.cadastrar(addEnquetes);
            this.result.use(Results.json()).from(addEnquetes).include("enquetes").serialize();
        } catch (PersistenciaException e) {
            this.result.use(Results.json()).from(e).serialize();
        }
    }

    @Get
    @Path("/comunicacao/enquete/listar")
    public void listar() {
        List<Enquete> l = this.enqueteDAO.listarTodasEnquetes();

        if (l != null) {
            this.result.use(Results.json()).from(l).serialize();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/comunicacao/enquete/modificar")
    public void modificar(Enquete enquete) {
        try {
            this.enqueteDAO.editar(enquete);
            this.result.use(Results.json()).from(enquete).include("enquetes").serialize();

        } catch (PersistenciaException e) {
            this.result.use(Results.json()).from(e).serialize();
        }
    }

    public void exclui(Enquete enquete) {
        try {
            this.enqueteDAO.excluir(enquete);
        } catch (PersistenciaException e) {
            result.use(Results.json()).from(e).serialize();
        }
    }

}
