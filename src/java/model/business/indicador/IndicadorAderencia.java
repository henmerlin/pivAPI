package model.business.indicador;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import model.business.realizado.RealizadoCalcInterface;

import model.entitiy.IndicadoresOperador;

public class IndicadorAderencia extends Indicador implements RealizadoCalcInterface {

    public IndicadorAderencia() {
        this.setNome(IndicadorNome.ADERENCIA);
    }

    public IndicadorAderencia(Double peso) {
        super();
        this.setNome(IndicadorNome.ADERENCIA);
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {

        if (op.getTotalIn() == null || op.getSched() == null) {
            throw new Exception("Indicadores não preenchidos.");

        }
        this.setRealizado(op.getTotalIn() / op.getSched());
    }
}
