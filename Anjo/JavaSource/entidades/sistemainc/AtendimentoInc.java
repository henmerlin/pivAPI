package entidades.sistemainc;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import entidades.UsuarioEfika;
import util.JSFUtil;

@Entity
@Table(name="anjo_Atendimento_inc")
public class AtendimentoInc {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String numero;
	
	private Boolean priorizado;
	
	private Boolean contatoTec;
	
	@Lob
	private String informacoes;

	private Date horaGeradoInc;
	
	private Date dataRegistro;
	
	@ManyToOne
	private UsuarioEfika usuarioEfika;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Boolean getPriorizado() {
		return priorizado;
	}

	public void setPriorizado(Boolean priorizado) {
		this.priorizado = priorizado;
	}

	public Boolean getContatoTec() {
		return contatoTec;
	}

	public void setContatoTec(Boolean contatoTec) {
		this.contatoTec = contatoTec;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public Date getHoraGeradoInc() {
		return horaGeradoInc;
	}
	
	public String getHoraGeradoIncFormatada() {
		
		return JSFUtil.formatarDataHra(this.horaGeradoInc);
		
	}

	public void setHoraGeradoInc(Date horaGeradoInc) {
		this.horaGeradoInc = horaGeradoInc;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}
	
	public String getDataRegistroFormatada() {
		
		return JSFUtil.formatarDataHra(this.dataRegistro);
		
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public UsuarioEfika getUsuarioEfika() {
		return usuarioEfika;
	}

	public void setUsuarioEfika(UsuarioEfika usuarioEfika) {
		this.usuarioEfika = usuarioEfika;
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
		AtendimentoInc other = (AtendimentoInc) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtendimentoInc [id=" + id + "]";
	}
	
}
