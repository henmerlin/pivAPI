package model.business.indicador;

import model.business.indicador.inter.RealizadoCalcInterface;
import model.business.indicador.extra.IndicadorNome;
import model.entitiy.IndicadoresOperador;

public class IndicadorAderencia extends Indicador {

    public IndicadorAderencia(Double peso) {
        super();
        this.setNome(IndicadorNome.ADERENCIA);
        this.setPeso(peso);
    }

    public IndicadorAderencia() {
        this.setNome(IndicadorNome.ADERENCIA);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        if (op.getTotalIn() == null || op.getSched() == null) {
            throw new Exception("Indicadores não preenchidos.");

        }
        this.setRealizado(op.getTotalIn() / op.getSched());
    }

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) throws Exception {

        if (i == null) {
            throw new Exception("Sem Realizado");
        }

        if (i.getRealizado() <= 0.84d) {
            return 0d;
        } else if (i.getRealizado() <= 0.85d) {
            return 0.9d;
        } else if (i.getRealizado() <= 0.89d) {
            return 1.0d;
        } else if (i.getRealizado() <= 0.92d) {
            return 1.5d;
        } else if (i.getRealizado() <= 0.95d) {
            return 2d;
        }

        return 2d;
    }

}
