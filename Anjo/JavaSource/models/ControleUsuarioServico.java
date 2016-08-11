package models;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.ControleUsuario;
import entidades.UsuarioEfika;

@Stateless
public class ControleUsuarioServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarControleUsuario(ControleUsuario controleUsuario, UsuarioEfika usuarioEfika) throws Exception {

		try {

			controleUsuario.setUsuarioEfika(usuarioEfika);			

			this.entityManager.persist(controleUsuario);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Controle de Usuário[1]");			

		}

	}

	public void cadastrarControleUsuario(UsuarioEfika usuarioEfika) throws Exception {

		try {

			ControleUsuario controleUsuario = new ControleUsuario();
			
			controleUsuario.setUsuarioEfika(usuarioEfika);			

			this.entityManager.persist(controleUsuario);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Controle de Usuário[2]");			

		}

	}

	public void modificarControleUsuario(ControleUsuario controleUsuario) throws Exception {

		try {

			this.entityManager.merge(controleUsuario);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Controle Usuário");

		}

	}

	@SuppressWarnings("unchecked")
	public List<ControleUsuario> listarControleUsuario(Boolean ativo) {

		try {

			Query query = this.entityManager.createQuery("FROM ControleUsuario c WHERE c.ativo =:param1");
			query.setParameter("param1", ativo);
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<ControleUsuario>();			

		}

	}

	public ControleUsuario listarControleUsuarioEspecifico(UsuarioEfika usuarioEfika) throws Exception {

		try {

			Query query = this.entityManager.createQuery("FROM ControleUsuario c WHERE c.usuarioEfika =:param1");
			query.setParameter("param1", usuarioEfika);
			return (ControleUsuario) query.getSingleResult();

		} catch (Exception e) {

			throw new Exception("Usuário não cadastro");

		}

	}

}
