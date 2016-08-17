package entidades.sistema;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InfoProduto {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private SubProdutoMotivo subProdutoMotivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public SubProdutoMotivo getSubProdutoMotivo() {
		return subProdutoMotivo;
	}

	public void setSubProdutoMotivo(SubProdutoMotivo subProdutoMotivo) {
		this.subProdutoMotivo = subProdutoMotivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InfoProduto other = (InfoProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InfoProduto [id=" + id + "]";
	}	
	
}
