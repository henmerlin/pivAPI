/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.viewmodel;

import model.business.indicador.IndicadorAderencia;

/**
 *
 * @author G0042204
 */
public abstract class SimuladorAbstract {

    private IndicadorAderencia adr;

    public abstract Double calcularPiv();

}
