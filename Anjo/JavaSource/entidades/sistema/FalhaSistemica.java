package entidades.sistema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FalhaSistemica {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Boolean falha;
	
	@Lob
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getFalha() {
		return falha;
	}

	public void setFalha(Boolean falha) {
		this.falha = falha;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
}
