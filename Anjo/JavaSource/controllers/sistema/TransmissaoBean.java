package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.sistema.Transmissao;
import models.sistema.TransmissaoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class TransmissaoBean {

	private Transmissao transmissao;

	private Transmissao transmissaoModifica;

	@EJB
	private TransmissaoServico transmissaoServico;

	public TransmissaoBean() {

		this.transmissao = new Transmissao();

		this.transmissaoModifica = new Transmissao();

	}

	public void cadastrarTransmissao() {

		try {

			this.transmissaoServico.cadastrarTransmissao(this.transmissao);
			JSFUtil.addInfoMessage("Transmissao cadastrada com sucesso");			
			this.transmissao = new Transmissao();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void modificarTransmissao() {

		try {

			this.transmissaoServico.modificarTransmissao(this.transmissaoModifica);
			JSFUtil.addInfoMessage("Transmissao modificada com sucesso");			
			this.transmissaoModifica = new Transmissao();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public List<Transmissao> listarTransmissao() {		

		return this.transmissaoServico.listarTransmissao();

	}

	public List<Transmissao> listarTransmissaoAtivo(Boolean ativo) {		

		return this.transmissaoServico.listarTransmissaoAtivo(ativo);

	}

	public Transmissao getTransmissao() {
		return transmissao;
	}

	public void setTransmissao(Transmissao transmissao) {
		this.transmissao = transmissao;
	}

	public Transmissao getTransmissaoModifica() {
		return transmissaoModifica;
	}

	public void setTransmissaoModifica(Transmissao transmissaoModifica) {
		this.transmissaoModifica = transmissaoModifica;
	}

}
