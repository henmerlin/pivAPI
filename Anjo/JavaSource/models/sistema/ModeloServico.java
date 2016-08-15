package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Modelo;

@Stateless
public class ModeloServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarModelo(Modelo modelo) throws Exception {
		
		try {
			
			modelo.setLista(true);
			this.entityManager.persist(modelo);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Modelo.");
			
		}
		
	}
	
	public void modificarModelo(Modelo modelo) throws Exception {	
		
		try {
			
			this.entityManager.merge(modelo);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Modelo.");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Modelo> listarTodosModelos() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Modelo m");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Modelo>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Modelo> listarModelosLista(Boolean lista) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Modelo m WHERE m.lista =:param1");
			query.setParameter("param1", lista);
			return query.getResultList();			
			
		} catch (Exception e) {
			
			return new ArrayList<Modelo>();
			
		}		
		
	}
	
}
