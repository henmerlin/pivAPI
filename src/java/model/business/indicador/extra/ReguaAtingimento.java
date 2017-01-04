/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.indicador.extra;

/**
 *
 * @author G0042204
 */
public class ReguaAtingimento {

    private Double realizado;

    private Double atingimento;

    public ReguaAtingimento() {
    }

    public ReguaAtingimento(Double realizado, Double atingimento) {
        this.realizado = realizado;
        this.atingimento = atingimento;
    }

    public Double getRealizado() {
        return realizado;
    }

    public void setRealizado(Double realizado) {
        this.realizado = realizado;
    }

    public Double getAtingimento() {
        return atingimento;
    }

    public void setAtingimento(Double atingimento) {
        this.atingimento = atingimento;
    }

}
