/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.view.Results;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.business.CalculoPivFacade;
import model.business.indicador.extra.IndicadoresFactory;
import model.dal.IndicadoresOperadorDAO;
import model.entitiy.IndicadoresOperador;
import model.viewmodel.SimuladorAtendimento;

@Controller
@RequestScoped
public class OperadorController extends AbstractController {

    @Inject
    private IndicadoresOperadorDAO dao;

    public OperadorController() {
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
            CalculoPivFacade piv = new CalculoPivFacade(a, IndicadoresFactory.buscarIndicadores(a));
            piv.calcular();
            result.use(Results.json()).from(piv).recursive().serialize();
        } catch (Exception e) {
            result.use(Results.json()).from(e).serialize();
        }

    }

    @Get
    @Path("/operador/simulador/change/{s}")
    public void simuladorChange(SimuladorAtendimento s) {

        try {
            IndicadoresOperador a;
            a = (IndicadoresOperador) dao.buscaPorLoginOperador(s.getOp());
            CalculoPivFacade piv = new CalculoPivFacade(a, IndicadoresFactory.buscarIndicadores(a));
            piv.calcularComRealizado();
            result.use(Results.json()).from(piv).recursive().serialize();
        } catch (Exception e) {
            result.use(Results.json()).from(e).serialize();
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
