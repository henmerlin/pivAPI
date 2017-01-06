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
public class ReguaIndicadorAderenciaFactory extends ReguaIndicadorAbstractFactory implements ReguaMaker {

    public ReguaIndicadorAderenciaFactory(Indicador ind, Equipe eqp) {
        super(ind, eqp);
    }

    @Override
    public List<ReguaAtingimento> getRegua() {

        if (eqp.getSite().equals(Site.SP)) {

            if (eqp.equals(Equipe.TRIAGEM_SP)) {
                return this.getReguaTriagemSp();
            } else {
                return this.getReguaSp();
            }

        } else {

            if (eqp.equals(Equipe.TRIAGEM)) {
                return this.getReguaTriagemCwb();
            } else {
                return this.getReguaCwb();
            }
        }
    }

    private List<ReguaAtingimento> getReguaSp() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(0.75d, 0d));
        r.add(new ReguaAtingimento(0.76d, 0.8d));
        r.add(new ReguaAtingimento(0.8d, 1d));
        r.add(new ReguaAtingimento(0.83d, 1.5d));
        r.add(new ReguaAtingimento(0.86d, 2d));

        return r;
    }

    private List<ReguaAtingimento> getReguaCwb() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(0.84d, 0d));
        r.add(new ReguaAtingimento(0.85d, 0.8d));
        r.add(new ReguaAtingimento(0.89d, 1d));
        r.add(new ReguaAtingimento(0.92d, 1.5d));
        r.add(new ReguaAtingimento(0.95d, 2d));

        return r;
    }

    private List<ReguaAtingimento> getReguaTriagemCwb() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(0.9d, 0d));
        r.add(new ReguaAtingimento(0.91d, 0.8d));
        r.add(new ReguaAtingimento(0.95d, 1d));
        r.add(new ReguaAtingimento(0.98d, 1.5d));
        r.add(new ReguaAtingimento(1.01d, 2d));

        return r;
    }

    private List<ReguaAtingimento> getReguaTriagemSp() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(0.79d, 0d));
        r.add(new ReguaAtingimento(0.8d, 0.8d));
        r.add(new ReguaAtingimento(0.84d, 1d));
        r.add(new ReguaAtingimento(0.87d, 1.5d));
        r.add(new ReguaAtingimento(0.9d, 2d));

        return r;
    }

}
