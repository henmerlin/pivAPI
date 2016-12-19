package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Equipamento;
import models.sistema.EquipamentoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class EquipamentoBean {
	
	private Equipamento equipamento;
	
	private Equipamento equipamentoModifica;
	
	@EJB
	private EquipamentoServico equipamentoServico;

	public EquipamentoBean() {

		this.equipamento = new Equipamento();
		
		this.equipamentoModifica = new Equipamento();
		
	}	
	
	public void cadastrarEquipamento() {
		
		try {
			
			this.equipamentoServico.cadastrarEquipamento(this.equipamento);
			JSFUtil.addInfoMessage("Equipamento cadastrado com sucesso.");
			this.equipamento = new Equipamento();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificarEquipamento() {
		
		try {
			
			this.equipamentoServico.modificarEquipamento(this.equipamentoModifica);
			JSFUtil.addInfoMessage("Equipamento modificado com sucesso.");
			this.equipamentoModifica = new Equipamento();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Equipamento> listarTodosEquipamentos() {
		
		return this.equipamentoServico.listarTodosEquipamentos();
		
	}
	
	public List<Equipamento> listarEquipamentosLista(Boolean lista, Boolean ativo) {
		
		return this.equipamentoServico.listarEquipamentosLista(lista, ativo);
		
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Equipamento getEquipamentoModifica() {
		return equipamentoModifica;
	}

	public void setEquipamentoModifica(Equipamento equipamentoModifica) {
		this.equipamentoModifica = equipamentoModifica;
	}	
	
}