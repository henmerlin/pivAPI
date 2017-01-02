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

    public static List<Indicador> buscarIndicadores(IndicadoresOperador op) {

        List<Indicador> inds = new ArrayList<>();

        if (op.getEquipe().equalsIgnoreCase("MULTISKILL")
                || op.getEquipe().equalsIgnoreCase("MULTISKILL NOVOS")
                || op.getEquipe().equalsIgnoreCase("ESPECIALIZADA")) {

            inds.add(new IndicadorFcr(0.2d));
            inds.add(new IndicadorTma(0.3d));
            inds.add(new IndicadorGps(0.1d));
            inds.add(new IndicadorMonitoria(0.15d));

        }

        inds.add(new IndicadorAderencia(0.25d));

        return inds;
    }

}
