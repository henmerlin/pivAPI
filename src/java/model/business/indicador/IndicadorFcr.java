package model.business.indicador;

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

        Double percent = 1 - (op.getRechamadasFCR() / new Double(op.getChamadasFCR()));
        this.setRealizado(percent);
        this.setDataAtualizacao(op.getDataFcr());
    }

}
