/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.indicador.extra;

import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class MediaTmaEquipeFactory {

    public static MediaTma getMedia(IndicadoresOperador op) {

        if (op.getEquipe().equalsIgnoreCase("MULTISKILL")) {
            return MediaTma.Multiskill;
        } else if (op.getEquipe().equalsIgnoreCase("MULTISKILL_NOVOS")) {
            return MediaTma.MultiskillNovos;
        } else if (op.getEquipe().equalsIgnoreCase("ESPECIALIZADA")) {
            return MediaTma.Especializada;
        } else {
            return MediaTma.Multiskill;
        }
    }

}
