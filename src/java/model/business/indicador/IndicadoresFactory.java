package model.business.indicador;

import java.util.ArrayList;
import java.util.List;

import model.business.atingimento.tma.MediaTma;

import model.entitiy.IndicadoresOperador;

public class IndicadoresFactory {
   
    public List<Indicador> buscarIndicadores(IndicadoresOperador op){
        
        List<Indicador> inds = new ArrayList<>();
        
        if (op.getEquipe().equalsIgnoreCase("MULTISKILL") || 
            op.getEquipe().equalsIgnoreCase("MULTISKILL NOVOS") || 
            op.getEquipe().equalsIgnoreCase("ESPECIALIZADA")){
                
            inds.add(new IndicadorFcr(0.2d));                
            inds.add(new IndicadorTma(0.3d));   
            inds.add(new IndicadorGps(0.1d));
            inds.add(new IndicadorAderencia(0.25d));
            inds.add(new IndicadorMonitoria(0.1d));
            
            return inds;
        } else {
            return null;
        }
    }
   
}
