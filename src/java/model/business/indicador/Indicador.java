package model.business.indicador;

import java.util.List;
import model.business.indicador.inter.AtingimentoInterface;
import model.business.indicador.inter.RealizadoCalcInterface;
import model.business.indicador.extra.IndicadorNome;
import model.business.indicador.extra.ReguaAtingimento;
import model.entitiy.IndicadoresOperador;

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

    private List<ReguaAtingimento> regua;

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

    @Override
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

    public List<ReguaAtingimento> getRegua() {
        return regua;
    }

    public void setRegua(List<ReguaAtingimento> regua) {
        this.regua = regua;
    }

    @Override
    public void calcularRealizado(Double d) {
        this.realizado = d;
    }

    @Override
    public Double calcularAtingimento(RealizadoCalcInterface i, IndicadoresOperador op) throws Exception {

        if (this.getRegua() == null) {
            throw new Exception("Indicador sem Regua implementada.");
        }

        for (ReguaAtingimento n : getRegua()) {
            if (i.getRealizado() <= n.getRealizado()) {
                return n.getAtingimento();
            }
        }
        return 2d;
    }

    @Override
    public Double obterMeta() throws Exception {
        for (ReguaAtingimento n : getRegua()) {
            if (n.getAtingimento() == 1d) {
                this.meta = n.getRealizado();
                return n.getRealizado();
            }
        }
        return 0d;
    }

}
