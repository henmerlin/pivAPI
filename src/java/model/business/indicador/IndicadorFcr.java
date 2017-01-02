package model.business.indicador;

import model.business.indicador.inter.RealizadoCalcInterface;
import model.business.indicador.extra.IndicadorNome;
import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class IndicadorFcr extends Indicador {

    public IndicadorFcr() {
        this.setNome(IndicadorNome.FCR);
    }

    public IndicadorFcr(Double peso) {
        super();
        this.setNome(IndicadorNome.FCR);
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        if (op.getChamadasFCR() == null || op.getRechamadasFCR() == null) {
            throw new Exception("Indicadores não preenchidos.");
        }
        Double percent = 1 - ((op.getChamadasFCR() / op.getRechamadasFCR()) / 100d);
        this.setRealizado(percent);
    }

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) {

        if (i.getRealizado() <= 0.59d) {
            return 0d;
        } else if (i.getRealizado() <= 0.60d) {
            return 0.3d;
        } else if (i.getRealizado() <= 0.61d) {
            return 0.35d;
        } else if (i.getRealizado() <= 0.62d) {
            return 0.40d;
        } else if (i.getRealizado() <= 0.63d) {
            return 0.45d;
        } else if (i.getRealizado() <= 0.64d) {
            return 0.50d;
        } else if (i.getRealizado() <= 0.65d) {
            return 0.60d;
        } else if (i.getRealizado() <= 0.66d) {
            return 0.75d;
        } else if (i.getRealizado() <= 0.67d) {
            return 0.80d;
        } else if (i.getRealizado() <= 0.68d) {
            return 0.85d;
        } else if (i.getRealizado() <= 0.69d) {
            return 0.90d;
        } else if (i.getRealizado() <= 0.70d) {
            return 1d;
        } else if (i.getRealizado() <= 0.72d) {
            return 1.12d;
        } else if (i.getRealizado() <= 0.73d) {
            return 1.25d;
        } else if (i.getRealizado() <= 0.74d) {
            return 1.35d;
        } else if (i.getRealizado() <= 0.75d) {
            return 1.50d;
        } else if (i.getRealizado() <= 0.76d) {
            return 1.65d;
        } else if (i.getRealizado() <= 0.77d) {
            return 0.3d;
        } else if (i.getRealizado() <= 0.78d) {
            return 0.3d;
        } else {
            return 2d;
        }
    }

}
