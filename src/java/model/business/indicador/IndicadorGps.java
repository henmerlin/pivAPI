package model.business.indicador;

import model.business.indicador.extra.IndicadorNome;
import model.entitiy.IndicadoresOperador;

public class IndicadorGps extends Indicador {

    public IndicadorGps() {
        this.setNome(IndicadorNome.GPS);
    }

    public IndicadorGps(Double peso) {
        this.setNome(IndicadorNome.GPS);
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        this.setRealizado(0d);
    }
}
