/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.business.atingimento.AtingimentoPivFactory;
import model.business.realizado.RealizadoCalcInterface;

import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class CalculoPiv {

    private final IndicadoresOperador op;

    private final List<RealizadoCalcInterface> indicadores;

    private final AtingimentoPivFactory factory;

    private Double atingimentoPiv;

    public CalculoPiv(IndicadoresOperador op, List<RealizadoCalcInterface> indicadores) {
        this.op = op;
        this.indicadores = indicadores;
        this.factory = new AtingimentoPivFactory();
        this.atingimentoPiv = 0d;
    }

    public void calcular() {

        for (RealizadoCalcInterface indicador : indicadores) {
            try {
                indicador.calcularRealizado(op);
                this.atingimentoPiv += factory.getAtingimento(indicador).calcularAtingimento(indicador, op);
            } catch (Exception ex) {
                Logger.getLogger(CalculoPiv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println(atingimentoPiv);

    }

}
