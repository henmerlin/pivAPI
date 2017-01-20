package model.business.indicador;

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
        this.setDataAtualizacao(op.getDataAdr());
        this.setRealizado(op.getTotalIn() / op.getSched());
    }
}
