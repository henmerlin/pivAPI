/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.piv.strategy;

import model.business.equipe.Equipe;
import model.business.indicador.Indicador;
import model.business.indicador.extra.AtingimentoPiv;
import model.business.piv.CalcPivStrategyInt;
import model.business.piv.CalculoPivFacade;
import model.business.regua.ReguaFactory;

/**
 *
 * @author G0042204
 */
public class CalculoAutomatico implements CalcPivStrategyInt {

    @Override
    public void calcular(CalculoPivFacade piv) {
        for (Indicador indicador : piv.getIndicadores()) {

            // Incrementa
            piv.setPesos(piv.getPesos() + indicador.getPeso());

            try {
                indicador.calcularRealizado(piv.getOp());
            } catch (Exception e) {
                indicador.setRealizado(0d);
            }

            try {

                // Regua Atingimento
                ReguaFactory factory = new ReguaFactory(Equipe.buscarPorNome(piv.getOp().getEquipe()), indicador);
                indicador.setRegua(factory.getRegua());
                // Atingimento
                Double a = indicador.calcularAtingimento(indicador, piv.getOp());
                indicador.setAtingimento(a);
                // Meta
                indicador.obterMeta();

                // Incrementa
                piv.setPontos(piv.getPontos() + indicador.getPontos());

            } catch (Exception e) {
                System.out.println(e.getCause());
            }
        }

        // Faltas
        piv.abateAbsAtingimentoPiv(piv.getOp().getFaltas());
        piv.setTarget(AtingimentoPiv.calcularTarget(piv.getPontos()));

    }

}
