/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.business.equipe;

import java.util.ArrayList;
import java.util.List;
import model.viewmodel.EquipeViewModel;

/**
 *
 * @author G0042204
 */
public enum Equipe {

    MULTISKILL("MULTISKILL"), MULTISKILL_NOVOS("MULTISKILL NOVOS"), ESPECIALIZADA("ESPECIALIZADA");

    public String nome;

    private Equipe(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
