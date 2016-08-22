package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Solucao;
import models.sistema.SolucaoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class SolucaoBean {
	
	private Solucao solucao;
	
	private Solucao solucaoModifica;
	
	@EJB
	private SolucaoServico solucaoServico;

	public SolucaoBean() {
		
		this.solucao = new Solucao();
		
		this.solucaoModifica = new Solucao();
		
	}
	
	public void cadastrarSolucao() {
		
		try {
			
			this.solucaoServico.cadastrarSolucao(this.solucao);
			JSFUtil.addInfoMessage("Solução cadastrada com sucesso.");
			this.solucao = new Solucao();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificaSolucao() {
		
		try {
			
			this.solucaoServico.modificarSolucao(this.solucaoModifica);
			JSFUtil.addInfoMessage("Solucão modificada com sucesso.");
			this.solucaoModifica = new Solucao();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Solucao> listarTodasSolucoes() {
		
		return this.solucaoServico.listarTodasSolucoes();
		
	}
	
	public List<Solucao> listarSolucoesLista(Boolean lista, Boolean ativo) {
		
		return this.solucaoServico.listarSolucoesLista(lista, ativo);
		
	}

	public Solucao getSolucao() {
		return solucao;
	}

	public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}

	public Solucao getSolucaoModifica() {
		return solucaoModifica;
	}

	public void setSolucaoModifica(Solucao solucaoModifica) {
		this.solucaoModifica = solucaoModifica;
	}	
	
}