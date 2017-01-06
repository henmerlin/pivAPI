/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.regua.tma;

/**
 *
 * @author G0042204
 */
public class CalculoTmaFacade {

    private final Double realizado;

    private final Double meta;

    public CalculoTmaFacade(Double realizado, Double meta) {
        this.realizado = realizado;
        this.meta = meta;
    }

    public Double calcular() {

        if (realizado <= 120d) {
            return 0d;
        } else if (realizado <= new Double(meta - 60d) && realizado > new Double(120d)) {
            return 2d;
        } else if (realizado <= new Double(meta - 30d)) {
            return 1.5d;
        } else if (realizado <= meta) {
            return 1d;
        } else if (realizado <= new Double(meta + 30d)) {
            return 0.7d;
        } else if (realizado <= new Double(meta + 60d)) {
            return 0.3d;
        } else if (realizado > new Double(meta + 60d)) {
            return 0d;
        } else {
            return 0d;
        }
    }

}
