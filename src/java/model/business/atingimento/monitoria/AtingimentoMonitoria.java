/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento.monitoria;

import model.business.atingimento.NotaAtingimento;
import java.util.ArrayList;
import java.util.List;
import model.business.atingimento.AtingimentoInterface;
import model.business.indicador.RealizadoCalcInterface;
import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class AtingimentoMonitoria implements AtingimentoInterface {

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) {

        for (NotaAtingimento n : carregaNotaAtingimentos()) {
            // System.out.println("Monitoria: " + n.getNota() + " Atingimento: " + n.getAtingimento().floatValue());
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
