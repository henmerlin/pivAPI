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
public enum MediaTma {

    Especializada(560d), MultiskillNovos(503d), Multiskill(420d);

    public Double valor;

    MediaTma(Double valor) {
        this.valor = valor;
    }
}
