package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.FalhaSistemica;
import models.sistema.FalhaSistemicaServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FalhaSistemicaBean {

	private FalhaSistemica falhaSistemica;
	
	private FalhaSistemica falhaSistemicaModifica;
	
	@EJB
	private FalhaSistemicaServico falhaSistemicaServico;
	
	public FalhaSistemicaBean() {
		
		this.falhaSistemica = new FalhaSistemica();
		
		this.falhaSistemicaModifica = new FalhaSistemica();
		
	}
	
	public void cadastrarFalhaSistemica() {
		
		try {
						
			this.falhaSistemicaServico.cadastrarFalhaSistemica(this.falhaSistemica);
			JSFUtil.addInfoMessage("Falha Sistemica cadastrada com sucesso.");
			this.falhaSistemica = new FalhaSistemica();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarFalhaSistemica() {
		
		try {
			
			this.falhaSistemicaServico.modificarFalhaSistemica(this.falhaSistemicaModifica);
			JSFUtil.addInfoMessage("Falha Sistemica modificada com sucesso.");
			this.falhaSistemicaModifica = new FalhaSistemica();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<FalhaSistemica> listarTodasFalhaSistemicas() {
		
		return this.falhaSistemicaServico.listarTodasFalhaSistemicas();
		
	}
	
	public List<FalhaSistemica> listarFalhaSistemicaLista(Boolean lista) {
		
		return this.falhaSistemicaServico.listarFalhaSistemicaLista(lista);
		
	}

	public FalhaSistemica getFalhaSistemica() {
		return falhaSistemica;
	}

	public void setFalhaSistemica(FalhaSistemica falhaSistemica) {
		this.falhaSistemica = falhaSistemica;
	}

	public FalhaSistemica getFalhaSistemicaModifica() {
		return falhaSistemicaModifica;
	}

	public void setFalhaSistemicaModifica(FalhaSistemica falhaSistemicaModifica) {
		this.falhaSistemicaModifica = falhaSistemicaModifica;
	}	
	
}
