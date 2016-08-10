package entidades.sistema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private SubProdutoMotivo subProdutoMotivo;

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

	public SubProdutoMotivo getSubProdutoMotivo() {
		return subProdutoMotivo;
	}

	public void setSubProdutoMotivo(SubProdutoMotivo subProdutoMotivo) {
		this.subProdutoMotivo = subProdutoMotivo;
	}	
	
}
