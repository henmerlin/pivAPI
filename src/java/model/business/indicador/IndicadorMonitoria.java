package model.business.indicador;

import model.business.indicador.inter.RealizadoCalcInterface;
import model.business.indicador.extra.IndicadorNome;
import java.util.ArrayList;
import java.util.List;
import model.business.indicador.extra.ReguaAtingimento;

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
        super();
        this.setNome(IndicadorNome.MONITORIA);
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {

    }

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) throws Exception {

        if (i == null) {
            throw new Exception("Sem Realizado");
        }

        for (ReguaAtingimento n : carregaNotaAtingimentos()) {
            if (i.getRealizado() * 100 <= n.getRealizado()) {
                return n.getAtingimento();
            }
        }
        return 0d;
    }

    public List<ReguaAtingimento> carregaNotaAtingimentos() {

        Double novePerc = 0.0909090909090909000d;
        Double cincoPerc = 0.0526315789473684000d;

        Double nota = new Double(84);
        Double atingimento = 0d;

        List<ReguaAtingimento> na = new ArrayList<>();

        na.add(new ReguaAtingimento(nota, atingimento));

        nota += 1d;
        atingimento = novePerc;

        while (nota <= 100d) {
            na.add(new ReguaAtingimento(nota, atingimento));

            if (nota == 97d) {
                nota += 1d;
            } else {
                nota += 0.5d;
            }

            if (nota > 90) {
                atingimento = cincoPerc + atingimento;
            } else {
                atingimento = novePerc + atingimento;
            }
        }
        return na;
    }

}
