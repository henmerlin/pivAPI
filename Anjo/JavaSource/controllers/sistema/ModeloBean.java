package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Modelo;
import models.sistema.ModeloServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ModeloBean {
	
	private Modelo modelo;
	
	private Modelo modeloModifica;
	
	@EJB
	private ModeloServico modeloServico;

	public ModeloBean() {

		this.modelo = new Modelo();
		
		this.modeloModifica = new Modelo();
		
	}
	
	public void cadastrarModelo() {
		
		try {
			
			this.modeloServico.cadastrarModelo(this.modelo);
			JSFUtil.addInfoMessage("Modelo cadastrado com sucesso.");
			this.modelo = new Modelo();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarModelo() {
		
		try {
			
			this.modeloServico.modificarModelo(this.modeloModifica);
			JSFUtil.addInfoMessage("Modelo modificado com sucesso.");
			this.modeloModifica = new Modelo();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Modelo> listarTodosModelos() {
		
		return this.modeloServico.listarTodosModelos();
		
	}
	
	public List<Modelo> listarModelosLista(Boolean lista) {
		
		return this.modeloServico.listarModelosLista(lista);
		
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Modelo getModeloModifica() {
		return modeloModifica;
	}

	public void setModeloModifica(Modelo modeloModifica) {
		this.modeloModifica = modeloModifica;
	}	
	
}