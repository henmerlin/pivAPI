package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Transmissao;

@Stateless
public class TransmissaoServico {


	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarTransmissao(Transmissao transmissao) throws Exception {

		try {

			this.entityManager.persist(transmissao);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Transmissao");

		}

	}

	public void modificarTransmissao(Transmissao transmissao) throws Exception {

		try {

			this.entityManager.merge(transmissao);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Transmissao");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Transmissao> listarTransmissao() {

		try {

			Query query = this.entityManager.createQuery("FROM Transmissao t");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Transmissao>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Transmissao> listarTransmissaoAtivo(Boolean ativo) {

		try {

			Query query = this.entityManager.createQuery("FROM Transmissao t WHERE t.ativo =:param1");
			query.setParameter("param1", ativo);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Transmissao>();

		}

	}

}
