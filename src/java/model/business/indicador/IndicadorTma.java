package model.business.indicador;

import model.business.indicador.extra.IndicadorNome;
import model.entitiy.IndicadoresOperador;

public class IndicadorTma extends Indicador {

    public IndicadorTma() {
        this.setNome(IndicadorNome.TMA);
    }

    public IndicadorTma(Double peso) {
        super();
        this.setNome(IndicadorNome.TMA);
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        if (op.getChamadasAtendidas() == null || op.getTempoFalado() == null) {
            throw new Exception("Indicadores não preenchidos.");
        }
        Double segundos = (op.getTempoFalado() / op.getChamadasAtendidas()) * 86400;
        this.setRealizado(new Double(segundos.intValue()));
        this.setDataAtualizacao(op.getDataTma());
    }

}
