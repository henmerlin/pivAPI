/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento.tma;

import model.business.atingimento.AtingimentoInterface;
import model.business.realizado.RealizadoCalcInterface;
import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class AtingimentoTma implements AtingimentoInterface {

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) {

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
