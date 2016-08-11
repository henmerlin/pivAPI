package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Transmicao;
import models.sistema.TransmicaoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class TransmicaoBean {
	
	private Transmicao transmicao;
	
	private Transmicao transmicaoModifica;
	
	@EJB
	private TransmicaoServico transmicaoServico;
	
	public TransmicaoBean() {

		this.transmicao = new Transmicao();
		
		this.transmicaoModifica = new Transmicao();
		
	}
	
	public void cadastrarTransmicao() {
		
		try {
			
			this.transmicaoServico.cadastrarTransmicao(this.transmicao);
			JSFUtil.addInfoMessage("Transmicão cadastrada com sucesso.");
			this.transmicao = new Transmicao();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public void modificaTransmicao() {
		
		try {
			
			this.transmicaoServico.modificarTransmicao(this.transmicaoModifica);
			JSFUtil.addInfoMessage("Transmicão modificada com sucesso.");
			this.transmicaoModifica = new Transmicao();
			
		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());
			
		}
		
	}
	
	public List<Transmicao> listarTransmicao() {
		
		return this.transmicaoServico.listarTransmicao();
		
	}

	public Transmicao getTransmicao() {
		return transmicao;
	}

	public void setTransmicao(Transmicao transmicao) {
		this.transmicao = transmicao;
	}

	public Transmicao getTransmicaoModifica() {
		return transmicaoModifica;
	}

	public void setTransmicaoModifica(Transmicao transmicaoModifica) {
		this.transmicaoModifica = transmicaoModifica;
	}	

}
