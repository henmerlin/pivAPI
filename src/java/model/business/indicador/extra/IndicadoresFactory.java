package model.business.indicador.extra;

import java.util.ArrayList;
import java.util.List;
import model.business.indicador.Indicador;
import model.business.indicador.IndicadorAderencia;
import model.business.indicador.IndicadorFcr;
import model.business.indicador.IndicadorGps;
import model.business.indicador.IndicadorMonitoria;
import model.business.indicador.IndicadorTma;

import model.entitiy.IndicadoresOperador;

public final class IndicadoresFactory {

    /**
     * Pesos do PIV
     *
     * @param op
     * @return
     */
    public static List<Indicador> getIndicadores(IndicadoresOperador op) {

        List<Indicador> inds = new ArrayList<>();

        inds.add(new IndicadorFcr(0.3d));
        inds.add(new IndicadorTma(0.25d));
        inds.add(new IndicadorMonitoria(0.20d));
        inds.add(new IndicadorAderencia(0.25d));

        return inds;
    }

}
