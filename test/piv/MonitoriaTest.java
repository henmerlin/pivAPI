/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.business.atingimento.NotaAtingimento;

/**
 *
 * @author G0042204
 */
public class MonitoriaTest {

    public static void main(String[] args) {

        Double novePerc = new Double(0.0909090909090909000d);
        Double cincoPerc = new Double(0.0526315789473684000d);

        Double nota = new Double(84);
        Double monitoria = 0d;

        List<NotaAtingimento> na = new ArrayList<NotaAtingimento>();

        na.add(new NotaAtingimento(nota, monitoria));

        nota += 1d;
        monitoria = novePerc;

        while (nota <= 100d) {
            na.add(new NotaAtingimento(nota, monitoria));

            if (nota == 97d) {
                nota += 1d;
            } else {
                nota += 0.5d;
            }

            if (nota > 90) {
                monitoria = new Double(cincoPerc + monitoria);
            } else {
                monitoria = new Double(novePerc + monitoria);
            }
        }

        for (NotaAtingimento n : na) {
            System.out.println("Monitoria: " + n.getNota() + " Atingimento: " + n.getAtingimento().floatValue());
        }

    }
}
