package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Solucao;

@Stateless
public class SolucaoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarSolucao(Solucao solucao) throws Exception {

		try {

			solucao.setLista(true);

			this.entityManager.persist(solucao);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Soluc�o");

		}

	}

	public void cadastrarSolucaoByUser(Solucao solucao) throws Exception {

		try {

			solucao.setLista(false);

			this.entityManager.persist(solucao);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Soluc�o");

		}

	}

	public void modificarSolucao(Solucao solucao) throws Exception {

		try {

			this.entityManager.merge(solucao);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Soluc�o");			

		}

	}

	@SuppressWarnings("unchecked")
	public List<Solucao> listarTodasSolucoes() {

		try {

			Query query = this.entityManager.createQuery("FROM Solucao s");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Solucao>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Solucao> listarSolucoesLista(Boolean lista, Boolean ativo) {

		try {

			Query query = this.entityManager.createQuery("FROM Solucao s WHERE s.lista =:param1 AND s.ativo =:param2 ORDER BY s.nome ASC");
			query.setParameter("param1", lista);
			query.setParameter("param2", ativo);
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<Solucao>(); 

		}

	}

}