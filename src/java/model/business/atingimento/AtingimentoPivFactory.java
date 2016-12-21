/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento;

import model.business.indicador.IndicadorFcr;
import model.business.indicador.RealizadoCalcInterface;

/**
 *
 * @author G0042204
 */
public class AtingimentoPivFactory {

    public AtingimentoInterface getAtingimento(RealizadoCalcInterface i) {

        if (i instanceof IndicadorFcr) {
            return new AtingimentoFcr();
        } else {
            return null;
        }
    }

}
