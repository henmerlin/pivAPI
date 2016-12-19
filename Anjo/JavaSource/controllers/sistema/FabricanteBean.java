package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Fabricante;
import models.sistema.FabricanteServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;

	private Fabricante fabricanteModifica;

	@EJB
	private FabricanteServico fabricanteServico;

	public FabricanteBean() {

		this.fabricante = new Fabricante();

		this.fabricanteModifica = new Fabricante();

	}

	public void cadastrarFabricante() {

		try {

			this.fabricanteServico.cadastrarFabricante(this.fabricante);
			JSFUtil.addInfoMessage("Fabricante cadastrado com sucesso.");
			this.fabricante = new Fabricante();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificaFabricante() {

		try {

			this.fabricanteServico.modificarFabricante(this.fabricanteModifica);
			JSFUtil.addInfoMessage("Fabricante modificado com sucesso.");
			this.fabricanteModifica = new Fabricante();			

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<Fabricante> listarTodosFabricantes() {
		
		return this.fabricanteServico.listarTodosFabricantes();
		
	}

	public List<Fabricante> listarFabricantesLista(Boolean lista, Boolean ativo) {
		
		return this.fabricanteServico.listarFabricantesLista(lista, ativo);
		
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Fabricante getFabricanteModifica() {
		return fabricanteModifica;
	}

	public void setFabricanteModifica(Fabricante fabricanteModifica) {
		this.fabricanteModifica = fabricanteModifica;
	}	

}