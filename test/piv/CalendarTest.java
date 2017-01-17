/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piv;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author G0042204
 */
public class CalendarTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Calendar agora = new GregorianCalendar();
        Calendar adm = new GregorianCalendar();
        agora.set(2017, 1, 15);
        adm.set(2017, 1, 1);
        Long dias = ((((agora.getTimeInMillis() - adm.getTimeInMillis()) / 1000) / 60) / 60) / 24;

        System.out.println(dias);

    }

}
