package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.DetalheDuvida;
import models.sistema.DetalheDuvidaServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class DetalheDuvidaBean {

	private DetalheDuvida detalheDuvida;

	private DetalheDuvida detalheDuvidaModifica;

	@EJB
	private DetalheDuvidaServico detalheDuvidaServico;

	public DetalheDuvidaBean() {

		this.detalheDuvida = new DetalheDuvida();

		this.detalheDuvidaModifica = new DetalheDuvida();

	}

	public void cadastrarDetalheDuvida() {

		try {

			this.detalheDuvidaServico.cadastrarDetalheDuvida(this.detalheDuvida);
			JSFUtil.addInfoMessage("Detalhe cadastrado com sucesso.");
			this.detalheDuvida = new DetalheDuvida();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificarDetalheDuvida() {

		try {

			this.detalheDuvidaServico.modificarDetalheDuvida(this.detalheDuvidaModifica);
			JSFUtil.addInfoMessage("Detalhe modificado com sucesso.");
			this.detalheDuvidaModifica = new DetalheDuvida();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}
	
	public List<DetalheDuvida> listardetalheDuvida() {
		
		return this.detalheDuvidaServico.listarDetalheDuvida();
		
	}
	
	public List<DetalheDuvida> listardetalheDuvidaLista(Boolean lista) {
		
		return this.detalheDuvidaServico.listarDetalheDuvidaLista(lista);
		
	}

	public DetalheDuvida getDetalheDuvida() {
		return detalheDuvida;
	}

	public void setDetalheDuvida(DetalheDuvida detalheDuvida) {
		this.detalheDuvida = detalheDuvida;
	}

	public DetalheDuvida getDetalheDuvidaModifica() {
		return detalheDuvidaModifica;
	}

	public void setDetalheDuvidaModifica(DetalheDuvida detalheDuvidaModifica) {
		this.detalheDuvidaModifica = detalheDuvidaModifica;
	}	

}
