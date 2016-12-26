/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento.topbox;

import java.util.ArrayList;
import java.util.List;
import model.business.atingimento.AtingimentoInterface;
import model.business.atingimento.NotaAtingimento;
import model.business.realizado.RealizadoCalcInterface;
import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class AtingimentoTopBox implements AtingimentoInterface {

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) {

        for (NotaAtingimento n : carregaNotaAtingimentos()) {

            if (i.getRealizado() <= n.getNota()) {
                return n.getAtingimento();
            }
        }
        return null;
    }

    public List<NotaAtingimento> carregaNotaAtingimentos() {

        List<NotaAtingimento> na = new ArrayList<>();

        na.add(new NotaAtingimento(0d, 0d));
        na.add(new NotaAtingimento(1d, 0d));
        na.add(new NotaAtingimento(1.5d, 0.2d));
        na.add(new NotaAtingimento(2d, 0.4d));
        na.add(new NotaAtingimento(2.5d, 0.6d));
        na.add(new NotaAtingimento(3d, 0.8d));
        na.add(new NotaAtingimento(3.5d, 1d));
        na.add(new NotaAtingimento(3.6d, 1.12d));
        na.add(new NotaAtingimento(3.7d, 1.25d));
        na.add(new NotaAtingimento(3.8d, 1.35d));
        na.add(new NotaAtingimento(4d, 1.5d));
        na.add(new NotaAtingimento(4.1d, 1.65d));
        na.add(new NotaAtingimento(4.2d, 1.75d));
        na.add(new NotaAtingimento(4.3d, 1.85d));
        na.add(new NotaAtingimento(4.5d, 2d));

        return na;
    }

}
