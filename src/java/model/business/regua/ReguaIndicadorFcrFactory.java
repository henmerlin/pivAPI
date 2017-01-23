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
public class ReguaIndicadorFcrFactory extends ReguaIndicadorAbstractFactory implements
        ReguaMaker {

    public ReguaIndicadorFcrFactory(Indicador ind, Equipe eqp) {
        super(ind, eqp);
    }

    /**
     * Regua de Atingimento do FCR
     *
     * @return
     */
    @Override
    public List<ReguaAtingimento> getRegua() {

        if (eqp.equals(Equipe.CADASTRO)) {
            return this.getReguaCadastro();
        } else if (eqp.equals(Equipe.MULTISKILL)
                || eqp.equals(Equipe.MULTISKILL_NOVOS)
                || eqp.equals(Equipe.ESPECIALIZADA)) {
            return this.getReguaMultiskill();
        }

        return this.getReguaSaoPaulo();
    }

    private List<ReguaAtingimento> getReguaMultiskill() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(0.635d, 0d));
        r.add(new ReguaAtingimento(0.645d, 0.3d));
        r.add(new ReguaAtingimento(0.655d, 0.35d));
        r.add(new ReguaAtingimento(0.665d, 0.4d));
        r.add(new ReguaAtingimento(0.675d, 0.45d));
        r.add(new ReguaAtingimento(0.685d, 0.5d));
        r.add(new ReguaAtingimento(0.695d, 0.55d));
        r.add(new ReguaAtingimento(0.705d, 0.6d));
        r.add(new ReguaAtingimento(0.715d, 0.65d));
        r.add(new ReguaAtingimento(0.725d, 0.7d));
        r.add(new ReguaAtingimento(0.735d, 0.75d));
        r.add(new ReguaAtingimento(0.745d, 0.8d));
        r.add(new ReguaAtingimento(0.755d, 0.85d));
        r.add(new ReguaAtingimento(0.765d, 1d));
        r.add(new ReguaAtingimento(0.775d, 1.05d));
        r.add(new ReguaAtingimento(0.785d, 1.1d));
        r.add(new ReguaAtingimento(0.795d, 1.2d));
        r.add(new ReguaAtingimento(0.805d, 1.25d));
        r.add(new ReguaAtingimento(0.815d, 1.3d));
        r.add(new ReguaAtingimento(0.825d, 1.5d));
        r.add(new ReguaAtingimento(0.835d, 2d));

        return r;
    }

    private List<ReguaAtingimento> getReguaCadastro() {
        List<ReguaAtingimento> r = new ArrayList<>();

        r.add(new ReguaAtingimento(0.605d, 0d));
        r.add(new ReguaAtingimento(0.615d, 0.3d));
        r.add(new ReguaAtingimento(0.625d, 0.35d));
        r.add(new ReguaAtingimento(0.635d, 0.4d));
        r.add(new ReguaAtingimento(0.645d, 0.45d));
        r.add(new ReguaAtingimento(0.655d, 0.5d));
        r.add(new ReguaAtingimento(0.665d, 0.55d));
        r.add(new ReguaAtingimento(0.675d, 0.6d));
        r.add(new ReguaAtingimento(0.685d, 0.65d));
        r.add(new ReguaAtingimento(0.695d, 0.7d));
        r.add(new ReguaAtingimento(0.705d, 0.75d));
        r.add(new ReguaAtingimento(0.715d, 0.8d));
        r.add(new ReguaAtingimento(0.725d, 0.85d));
        r.add(new ReguaAtingimento(0.735d, 1d));
        r.add(new ReguaAtingimento(0.745d, 1.05d));
        r.add(new ReguaAtingimento(0.755d, 1.1d));
        r.add(new ReguaAtingimento(0.765d, 1.2d));
        r.add(new ReguaAtingimento(0.775d, 1.25d));
        r.add(new ReguaAtingimento(0.785d, 1.3d));
        r.add(new ReguaAtingimento(0.795d, 1.5d));
        r.add(new ReguaAtingimento(0.805d, 2d));

        return r;
    }

    private List<ReguaAtingimento> getReguaSaoPaulo() {
        List<ReguaAtingimento> r = new ArrayList<>();
        r.add(new ReguaAtingimento(0.47d, 0d));
        r.add(new ReguaAtingimento(0.48d, 0.3d));
        r.add(new ReguaAtingimento(0.49d, 0.35d));
        r.add(new ReguaAtingimento(0.5d, 0.4d));
        r.add(new ReguaAtingimento(0.51d, 0.45d));
        r.add(new ReguaAtingimento(0.52d, 0.5d));
        r.add(new ReguaAtingimento(0.53d, 0.55d));
        r.add(new ReguaAtingimento(0.54d, 0.6d));
        r.add(new ReguaAtingimento(0.55d, 0.65d));
        r.add(new ReguaAtingimento(0.56d, 0.7d));
        r.add(new ReguaAtingimento(0.57d, 0.75d));
        r.add(new ReguaAtingimento(0.58d, 0.8d));
        r.add(new ReguaAtingimento(0.59d, 0.85d));
        r.add(new ReguaAtingimento(0.6d, 1d));
        r.add(new ReguaAtingimento(0.61d, 1.05d));
        r.add(new ReguaAtingimento(0.62d, 1.1d));
        r.add(new ReguaAtingimento(0.63d, 1.2d));
        r.add(new ReguaAtingimento(0.64d, 1.25d));
        r.add(new ReguaAtingimento(0.65d, 1.3d));
        r.add(new ReguaAtingimento(0.66d, 1.5d));
        r.add(new ReguaAtingimento(0.67d, 2d));

        return r;
    }

}
