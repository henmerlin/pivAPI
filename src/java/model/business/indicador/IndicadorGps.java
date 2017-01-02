package model.business.indicador;

import java.util.ArrayList;
import java.util.List;
import model.business.indicador.inter.RealizadoCalcInterface;
import model.business.indicador.extra.IndicadorNome;
import model.business.indicador.extra.NotaAtingimento;
import model.entitiy.IndicadoresOperador;

public class IndicadorGps extends Indicador {

    public IndicadorGps() {
        this.setNome(IndicadorNome.GPS);
    }

    public IndicadorGps(Double peso) {
        super();
        this.setNome(IndicadorNome.GPS);
        this.setPeso(peso);
    }

    @Override
    public void calcularRealizado(IndicadoresOperador op) throws Exception {
        throw new Exception("Não implementado.");
    }

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) {

        for (NotaAtingimento n : carregaNotaAtingimentos()) {
            if (i.getRealizado() * 100 <= n.getNota()) {
                return n.getAtingimento();
            }
        }
        return 0d;
    }

    public List<NotaAtingimento> carregaNotaAtingimentos() {

        Double novePerc = 0.0909090909090909000d;
        Double cincoPerc = 0.0526315789473684000d;

        Double nota = new Double(84);
        Double atingimento = 0d;

        List<NotaAtingimento> na = new ArrayList<>();

        na.add(new NotaAtingimento(nota, atingimento));

        nota += 1d;
        atingimento = novePerc;

        while (nota <= 100d) {
            na.add(new NotaAtingimento(nota, atingimento));

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
