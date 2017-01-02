/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento;

import model.business.realizado.RealizadoCalcInterface;
import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class AtingimentoAderencia implements AtingimentoInterface {

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) {

        if (i.getRealizado() <= 0.84d) {
            return 0d;
        } else if (i.getRealizado() <= 0.85d) {
            return 0.9d;
        } else if (i.getRealizado() <= 0.89d) {
            return 1.0d;
        } else if (i.getRealizado() <= 0.92d) {
            return 1.5d;
        } else if (i.getRealizado() <= 0.95d) {
            return 2d;
        }

        return 0d;
    }
}
