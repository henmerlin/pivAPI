/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.atingimento.tma;

import model.entitiy.IndicadoresOperador;

/**
 *
 * @author G0042204
 */
public class MediaTmaEquipeFactory {

    public static MediaTma getMedia(IndicadoresOperador op) {
        return MediaTma.Especializada;
    }
}
