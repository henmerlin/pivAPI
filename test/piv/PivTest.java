/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piv;

import java.util.ArrayList;
import model.business.indicador.CalculoPiv;
import model.business.indicador.Indicador;
import model.business.indicador.IndicadorFcr;
import model.business.indicador.RealizadoCalcInterface;
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

        op.setChamadasFCR(100);
        op.setRechamadasFCR(10);

        ArrayList<RealizadoCalcInterface> indicadores = new ArrayList<RealizadoCalcInterface>();

        indicadores.add(new IndicadorFcr());

        CalculoPiv c = new CalculoPiv(op, indicadores);

        c.calcular();

    }

}
