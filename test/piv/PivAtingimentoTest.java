/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piv;

import model.business.indicador.extra.AtingimentoPiv;
import model.business.indicador.extra.ReguaAtingimento;

/**
 *
 * @author G0042204
 */
public class PivAtingimentoTest {

    public static void main(String[] args) {

        AtingimentoPiv a = new AtingimentoPiv();

        for (ReguaAtingimento n : a.carregaNotaAtingimentos()) {
            System.out.println("Target: " + n.getRealizado() + " Atingimento: " + n.getAtingimento().floatValue() * 100);
        }

    }
}
