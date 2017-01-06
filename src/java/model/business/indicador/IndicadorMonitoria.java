package model.business.indicador;

import model.business.indicador.extra.IndicadorNome;

import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class IndicadorMonitoria extends Indicador {

    public IndicadorMonitoria() {
        this.setNome(IndicadorNome.MONITORIA);
    }

    public IndicadorMonitoria(Double peso) {
        this.setNome(IndicadorNome.MONITORIA);
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        this.setRealizado(0d);
    }

}
