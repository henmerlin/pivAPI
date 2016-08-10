package entidades.sistema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Modelo {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private Boolean lista;

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
	
}
