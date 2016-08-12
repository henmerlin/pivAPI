package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.UsuarioEfika;
import entidades.sistema.Atendimento;
import models.sistema.AtendimentoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class AtendimentoBean {

	private Atendimento atendimento;
	
	@EJB
	private AtendimentoServico atendimentoServico;
	
	
	public AtendimentoBean() {

		this.atendimento = new Atendimento();
		
	}
	
	public void cadastrarAtendimento() {
		
		try {
			
			this.atendimentoServico.cadastrarAtendimento(this.atendimento);
			JSFUtil.addInfoMessage("Atendimento cadastrado com sucesso.");
			this.atendimento = new Atendimento();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());			

		}
		
	}
	
	public List<Atendimento> listarTodosAtendimentos() {
		
		return this.atendimentoServico.listarTodosAtendimentos();
		
	}
	
	public Atendimento listarAtendimentoEspecificoUsuario(UsuarioEfika usuarioEfika) {
		
		try {
			
			return this.atendimentoServico.listarAtendimentoEspecificoUsuario(usuarioEfika);						
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			return null;
			
		}
		
	}
	
}
