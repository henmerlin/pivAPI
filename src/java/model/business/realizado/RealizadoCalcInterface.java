/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.realizado;

import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public interface RealizadoCalcInterface {

    public void calcularRealizado(IndicadoresOperador op) throws Exception;

    public Double getRealizado();

}
