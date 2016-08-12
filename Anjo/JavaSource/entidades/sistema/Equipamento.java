package entidades.sistema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Equipamento {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private Boolean lista;
	
	@ManyToOne
	private Fabricante fabricante;

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

	public Boolean getLista() {
		return lista;
	}

	public void setLista(Boolean lista) {
		this.lista = lista;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}	
	
}
