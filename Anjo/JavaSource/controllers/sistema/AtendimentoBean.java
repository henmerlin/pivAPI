package controllers.sistema;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import controllers.LoginBean;
import entidades.UsuarioEfika;
import entidades.sistema.Atendimento;
import entidades.sistema.DetalheDuvida;
import entidades.sistema.InfoEquipamento;
import entidades.sistema.InfoProduto;
import entidades.sistema.Modelo;
import entidades.sistema.Solucao;
import models.sistema.AtendimentoServico;
import models.sistema.DetalheDuvidaServico;
import models.sistema.DuvidaServico;
import models.sistema.InfoEquipamentoServico;
import models.sistema.InfoProdutoServico;
import models.sistema.ModeloServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class AtendimentoBean {

	@ManagedProperty(value="#{loginBean}")
	private LoginBean sessao;

	private Atendimento atendimento;

	private InfoProduto infoProduto;

	private InfoEquipamento infoEquipamento;
	
	private Solucao solucao;
	
	private DetalheDuvida detalheDuvida;
	
	@EJB
	private AtendimentoServico atendimentoServico;

	@EJB
	private InfoProdutoServico infoProdutoServico;

	@EJB
	private DuvidaServico duvidaServico;

	@EJB
	private DetalheDuvidaServico detalheDuvidaServico;

	@EJB
	private InfoEquipamentoServico infoEquipamentoServico; 


	@EJB
	private ModeloServico modeloServico;


	public AtendimentoBean() {

		this.atendimento = new Atendimento();

		this.infoProduto = new InfoProduto();
		
		this.infoEquipamento = new InfoEquipamento();
		
		this.solucao = new Solucao();

		this.detalheDuvida = new DetalheDuvida();
		
	}
	
	@PostConstruct
	public void init() {
		
		this.listarModelosLista();
		
	}

	public void cadastrarAtendimento() {

		try {

			this.validaSeCampoVazio();
			
			this.atendimento.setInfoProduto(this.infoProduto);
			this.cadastrarInfoProduto();
			
			if (this.atendimento.getAcionadoFalhaEqp()) {

				this.atendimento.setInfoEquipamento(this.infoEquipamento);
				this.cadastrarInfoEquipamento();

			}

			this.atendimento.setUsuarioEfika(this.sessao.getUsuario());
			this.atendimentoServico.cadastrarAtendimento(this.atendimento);

			JSFUtil.addInfoMessage("Atendimento cadastrado com sucesso.");
			this.atendimento = new Atendimento();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarInfoProduto() {

		try {

			this.infoProdutoServico.cadastrarInfoProduto(this.infoProduto);
			this.infoProduto = new InfoProduto();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}


	public void cadastrarInfoEquipamento() {

		try {

			this.infoEquipamentoServico.cadastrarInfoEquipamento(this.infoEquipamento);
			this.infoEquipamento = new InfoEquipamento();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void validaSeCampoVazio() throws Exception {

		String nomeErro = "Por favor preencha os seguintes campos";

		Boolean erro = false;

		if (this.atendimento.getMatriculaOperador().isEmpty()) {

			nomeErro = nomeErro + " (matricula) ";
			erro = true;

		}

		if (this.atendimento.getInstancia().isEmpty()) {

			nomeErro = nomeErro + " (instância) ";
			erro = true;

		}

		if (this.atendimento.getTransmissao() == null) {

			nomeErro = nomeErro + " (transmissão) ";
			erro = true;

		}		

		if (this.atendimento.getOrdem() == null) {

			nomeErro = nomeErro + " (ordem) ";
			erro = true;

		}

		if (this.atendimento.getCodigo().isEmpty()) {

			nomeErro = nomeErro + " (código) ";
			erro = true;

		}

		if (this.infoProduto.getProduto() == null) {

			nomeErro = nomeErro + " (produto) ";
			erro = true;

		}

		if (this.infoProduto.getSubProdutoMotivo() == null) {

			nomeErro = nomeErro + " (sub produto) ";
			erro = true;

		}		

		if (this.atendimento.getDuvida() == null) {

			nomeErro = nomeErro + " (duvida) ";
			erro = true;

		}

		if (this.atendimento.getDetalheDuvida() == null) {

			nomeErro = nomeErro + " (detalhe da duvida) ";
			erro = true;

		}

		if (this.atendimento.getAcionadoSuporte() && this.atendimento.getNomeSuporte().isEmpty()) {

			nomeErro = nomeErro + " (nome do suporte) ";
			erro = true;

		}

		if (this.atendimento.getAcionadoFalhaSis() && this.atendimento.getFalhaSis().isEmpty()) {

			nomeErro = nomeErro + " (falha sistemica) ";
			erro = true;

		}

		if (this.atendimento.getAcionadoFalhaEqp() && this.atendimento.getFalhaEqp().isEmpty()) {

			nomeErro = nomeErro + " (falha equipamento) ";
			erro = true;

		}

		if (this.atendimento.getAcionadoFalhaEqp() && this.infoEquipamento.getEquipamento() == null) {

			nomeErro = nomeErro + " (equipamento) ";
			erro = true;

		}

		if (this.atendimento.getAcionadoFalhaEqp() && this.infoEquipamento.getFabricante() == null) {

			nomeErro = nomeErro + " (fabricante) ";
			erro = true;

		}

		if (this.atendimento.getAcionadoFalhaEqp() && this.infoEquipamento.getModelo() == null) {

			nomeErro = nomeErro + " (modelo) ";
			erro = true;

		}

		if (this.atendimento.getSolucao() == null) {

			nomeErro = nomeErro + " (solução) ";
			erro = true;

		}

		if (erro) {

			throw new Exception(nomeErro);

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
	
	public List<Modelo> listarModelosLista() {
		
		return this.modeloServico.listarModelosLista(true);
		
	}
	
	public void selecionadoOutros(String select) {
				
		if (select.equalsIgnoreCase("Nenhuma das opções disponíveis")) {
			
			JSFUtil.addWarnMessage("Descreva no campo \"Outras Informações\"");
		
		}		
		
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public InfoProduto getInfoProduto() {
		return infoProduto;
	}

	public void setInfoProduto(InfoProduto infoProduto) {
		this.infoProduto = infoProduto;
	}

	public InfoEquipamento getInfoEquipamento() {
		return infoEquipamento;
	}

	public void setInfoEquipamento(InfoEquipamento infoEquipamento) {
		this.infoEquipamento = infoEquipamento;
	}
	
	public LoginBean getSessao() {
		return sessao;
	}

	public void setSessao(LoginBean sessao) {
		this.sessao = sessao;
	}

	public Solucao getSolucao() {
		return solucao;
	}

	public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}

	public DetalheDuvida getDetalheDuvida() {
		return detalheDuvida;
	}

	public void setDetalheDuvida(DetalheDuvida detalheDuvida) {
		this.detalheDuvida = detalheDuvida;
	}
	
	
}
