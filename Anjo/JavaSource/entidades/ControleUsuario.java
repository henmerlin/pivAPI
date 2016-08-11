package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import entidades.sistema.Equipe;

@Entity
public class ControleUsuario {

	@Id
	@GeneratedValue
	private Integer id;
	
	private Boolean ativo;
	
	private Boolean adm;
	
	private UsuarioEfika usuarioEfika;
	
	private Equipe equipe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getAdm() {
		return adm;
	}

	public void setAdm(Boolean adm) {
		this.adm = adm;
	}

	public UsuarioEfika getUsuarioEfika() {
		return usuarioEfika;
	}

	public void setUsuarioEfika(UsuarioEfika usuarioEfika) {
		this.usuarioEfika = usuarioEfika;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
}
