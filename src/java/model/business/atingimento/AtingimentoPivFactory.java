/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento;

import model.business.atingimento.fcr.AtingimentoFcr;
import model.business.atingimento.monitoria.AtingimentoMonitoria;
import model.business.indicador.IndicadorFcr;
import model.business.indicador.IndicadorMonitoria;
import model.business.indicador.RealizadoCalcInterface;

/**
 *
 * @author G0042204
 */
public class AtingimentoPivFactory {

    public AtingimentoInterface getAtingimento(RealizadoCalcInterface i) {

        if (i instanceof IndicadorFcr) {
            return new AtingimentoFcr();
        } else if (i instanceof IndicadorMonitoria) {
            return new AtingimentoMonitoria();
        } else {
            return null;
        }
    }

}
