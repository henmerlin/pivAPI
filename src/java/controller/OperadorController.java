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
import model.dal.IndicadoresOperadorDAO;
import model.entitiy.IndicadoresOperador;

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
        System.out.println(i.getLoginOperador());
        IndicadoresOperador a;
        a = (IndicadoresOperador) dao.buscaPorLoginOperador(i);

        if (a != null) {
            includeSerializer(a);
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
