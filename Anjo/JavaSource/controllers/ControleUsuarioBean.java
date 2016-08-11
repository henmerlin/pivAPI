package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entidades.ControleUsuario;
import models.ControleUsuarioServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ControleUsuarioBean {
	
	private ControleUsuario controleUsuario;
	
	private ControleUsuario controleUsuarioModifica;
	
	@EJB
	private ControleUsuarioServico controleUsuarioServico;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean sessao;

	public ControleUsuarioBean() {
		
		this.controleUsuario = new ControleUsuario();
		
	} 
	
	public void cadastrarControleUsuario() {
		
		try {
			
			this.controleUsuarioServico.cadastrarControleUsuario(this.controleUsuario, this.sessao.getUsuario());
			
			this.controleUsuario = new ControleUsuario();
			
			JSFUtil.addInfoMessage("Controle cadastrado com sucesso.");
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}

	public ControleUsuario getControleUsuario() {
		return controleUsuario;
	}

	public void setControleUsuario(ControleUsuario controleUsuario) {
		this.controleUsuario = controleUsuario;
	}

	public ControleUsuario getControleUsuarioModifica() {
		return controleUsuarioModifica;
	}

	public void setControleUsuarioModifica(ControleUsuario controleUsuarioModifica) {
		this.controleUsuarioModifica = controleUsuarioModifica;
	}

	public LoginBean getSessao() {
		return sessao;
	}

	public void setSessao(LoginBean sessao) {
		this.sessao = sessao;
	}
	
}
