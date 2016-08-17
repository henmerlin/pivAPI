package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Equipe;
import models.EquipeServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class EquipeBean {

	private Equipe equipe;

	private Equipe equipeModifica;

	@EJB
	private EquipeServico equipeServico;

	public EquipeBean() {

		this.equipe = new Equipe();

		this.equipeModifica = new Equipe();

	}

	public void cadastrarEquipe() {

		try {

			this.equipeServico.cadastrarEquipe(this.equipe);
			JSFUtil.addInfoMessage("Equipe cadastrada com sucesso.");
			this.equipe = new Equipe();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificarEquipe() {

		try {

			this.equipeServico.modificarEquipe(this.equipeModifica);
			JSFUtil.addInfoMessage("Equipe modificada com sucesso.");
			this.equipeModifica = new Equipe();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<Equipe> listaEquipe() {

		return this.equipeServico.listaEquipe();

	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Equipe getEquipeModifica() {
		return equipeModifica;
	}

	public void setEquipeModifica(Equipe equipeModifica) {
		this.equipeModifica = equipeModifica;
	}	

}
