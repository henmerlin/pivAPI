package model.business.indicador;

import model.business.realizado.RealizadoCalcInterface;

import model.entitiy.IndicadoresOperador;

public class IndicadorAderencia extends Indicador implements RealizadoCalcInterface {

    public IndicadorAderencia(Double peso) {
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        this.setRealizado(0.95d);
    }
}
