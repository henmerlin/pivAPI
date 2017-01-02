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
public class NotaAtingimento {

    private Double nota;

    private Double atingimento;

    public NotaAtingimento() {
    }

    public NotaAtingimento(Double nota, Double atingimento) {
        this.nota = nota;
        this.atingimento = atingimento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Double getAtingimento() {
        return atingimento;
    }

    public void setAtingimento(Double atingimento) {
        this.atingimento = atingimento;
    }

}
