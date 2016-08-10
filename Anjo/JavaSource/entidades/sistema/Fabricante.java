package entidades.sistema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fabricante {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private Boolean lista;
	
	private Modelo modelo;

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

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
}
