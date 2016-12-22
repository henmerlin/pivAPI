/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.indicador;

import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class IndicadorMonitoria extends Indicador implements RealizadoCalcInterface {

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        this.setRealizado(100d);
        this.setPeso(0.1d);
    }

}
