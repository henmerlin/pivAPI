package model.business;

import java.util.List;
import model.business.indicador.Indicador;
import model.business.indicador.extra.AtingimentoPiv;
import model.business.indicador.extra.IndicadorNome;

import model.entitiy.IndicadoresOperador;
import model.viewmodel.SimuladorAtendimento;

public class CalculoPivFacade {

    private final IndicadoresOperador op;
    private final List<Indicador> indicadores;
    private Double pontos;
    private Double pesos;
    private Double target;

    public CalculoPivFacade(IndicadoresOperador op, List<Indicador> indicadores) {
        this.op = op;
        this.indicadores = indicadores;
        this.pontos = 0d;
        this.pesos = 0d;
        this.target = 0d;
    }

    public void calcular() {

        for (Indicador indicador : indicadores) {

            this.pesos += indicador.getPeso();

            try {
                indicador.calcularRealizado(op);
            } catch (Exception e) {
                indicador.setRealizado(0d);
            }

            try {
                Double a = indicador.calcularAtingimento(indicador, op);
                indicador.setAtingimento(a);
                this.pontos += indicador.getPontos();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        this.setTarget(AtingimentoPiv.calcularTarget(pontos));
    }

    public void calcularComRealizado(SimuladorAtendimento s) {

        for (Indicador indicador : indicadores) {

            indicador = adapter(indicador, s);

            this.pesos += indicador.getPeso();

            try {
                Double a = indicador.calcularAtingimento(indicador, op);
                indicador.setAtingimento(a);
                this.pontos += indicador.getPontos();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.setTarget(AtingimentoPiv.calcularTarget(pontos));
    }

    protected Indicador adapter(Indicador indicador, SimuladorAtendimento s) {

        if (indicador.getNome().equals(IndicadorNome.ADERENCIA)) {
            indicador.setRealizado(new Double(s.getAdr().getRealizado()));
        }

        if (indicador.getNome().equals(IndicadorNome.FCR)) {
            indicador.setRealizado(new Double(s.getFcr().getRealizado()));
        }

        if (indicador.getNome().equals(IndicadorNome.GPS)) {
            indicador.setRealizado(new Double(s.getGps().getRealizado()));
        }

        if (indicador.getNome().equals(IndicadorNome.MONITORIA)) {
            indicador.setRealizado(new Double(s.getMonitoria().getRealizado()));
        }
        if (indicador.getNome().equals(IndicadorNome.TMA)) {
            indicador.setRealizado(new Double(s.getTma().getRealizado()));
        }

        return indicador;
    }

    public Double getPesos() {
        return pesos;
    }

    public void setPesos(Double pesos) {
        this.pesos = pesos;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }
}
