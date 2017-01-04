/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.regua;

import java.util.ArrayList;
import java.util.List;
import model.business.equipe.Equipe;
import model.business.indicador.extra.ReguaAtingimento;

/**
 *
 * @author G0042204
 */
public class ReguaFactory {

    private Equipe equipe;

    public ReguaFactory(Equipe equipe) {
        this.equipe = equipe;
    }

    public List<ReguaAtingimento> getRegua() {
        List<ReguaAtingimento> r = new ArrayList<ReguaAtingimento>();

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

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

}
