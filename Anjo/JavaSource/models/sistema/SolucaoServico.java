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

			throw new Exception("Erro ao cadastrar Solucão");

		}

	}

	public void cadastrarSolucaoByUser(Solucao solucao) throws Exception {

		try {

			solucao.setLista(false);

			this.entityManager.persist(solucao);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Solucão");

		}

	}

	public void modificarSolucao(Solucao solucao) throws Exception {

		try {

			this.entityManager.merge(solucao);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Solucão");			

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
	public List<Solucao> listarSolucoesLista(Boolean lista) {

		try {

			Query query = this.entityManager.createQuery("FROM Solucao s WHERE s.lista =:param1");
			query.setParameter("param1", lista);
			return query.getResultList();			

		} catch (Exception e) {

			return new ArrayList<Solucao>(); 

		}

	}

}