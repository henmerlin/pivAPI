/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class AtingimentoPiv {

    public Double calcularTarget(Double atingimento) {
        for (NotaAtingimento n : carregaNotaAtingimentos()) {
            if (atingimento * 100 <= n.getNota()) {
                return n.getAtingimento();
            }
        }
        return 0d;
    }

    public List<NotaAtingimento> carregaNotaAtingimentos() {

        Double nota = 0d;
        Double atingimento = 0d;

        List<NotaAtingimento> na = new ArrayList<>();

        na.add(new NotaAtingimento(nota, atingimento));

        nota += 80d;
        atingimento += 0.075d;

        Integer i = 0;

        while (nota <= 200d) {
            na.add(new NotaAtingimento(nota, atingimento));

            nota += 1d;
            i++;
        }
        return na;
    }

}
