package model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="SuporteN2_Solucao")
public class Solucao implements EntityCrudInterface, Comparable<Solucao>{
	
	@Id
	@GeneratedValue
	private Integer id; 
	
	@NotEmpty(message="Campo requerido!")
	private String nome;
	
	private Boolean ativo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull(message="N�o pode ser nulo.")
	private Motivo motivo;
	
	public Solucao() {
		motivo = new Motivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	@Override
	public int compareTo(Solucao o) {
		return this.getNome().compareToIgnoreCase(o.getNome());
	}
	
}