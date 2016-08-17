package controllers.sistema;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import controllers.LoginBean;
import entidades.UsuarioEfika;
import entidades.sistema.Atendimento;
import entidades.sistema.DetalheDuvida;
import entidades.sistema.Duvida;
import entidades.sistema.Equipamento;
import entidades.sistema.Fabricante;
import entidades.sistema.InfoEquipamento;
import entidades.sistema.InfoProduto;
import entidades.sistema.Modelo;
import entidades.sistema.Solucao;
import models.sistema.AtendimentoServico;
import models.sistema.DetalheDuvidaServico;
import models.sistema.DuvidaServico;
import models.sistema.EquipamentoServico;
import models.sistema.FabricanteServico;
import models.sistema.InfoEquipamentoServico;
import models.sistema.InfoProdutoServico;
import models.sistema.ModeloServico;
import models.sistema.SolucaoServico;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class AtendimentoBean {

	@ManagedProperty(value="#{loginBean}")
	private LoginBean sessao;

	private Atendimento atendimento;

	private InfoProduto infoProduto;

	private InfoEquipamento infoEquipamento;

	private Duvida duvida;

	private DetalheDuvida detalheDuvida;

	private Equipamento equipamento;

	private Fabricante fabricante;

	private Modelo modelo;

	private Solucao solucao;

	@EJB
	private AtendimentoServico atendimentoServico;

	@EJB
	private InfoProdutoServico infoProdutoServico;

	@EJB
	private DuvidaServico duvidaServico;

	@EJB
	private DetalheDuvidaServico detalheDuvidaServico;

	@EJB
	private EquipamentoServico equipamentoServico;

	@EJB
	private InfoEquipamentoServico infoEquipamentoServico; 

	@EJB
	private FabricanteServico fabricanteServico;

	@EJB
	private ModeloServico modeloServico;

	@EJB
	private SolucaoServico solucaoServico;

	public AtendimentoBean() {

		this.atendimento = new Atendimento();

		this.infoProduto = new InfoProduto();

		this.duvida = new Duvida();

		this.detalheDuvida = new DetalheDuvida();

		this.infoEquipamento = new InfoEquipamento();

		this.equipamento = new Equipamento();

		this.fabricante = new Fabricante();

		this.modelo = new Modelo();

		this.solucao = new Solucao();

	}

	public void cadastrarAtendimento() {

		try {

			this.validaSeCampoVazio();
			this.validarCamposOutros();
			
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

	public void cadastrarDuvida() {

		try {
			this.duvidaServico.cadastrarDuvidaByUser(this.duvida);
			this.duvida = new Duvida();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarDetalheDuvida() {

		try {

			this.detalheDuvidaServico.cadastrarDetalheDuvidaByUser(this.detalheDuvida);
			this.detalheDuvida = new DetalheDuvida();


		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarEquipamento() {

		try {

			this.equipamentoServico.cadastrarEquipamentoByUser(this.equipamento);
			this.equipamento = new Equipamento();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarFabricante() {

		try {

			this.fabricanteServico.cadastrarFabricanteByUser(this.fabricante);
			this.fabricante = new Fabricante();			

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarModelo() {

		try {

			this.modeloServico.cadastrarModeloByUser(this.modelo);
			this.modelo = new Modelo();

		} catch (Exception e) {

			JSFUtil.addErrorMessage(e.getMessage());

		}

	}

	public void cadastrarSolucao() {

		try {

			this.solucaoServico.cadastrarSolucaoByUser(this.solucao);
			this.solucao = new Solucao();

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

		if (this.atendimento.getDuvida() == null || this.atendimento.getDuvida().getNome().equalsIgnoreCase("Outros") && this.duvida == null) {

			nomeErro = nomeErro + " (duvida) ";
			erro = true;

		}

		if (this.atendimento.getDetalheDuvida() == null || this.atendimento.getDetalheDuvida().getNome().equalsIgnoreCase("Outros") && this.detalheDuvida == null) {

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

		if (this.atendimento.getAcionadoFalhaEqp() && (this.infoEquipamento.getEquipamento() == null || this.infoEquipamento.getEquipamento().getNome().equalsIgnoreCase("Outros") && this.equipamento.getNome().isEmpty())) {

			nomeErro = nomeErro + " (equipamento) ";
			erro = true;

		}

		if (this.atendimento.getAcionadoFalhaEqp() && (this.infoEquipamento.getFabricante() == null || this.infoEquipamento.getEquipamento().getNome().equalsIgnoreCase("Outros") && this.fabricante.getNome().isEmpty())) {

			nomeErro = nomeErro + " (fabricante) ";
			erro = true;

		}

		if (this.atendimento.getAcionadoFalhaEqp() && (this.infoEquipamento.getModelo() == null || this.infoEquipamento.getModelo().getNome().equalsIgnoreCase("Outros") && this.modelo.getNome().isEmpty())) {

			nomeErro = nomeErro + " (modelo) ";
			erro = true;

		}

		if (this.atendimento.getSolucao() == null || this.atendimento.getSolucao().getNome().equalsIgnoreCase("Outros") && this.solucao.getNome().isEmpty()) {

			nomeErro = nomeErro + " (solução) ";
			erro = true;

		}

		if (erro) {

			throw new Exception(nomeErro);

		}


	}

	public void validarCamposOutros() {
				
		if (this.atendimento.getDuvida().getNome().equalsIgnoreCase("Outros")) {
			
			this.atendimento.setDuvida(this.duvida);				
			this.cadastrarDuvida();

		}

		if (this.atendimento.getDetalheDuvida().getNome().equalsIgnoreCase("Outros")) {

			this.atendimento.setDetalheDuvida(this.detalheDuvida);				
			this.cadastrarDetalheDuvida();				

		}

		if (this.atendimento.getAcionadoFalhaEqp() && this.infoEquipamento.getEquipamento().getNome().equalsIgnoreCase("Outros")) {
			
			this.infoEquipamento.setEquipamento(this.equipamento);				
			this.cadastrarEquipamento();

		}

		if (this.atendimento.getAcionadoFalhaEqp() && this.infoEquipamento.getFabricante().getNome().equalsIgnoreCase("Outros")) {

			this.infoEquipamento.setFabricante(this.fabricante);				
			this.cadastrarFabricante();

		}
		
		if (this.atendimento.getAcionadoFalhaEqp() && this.infoEquipamento.getModelo().getNome().equalsIgnoreCase("Outros")) {

			this.infoEquipamento.setModelo(this.modelo);				
			this.cadastrarModelo();				

		}
		
		if (this.atendimento.getSolucao().getNome().equalsIgnoreCase("Outros")) {

			this.atendimento.setSolucao(this.solucao);
			this.cadastrarSolucao();

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

	public Duvida getDuvida() {
		return duvida;
	}

	public void setDuvida(Duvida duvida) {
		this.duvida = duvida;
	}

	public DetalheDuvida getDetalheDuvida() {
		return detalheDuvida;
	}

	public void setDetalheDuvida(DetalheDuvida detalheDuvida) {
		this.detalheDuvida = detalheDuvida;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Solucao getSolucao() {
		return solucao;
	}

	public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}

	public LoginBean getSessao() {
		return sessao;
	}

	public void setSessao(LoginBean sessao) {
		this.sessao = sessao;
	}		
}
