package entidades.sistema;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import entidades.UsuarioEfika;

@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String instancia;
	
	private String codigo;
	
	@Lob
	private String detalhe;
	
	private Date dataRegistro;
	
	@ManyToOne
	private Solucao solucao;
	
	@ManyToOne
	private Duvida duvida;
	
	@ManyToOne
	private FalhaSistemica falhaSistemica;
	
	@ManyToOne
	private Equipamento equipamento;
	
	@ManyToOne
	private UsuarioEfika usuarioEfika;
	
	@ManyToOne
	private Transmicao transmicao;
	
	@ManyToOne
	private Produto produto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstancia() {
		return instancia;
	}

	public void setInstancia(String instancia) {
		this.instancia = instancia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Solucao getSolucao() {
		return solucao;
	}

	public void setSolucao(Solucao solucao) {
		this.solucao = solucao;
	}

	public Duvida getDuvida() {
		return duvida;
	}

	public void setDuvida(Duvida duvida) {
		this.duvida = duvida;
	}

	public FalhaSistemica getFalhaSistemica() {
		return falhaSistemica;
	}

	public void setFalhaSistemica(FalhaSistemica falhaSistemica) {
		this.falhaSistemica = falhaSistemica;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public UsuarioEfika getUsuarioEfika() {
		return usuarioEfika;
	}

	public void setUsuarioEfika(UsuarioEfika usuarioEfika) {
		this.usuarioEfika = usuarioEfika;
	}

	public Transmicao getTransmicao() {
		return transmicao;
	}

	public void setTransmicao(Transmicao transmicao) {
		this.transmicao = transmicao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}	
	
}
