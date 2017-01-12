/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Options;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.controller.HttpMethod;
import br.com.caelum.vraptor.events.VRaptorRequestStarted;
import br.com.caelum.vraptor.http.route.Router;
import br.com.caelum.vraptor.view.Results;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import model.business.piv.CalculoPivFacade;
import model.business.equipe.Equipe;
import model.business.exception.IndicadoresNaoEncontrados;
import model.business.indicador.IndicadoresFactory;
import model.dal.IndicadoresOperadorDAO;
import model.entitiy.IndicadoresOperador;
import model.viewmodel.EquipeViewModel;
import model.viewmodel.SimuladorAtendimento;

@Controller
@RequestScoped
public class OperadorController extends AbstractController {

    @Inject
    private IndicadoresOperadorDAO dao;

    @Inject
    private Router router;

    public OperadorController() {
    }

    @Options
    @Path(value = "/*")
    public void options(@Observes VRaptorRequestStarted requestInfo) {

        Set<HttpMethod> allowed = router.allowedMethodsFor(requestInfo.getRequest().getRequestedUri());
        String allowMethods = allowed.toString().replaceAll("\\[|\\]", "");

        result.use(Results.status()).header("Allow", allowMethods);
        result.use(Results.status()).header("Access-Control-Allow-Methods", allowMethods);
        result.use(Results.status()).header("Access-Control-Allow-Headers", "Content-Type, X-Requested-With, accept, Authorization, origin");
    }

    @Get
    @Path("/operador/{i.loginOperador}")
    public void visualiza(IndicadoresOperador i) {
        IndicadoresOperador a;
        a = (IndicadoresOperador) dao.buscaPorLoginOperador(i);

        if (a != null) {
            includeSerializer(a);
        }
    }

    @Get
    @Path("/operador/simulador/{loginOperador}")
    public void simulador(String loginOperador) {

        try {
            IndicadoresOperador a;
            a = (IndicadoresOperador) dao.buscaPorLoginOperador(new IndicadoresOperador(loginOperador));

            // Não encontrou indicadores
            if (a == null) {
                result.use(Results.json()).from(new IndicadoresNaoEncontrados()).serialize();
            } else {
                CalculoPivFacade piv = new CalculoPivFacade(a, IndicadoresFactory.getIndicadores(a));
                piv.calcular();
                result.use(Results.json()).from(piv).recursive().serialize();
            }
        } catch (Exception e) {
            result.use(Results.json()).from(e).serialize();
        }

    }

    @Get
    @Path("/operador/simulador/equipes/")
    public void equipes() {

        List<EquipeViewModel> lst = new ArrayList<>();

        for (Equipe eqp : Equipe.values()) {
            if (eqp.getAtivo()) {
                lst.add(new EquipeViewModel(eqp, eqp.getNome()));
            }
        }

        result.use(Results.json()).from(lst).serialize();
    }

    @Post
    @Consumes("application/json")
    @Path("/operador/simulador/change/")
    public void simuladorChange(SimuladorAtendimento s) {

        try {
            CalculoPivFacade piv = new CalculoPivFacade(s.getOp(), IndicadoresFactory.getIndicadores(s.getOp()));
            piv.calcularComRealizado(s);
            result.use(Results.json()).from(piv).recursive().serialize();
        } catch (Exception e) {
            result.use(Results.json()).from(e).recursive().serialize();
        }
    }

    /**
     * Serializa Objeto com Padrão Definido
     *
     * @param a
     */
    protected void includeSerializer(Object a) {
        result.use(Results.json()).from(a).serialize();
    }

}
