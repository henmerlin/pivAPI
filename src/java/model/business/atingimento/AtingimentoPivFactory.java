/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento;

import model.business.indicador.IndicadorAderencia;
import model.business.indicador.IndicadorFcr;
import model.business.indicador.IndicadorMonitoria;
import model.business.indicador.IndicadorTma;
import model.business.realizado.RealizadoCalcInterface;

/**
 *
 * @author G0042204
 */
public class AtingimentoPivFactory {

    public AtingimentoInterface getAtingimento(RealizadoCalcInterface i) throws Exception {

        if (i instanceof IndicadorFcr) {
            return new AtingimentoFcr();
        } else if (i instanceof IndicadorTma) {
            return new AtingimentoTma();
        } else if (i instanceof IndicadorAderencia) {
            return new AtingimentoAderencia();
        } else if (i instanceof IndicadorMonitoria) {
            return new AtingimentoMonitoria();
        } else {
            throw new Exception("Atingimento não implementado");
        }
    }

}
