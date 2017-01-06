/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.regua;

import java.util.ArrayList;
import java.util.List;
import model.business.equipe.Equipe;
import model.business.equipe.Site;
import model.business.indicador.Indicador;
import model.business.indicador.extra.ReguaAtingimento;

/**
 *
 * @author G0042204
 */
public class ReguaIndicadorMonitoriaFactory extends ReguaIndicadorAbstractFactory implements ReguaMaker {

    public ReguaIndicadorMonitoriaFactory(Indicador ind, Equipe eqp) {
        super(ind, eqp);
    }

    @Override
    public List<ReguaAtingimento> getRegua() {

        if (eqp.getSite().equals(Site.SP)) {
            return getReguaSp();
        } else {
            return getReguaCwb();
        }
    }

    private List<ReguaAtingimento> getReguaSp() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(74d, 0d));
        r.add(new ReguaAtingimento(75d, 0.5d));
        r.add(new ReguaAtingimento(76d, 0.5d));
        r.add(new ReguaAtingimento(77d, 0.5d));
        r.add(new ReguaAtingimento(78d, 0.5d));
        r.add(new ReguaAtingimento(79d, 0.5d));
        r.add(new ReguaAtingimento(80d, 0.7d));
        r.add(new ReguaAtingimento(81d, 0.8d));
        r.add(new ReguaAtingimento(82d, 0.85d));
        r.add(new ReguaAtingimento(83d, 0.9d));
        r.add(new ReguaAtingimento(84d, 0.95d));
        r.add(new ReguaAtingimento(85d, 1d));
        r.add(new ReguaAtingimento(86d, 1.1d));
        r.add(new ReguaAtingimento(87d, 1.2d));
        r.add(new ReguaAtingimento(88d, 1.3d));
        r.add(new ReguaAtingimento(89d, 1.4d));
        r.add(new ReguaAtingimento(90d, 1.5d));
        r.add(new ReguaAtingimento(91d, 1.6d));
        r.add(new ReguaAtingimento(92d, 1.7d));
        r.add(new ReguaAtingimento(93d, 1.8d));
        r.add(new ReguaAtingimento(94d, 1.9d));
        r.add(new ReguaAtingimento(95d, 2d));

        return r;
    }

    private List<ReguaAtingimento> getReguaCwb() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(79d, 0d));
        r.add(new ReguaAtingimento(80d, 0.5d));
        r.add(new ReguaAtingimento(81d, 0.5d));
        r.add(new ReguaAtingimento(82d, 0.5d));
        r.add(new ReguaAtingimento(83d, 0.5d));
        r.add(new ReguaAtingimento(84d, 0.5d));
        r.add(new ReguaAtingimento(85d, 0.7d));
        r.add(new ReguaAtingimento(86d, 0.8d));
        r.add(new ReguaAtingimento(87d, 0.85d));
        r.add(new ReguaAtingimento(88d, 0.9d));
        r.add(new ReguaAtingimento(89d, 0.95d));
        r.add(new ReguaAtingimento(90d, 1d));
        r.add(new ReguaAtingimento(91d, 1.1d));
        r.add(new ReguaAtingimento(92d, 1.2d));
        r.add(new ReguaAtingimento(93d, 1.3d));
        r.add(new ReguaAtingimento(94d, 1.4d));
        r.add(new ReguaAtingimento(95d, 1.5d));
        r.add(new ReguaAtingimento(96d, 1.6d));
        r.add(new ReguaAtingimento(97d, 1.7d));
        r.add(new ReguaAtingimento(98d, 1.8d));
        r.add(new ReguaAtingimento(99d, 1.9d));
        r.add(new ReguaAtingimento(100d, 2d));

        return r;
    }

}
