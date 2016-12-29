/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business;

import java.util.List;
import model.business.atingimento.AtingimentoPivFactory;
import model.business.indicador.Indicador;

import model.entitiy.IndicadoresOperador;

public class CalculoPivFacade {

    private IndicadoresOperador op;
    private List<Indicador> indicadores;
    private Double pontos;
    private Double pesos;

    public CalculoPivFacade(IndicadoresOperador op, List<Indicador> indicadores) {
        this.op = op;
        this.indicadores = indicadores;
        this.pontos = 0d;
        this.pesos = 0d;
    }

    public Double calcular() {

        indicadores.forEach((Indicador indicador) -> {
            try {
                indicador.calcularRealizado(op);
                Double a = AtingimentoPivFactory.getAtingimento(indicador).calcularAtingimento(indicador, op);
                indicador.setAtingimento(a);
                this.pontos += indicador.getPontos();
                this.pesos += indicador.getPeso();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        if (this.pesos > 1d) {
            return null;
        }

        System.out.println("Total Pontos: " + pontos);
        System.out.println("Total Pesos: " + pesos);

        return pontos;
    }

}
