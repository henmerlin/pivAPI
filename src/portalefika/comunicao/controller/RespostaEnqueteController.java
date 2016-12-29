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
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import portalefika.autenticacao.controller.SessionUsuarioEfika;
import portalefika.comunicao.dal.EnqueteDAO;
import portalefika.comunicao.dal.RespostaEnqueteDAO;
import portalefika.comunicao.entidades.Enquete;
import portalefika.comunicao.entidades.RespostaEnquete;
import portalefika.controller.AbstractController;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class RespostaEnqueteController extends AbstractController {

    @Inject
    private SessionUsuarioEfika session;

    @Inject
    private RespostaEnqueteDAO respostaEnqueteDAO;

    @Inject
    private EnqueteDAO enqueteDAO;

    @Post
    @Consumes("application/json")
    @Path("/comunicacao/respostaEnquete/cadastrar")
    public void cadastrar(List<RespostaEnquete> respostaEnquetes) {
        try {
            for (RespostaEnquete respostaEnquete : respostaEnquetes) {
                respostaEnquete.setUsuario(this.session.getUsuario().getLogin());
                this.respostaEnqueteDAO.cadastrar(respostaEnquete);
            }
            this.result.use(Results.json()).from(respostaEnquetes).serialize();
        } catch (Exception e) {
            this.result.use(Results.json()).from(e).serialize();
        }
    }

    public void vevoto() {

    }

    @Get
    @Path("/comunicacao/respostaEnquete/listar")
    public void buscaEnqVoto() {
        try {
            List<RespostaEnquete> l = this.respostaEnqueteDAO.listarEnqEsp(this.session.getUsuario().getLogin());
            List<Enquete> le = new ArrayList<>();
            for (RespostaEnquete respostaEnquete : l) {
                le.add(respostaEnquete.getPergunta().getEnquete());
            }
            List<Enquete> ler = this.enqueteDAO.listarEnqEsp(le);
            this.result.use(Results.json()).from(ler).serialize();
        } catch (Exception e) {
            this.result.use(Results.json()).from(e).serialize();
        }
    }

}
