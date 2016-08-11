package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.FalhaSistemica;

@Stateless
public class FalhaSistemicaServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarFalhaSistemica(FalhaSistemica falhaSistemica) throws Exception {
		
		try {
			
			this.entityManager.persist(falhaSistemica);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Falha Sistemica");
			
		}
		
	}
	
	public void modificarFalhaSistemica(FalhaSistemica falhaSistemica) throws Exception {
		
		try {
			
			this.entityManager.merge(falhaSistemica);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Falha Sistemica");	
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<FalhaSistemica> listarTodasFalhaSistemicas() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM FalhaSistemica f");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<FalhaSistemica>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<FalhaSistemica> listarFalhaSistemicaLista(Boolean lista) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM FalhaSistemica f WHERE f.lista =:param1");
			query.setParameter("param1", lista);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<FalhaSistemica>();
			
		}
		
	}
	
}
