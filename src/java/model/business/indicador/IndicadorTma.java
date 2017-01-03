package model.business.indicador;

import model.business.indicador.inter.RealizadoCalcInterface;
import model.business.indicador.extra.IndicadorNome;
import model.business.indicador.extra.MediaTma;
import model.business.indicador.extra.MediaTmaEquipeFactory;
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
    }

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) throws Exception {

        if (i == null) {
            throw new Exception("Sem Realizado");
        }

        MediaTma m = MediaTmaEquipeFactory.getMedia(op);

        if (i.getRealizado() <= 120) {
            return 0d;
        } else if (i.getRealizado() <= m.valor - 60 && i.getRealizado() > 120) {
            return 2d;
        } else if (i.getRealizado() <= (m.valor - 30)) {
            return 1.5d;
        } else if (i.getRealizado() <= m.valor) {
            return 1d;
        } else if (i.getRealizado() <= m.valor + 30d) {
            return 0.7d;
        } else if (i.getRealizado() <= m.valor + 60d) {
            return 0.3d;
        } else if (i.getRealizado() > m.valor + 60d) {
            return 0d;
        } else {
            return 0d;
        }
    }
}
