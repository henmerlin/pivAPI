/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piv;

import model.business.CalculoPivFacade;
import model.business.equipe.Equipe;
import model.business.indicador.extra.IndicadoresFactory;
import model.entitiy.IndicadoresOperador;
import model.viewmodel.SimuladorAtendimento;

/**
 *
 * @author G0042204
 */
public class DevTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IndicadoresOperador op = new IndicadoresOperador();
        op.setEquipe("MULTISKILL_NOVOS");

        SimuladorAtendimento s = new SimuladorAtendimento(op);

        CalculoPivFacade c = new CalculoPivFacade(op, IndicadoresFactory.buscarIndicadores(op));

        s.getFcr().setRealizado(0.86d);
        s.getAdr().setRealizado(0.86d);
        s.getGps().setRealizado(0.86d);
        s.getMonitoria().setRealizado(0.86d);
        s.getTma().setRealizado(300d);

        try {
            c.calcularComRealizado(s);
            c.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
