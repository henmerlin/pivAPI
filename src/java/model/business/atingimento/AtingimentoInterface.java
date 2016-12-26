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
public interface AtingimentoInterface {

    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op);

}
