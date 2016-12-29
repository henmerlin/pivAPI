package model.business.indicador;

import model.business.realizado.RealizadoCalcInterface;

import model.entitiy.IndicadoresOperador;

public class IndicadorGps extends Indicador implements RealizadoCalcInterface {

    public IndicadorGps() {
        this.setNome(IndicadorNome.Gps);
    }

    public IndicadorGps(Double peso) {
        super();
        this.setNome(IndicadorNome.Gps);
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        // TODO Implement this method
    }
}
