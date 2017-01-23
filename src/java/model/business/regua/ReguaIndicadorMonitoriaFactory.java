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

        r.add(new ReguaAtingimento(0.74d, 0d));
        r.add(new ReguaAtingimento(0.75d, 0.5d));
        r.add(new ReguaAtingimento(0.76d, 0.5d));
        r.add(new ReguaAtingimento(0.77d, 0.5d));
        r.add(new ReguaAtingimento(0.78d, 0.5d));
        r.add(new ReguaAtingimento(0.79d, 0.5d));
        r.add(new ReguaAtingimento(0.80d, 0.7d));
        r.add(new ReguaAtingimento(0.81d, 0.8d));
        r.add(new ReguaAtingimento(0.82d, 0.85d));
        r.add(new ReguaAtingimento(0.83d, 0.9d));
        r.add(new ReguaAtingimento(0.84d, 0.95d));
        r.add(new ReguaAtingimento(0.85d, 1d));
        r.add(new ReguaAtingimento(0.86d, 1.1d));
        r.add(new ReguaAtingimento(0.87d, 1.2d));
        r.add(new ReguaAtingimento(0.88d, 1.3d));
        r.add(new ReguaAtingimento(0.89d, 1.4d));
        r.add(new ReguaAtingimento(0.90d, 1.5d));
        r.add(new ReguaAtingimento(0.91d, 1.6d));
        r.add(new ReguaAtingimento(0.92d, 1.7d));
        r.add(new ReguaAtingimento(0.93d, 1.8d));
        r.add(new ReguaAtingimento(0.94d, 1.9d));
        r.add(new ReguaAtingimento(0.95d, 2d));

        return r;
    }

    private List<ReguaAtingimento> getReguaCwb() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(0.79d, 0d));
        r.add(new ReguaAtingimento(0.80d, 0.5d));
        r.add(new ReguaAtingimento(0.81d, 0.5d));
        r.add(new ReguaAtingimento(0.82d, 0.5d));
        r.add(new ReguaAtingimento(0.83d, 0.5d));
        r.add(new ReguaAtingimento(0.84d, 0.5d));
        r.add(new ReguaAtingimento(0.85d, 0.7d));
        r.add(new ReguaAtingimento(0.86d, 0.8d));
        r.add(new ReguaAtingimento(0.87d, 0.85d));
        r.add(new ReguaAtingimento(0.88d, 0.9d));
        r.add(new ReguaAtingimento(0.89d, 0.95d));
        r.add(new ReguaAtingimento(0.90d, 1d));
        r.add(new ReguaAtingimento(0.91d, 1.1d));
        r.add(new ReguaAtingimento(0.92d, 1.2d));
        r.add(new ReguaAtingimento(0.93d, 1.3d));
        r.add(new ReguaAtingimento(0.94d, 1.4d));
        r.add(new ReguaAtingimento(0.95d, 1.5d));
        r.add(new ReguaAtingimento(0.96d, 1.6d));
        r.add(new ReguaAtingimento(0.97d, 1.7d));
        r.add(new ReguaAtingimento(0.98d, 1.8d));
        r.add(new ReguaAtingimento(0.99d, 1.9d));
        r.add(new ReguaAtingimento(0.100d, 2d));

        return r;
    }

}
