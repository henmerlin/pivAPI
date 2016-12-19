package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Duvida;

@Stateless
public class DuvidaServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarDuvida(Duvida duvida) throws Exception {

		try {

			duvida.setLista(true);

			this.entityManager.persist(duvida);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Duvida");

		}

	}

	public void cadastrarDuvidaByUser(Duvida duvida) throws Exception {

		try {

			duvida.setLista(false);

			this.entityManager.persist(duvida);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Duvida");

		}

	}

	public void modificarDuvida(Duvida duvida) throws Exception {

		try {

			this.entityManager.merge(duvida);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Duvida");

		}

	}

	@SuppressWarnings("unchecked")
	public List<Duvida> listaTodasDuvidas() {

		try {

			Query query = this.entityManager.createQuery("FROM Duvida d");
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Duvida>();

		}

	}

	@SuppressWarnings("unchecked")
	public List<Duvida> listaDuvidasLista(Boolean lista, Boolean ativo) {

		try {

			Query query = this.entityManager.createQuery("FROM Duvida d WHERE d.lista =:param1 AND d.ativo =:param2 ORDER BY upper(d.nome) ASC");
			query.setParameter("param1", lista);
			query.setParameter("param2", ativo);
			return query.getResultList();

		} catch (Exception e) {

			return new ArrayList<Duvida>();

		}

	}

}