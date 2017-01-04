/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.target;

import model.business.indicador.Indicador;
import model.business.indicador.extra.ReguaAtingimento;

/**
 *
 * @author G0042204
 */
public class CalculaTarget {

    private Indicador ind;

    public CalculaTarget(Indicador ind) {
        this.ind = ind;
    }

    public Double getTarget() throws Exception {

        if (ind == null || ind.getRealizado() == null) {
            throw new Exception("Não possui realizado.");
        }

        for (ReguaAtingimento n : ind.getRegua()) {
            if (ind.getRealizado() <= n.getRealizado()) {
                return n.getAtingimento();
            }
        }

        return 0d;
    }

    public Indicador getInd() {
        return ind;
    }

    public void setInd(Indicador ind) {
        this.ind = ind;
    }

}
