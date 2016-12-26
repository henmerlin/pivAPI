package model.business.indicador;

import model.business.realizado.RealizadoCalcInterface;

import model.entitiy.IndicadoresOperador;

public class IndicadorTma extends Indicador implements RealizadoCalcInterface {
    
    public IndicadorTma(Double peso) {
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        // TODO Implement this method
    }
}
