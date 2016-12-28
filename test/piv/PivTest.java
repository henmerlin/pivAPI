/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piv;

import model.business.CalculoPivFacade;
import model.business.indicador.IndicadoresFactory;
import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class PivTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IndicadoresOperador op = new IndicadoresOperador();

        // FCR
        op.setChamadasFCR(100);
        op.setRechamadasFCR(10);

        // TMA
        op.setChamadasAtendidas(548);
        op.setTempoFalado(2.8831815717954145909677109248673219984d);

        op.setEquipe("MULTISKILL");

        CalculoPivFacade c;
        c = new CalculoPivFacade(op, IndicadoresFactory.buscarIndicadores(op));

        c.calcular();

    }

}
