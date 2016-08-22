package controllers.sistemainc;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import controllers.LoginBean;
import entidades.sistemainc.AtendimentoInc;
import models.sistemainc.AtendimentoIncServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class AtendimentoIncBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean sessao;
	
	private AtendimentoInc atendimentoInc;
	
	private List<AtendimentoInc> listaAtendimentoInc;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	@EJB
	private AtendimentoIncServico atendimentoIncServico;

	public AtendimentoIncBean() {
		
		this.atendimentoInc = new AtendimentoInc();

	}
	
	public void cadastrarAtendimentoInc() {
		
		try {			
			
			this.atendimentoIncServico.cadastrarAtendimentoInc(this.atendimentoInc, this.sessao.getUsuario());
			JSFUtil.addInfoMessage("INC cadastrado com sucesso.");
			this.atendimentoInc = new AtendimentoInc();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<AtendimentoInc> listarAtendimentoIncDate() {
		
		return this.atendimentoIncServico.listarAtendimentoIncDate(this.dataInicio, this.dataFim);
		
	}

	public AtendimentoInc getAtendimentoInc() {
		return atendimentoInc;
	}

	public void setAtendimentoInc(AtendimentoInc atendimentoInc) {
		this.atendimentoInc = atendimentoInc;
	}

	public List<AtendimentoInc> getListaAtendimentoInc() {
		return listaAtendimentoInc;
	}

	public void setListaAtendimentoInc(List<AtendimentoInc> listaAtendimentoInc) {
		this.listaAtendimentoInc = listaAtendimentoInc;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public LoginBean getSessao() {
		return sessao;
	}

	public void setSessao(LoginBean sessao) {
		this.sessao = sessao;
	}
	
}
