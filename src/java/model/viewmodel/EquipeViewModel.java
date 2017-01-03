/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.viewmodel;

import model.business.equipe.Equipe;

/**
 *
 * @author G0042204
 */
public class EquipeViewModel {

    private Equipe equipe;

    private String nomeEquipe;

    public EquipeViewModel() {
    }

    public EquipeViewModel(Equipe equipe, String nomeEquipe) {
        this.equipe = equipe;
        this.nomeEquipe = nomeEquipe;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

}
