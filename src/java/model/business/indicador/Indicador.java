package model.business.indicador;

import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public abstract class Indicador implements RealizadoCalcInterface {

    private Double realizado;

    private Double meta;

    private Double peso;

    private Double atingimento;

    public Double getAtingimento() {
        return atingimento;
    }

    public void setAtingimento(Double atingimento) {
        this.atingimento = atingimento;
    }

    public Double getRealizado() {
        return realizado;
    }

    public void setRealizado(Double realizado) {
        this.realizado = realizado;
    }

    public Double getMeta() {
        return meta;
    }

    public void setMeta(Double meta) {
        this.meta = meta;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
