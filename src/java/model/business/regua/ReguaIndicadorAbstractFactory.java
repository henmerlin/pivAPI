/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.regua;

import model.business.equipe.Equipe;
import model.business.indicador.Indicador;

/**
 *
 * @author G0042204
 */
public abstract class ReguaIndicadorAbstractFactory {

    protected Indicador ind;

    protected Equipe eqp;

    public Indicador getInd() {
        return ind;
    }

    public void setInd(Indicador ind) {
        this.ind = ind;
    }

    public Equipe getEqp() {
        return eqp;
    }

    public void setEqp(Equipe eqp) {
        this.eqp = eqp;
    }

}
