/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.regua;

import java.util.ArrayList;
import java.util.List;
import model.business.equipe.Equipe;
import model.business.indicador.Indicador;
import model.business.indicador.extra.ReguaAtingimento;

/**
 *
 * @author G0042204
 */
public class ReguaIndicadorTmaFactory extends ReguaIndicadorAbstractFactory implements ReguaMaker {

    public ReguaIndicadorTmaFactory(Indicador ind, Equipe eqp) {
        super(ind, eqp);
    }

    @Override
    public List<ReguaAtingimento> getRegua() {

        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(120d, 0d));
        r.add(new ReguaAtingimento(eqp.getTma() - 60d, 2d));
        r.add(new ReguaAtingimento(eqp.getTma() - 30d, 1.5d));
        r.add(new ReguaAtingimento(eqp.getTma(), 1d));
        r.add(new ReguaAtingimento(eqp.getTma() + 30d, 0.7d));
        r.add(new ReguaAtingimento(eqp.getTma() + 60d, 0.3d));
        r.add(new ReguaAtingimento(9999d, 0d));

        return r;
    }
}
