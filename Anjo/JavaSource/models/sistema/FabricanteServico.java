package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Fabricante;
import entidades.sistema.Modelo;

@Stateless
public class FabricanteServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;


	public void cadastrarFabricante(Fabricante fabricante) throws Exception {

		try {

			fabricante.setLista(true);
			this.entityManager.persist(fabricante);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Fabricante.");

		}

	}

	public void cadastrarFabricanteByUser(Fabricante fabricante) throws Exception {

		try {

			fabricante.setLista(false);
			this.entityManager.persist(fabricante);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Fabricante.");

		}

	}

	public void modificarFabricante(Fabricante fabricante) throws Exception {

		try {

			this.entityManager.merge(fabricante);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Fabricante");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> listarTodosFabricantes() {

		try {

			Query query = this.entityManager.createQuery("FROM Fabricante f");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Fabricante>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> listarFabricantesLista(Boolean lista, Boolean ativo) {

		try {

			Query query = this.entityManager.createQuery("FROM Fabricante f WHERE f.lista =:param1 AND f.ativo =:param2 ORDER BY f.nome ASC");
			query.setParameter("param1", lista);
			query.setParameter("param2", ativo);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Fabricante>();

		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Fabricante> listarFabricantesLista(Modelo modelo) {

		try {

			Query query = this.entityManager.createQuery("FROM Fabricante f WHERE f.modelo =:param1");
			query.setParameter("param1", modelo);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Fabricante>();

		}

	}
}