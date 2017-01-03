package model.viewmodel;

import java.util.ArrayList;
import java.util.List;
import model.business.indicador.Indicador;
import model.business.indicador.IndicadorAderencia;
import model.business.indicador.IndicadorFcr;
import model.business.indicador.IndicadorGps;
import model.business.indicador.IndicadorMonitoria;
import model.business.indicador.IndicadorTma;
import model.entitiy.IndicadoresOperador;

public class SimuladorAtendimento {

    private IndicadoresOperador op;

    private IndicadorFcr fcr;

    private IndicadorAderencia adr;

    private IndicadorMonitoria monitoria;

    private IndicadorTma tma;

    private IndicadorGps gps;

    public SimuladorAtendimento() {
        this.fcr = new IndicadorFcr();
        this.adr = new IndicadorAderencia();
        this.monitoria = new IndicadorMonitoria();
        this.tma = new IndicadorTma();
        this.gps = new IndicadorGps();
    }

    public SimuladorAtendimento(IndicadoresOperador op) {
        this.op = op;
        this.fcr = new IndicadorFcr();
        this.adr = new IndicadorAderencia();
        this.monitoria = new IndicadorMonitoria();
        this.tma = new IndicadorTma();
        this.gps = new IndicadorGps();
    }

    public List<Indicador> getIndicadores() {

        List<Indicador> lst = new ArrayList<Indicador>();

        lst.add(fcr);
        lst.add(adr);
        lst.add(monitoria);
        lst.add(gps);
        lst.add(tma);

        return lst;
    }

    public IndicadorFcr getFcr() {
        return fcr;
    }

    public void setFcr(IndicadorFcr fcr) {
        this.fcr = fcr;
    }

    public IndicadorAderencia getAdr() {
        return adr;
    }

    public void setAdr(IndicadorAderencia adr) {
        this.adr = adr;
    }

    public IndicadorMonitoria getMonitoria() {
        return monitoria;
    }

    public void setMonitoria(IndicadorMonitoria monitoria) {
        this.monitoria = monitoria;
    }

    public IndicadorTma getTma() {
        return tma;
    }

    public void setTma(IndicadorTma tma) {
        this.tma = tma;
    }

    public IndicadorGps getGps() {
        return gps;
    }

    public void setGps(IndicadorGps gps) {
        this.gps = gps;
    }

    public IndicadoresOperador getOp() {
        return op;
    }

    public void setOp(IndicadoresOperador op) {
        this.op = op;
    }

}
