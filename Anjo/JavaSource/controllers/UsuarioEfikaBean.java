package controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entidades.UsuarioEfika;
import entidades.sistema.Equipe;
import models.UsuarioEfikaServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class UsuarioEfikaBean {
	
	private UsuarioEfika usuarioEfika;
	
	private UsuarioEfika usuarioEfikaModifica;
	
	@EJB
	private UsuarioEfikaServico usuarioEfikaServico;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean sessao;
	
	public UsuarioEfikaBean() {

		this.usuarioEfika = new UsuarioEfika();
		
		this.usuarioEfikaModifica = new UsuarioEfika();
	
	}
	
	public void modificarUsuarioEfika() {
		
		try {
			
			this.usuarioEfikaServico.modificarUsuarioEfika(this.usuarioEfika);
			JSFUtil.addInfoMessage("Usuário modificado com sucesso.");
			this.usuarioEfika = new UsuarioEfika();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<UsuarioEfika> listarUsuarioEfikaAtivo(Boolean ativo) {
		
		return this.usuarioEfikaServico.listarUsuarioEfikaAtivo(ativo);
		
	}
	
	public List<UsuarioEfika> listarUsuarioEfikaAdm(Boolean adm) {
		
		return this.usuarioEfikaServico.listarUsuarioEfikaAdm(adm);
		
	}
	
	public List<UsuarioEfika> listarUsuarioEfikaEquipe(Equipe equipe) {
		
		return this.usuarioEfikaServico.listarUsuarioEfikaEquipe(equipe);
		
	}
	
	public UsuarioEfika listarUsuarioEfikaEspecifico(UsuarioEfika usuarioEfika) {
		
		try {
			
			return this.usuarioEfikaServico.listarUsuarioEfikaEspecifico(usuarioEfika);
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			return null;
			
		}
		
	}

	public UsuarioEfika getUsuarioEfika() {
		return usuarioEfika;
	}

	public void setUsuarioEfika(UsuarioEfika usuarioEfika) {
		this.usuarioEfika = usuarioEfika;
	}

	public UsuarioEfika getUsuarioEfikaModifica() {
		return usuarioEfikaModifica;
	}

	public void setUsuarioEfikaModifica(UsuarioEfika usuarioEfikaModifica) {
		this.usuarioEfikaModifica = usuarioEfikaModifica;
	}

	public LoginBean getSessao() {
		return sessao;
	}

	public void setSessao(LoginBean sessao) {
		this.sessao = sessao;
	}

}
