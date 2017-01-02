package model.business.indicador;

import model.business.indicador.inter.AtingimentoInterface;
import model.business.indicador.inter.RealizadoCalcInterface;
import model.business.indicador.extra.IndicadorNome;

/**
 *
 * @author G0042204
 */
public abstract class Indicador implements RealizadoCalcInterface, AtingimentoInterface {

    private Double realizado;

    private Double meta;

    private Double peso;

    private Double atingimento;

    private Double pontos;

    private IndicadorNome nome;

    public Double getPontos() {
        this.pontos = this.atingimento * this.peso;
        return this.pontos;
    }

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

    public IndicadorNome getNome() {
        return nome;
    }

    public void setNome(IndicadorNome nome) {
        this.nome = nome;
    }

    @Override
    public void calcularRealizado(Double d) {
        this.realizado = d;
    }
}
