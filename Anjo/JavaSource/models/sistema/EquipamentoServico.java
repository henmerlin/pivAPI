package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Equipamento;

@Stateless
public class EquipamentoServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarEquipamento(Equipamento equipamento) throws Exception {
		
		try {
			
			equipamento.setLista(true);
			this.entityManager.persist(equipamento);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Equipamento");
			
		}
		
	}
	
	public void modificarEquipamento(Equipamento equipamento) throws Exception {
		
		try {
			
			this.entityManager.merge(equipamento);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Equipamento");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipamento> listarTodosEquipamentos() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Equipamento e");
			return query.getResultList();			
			
		} catch (Exception e) {
			
			return new ArrayList<Equipamento>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipamento> listarEquipamentosLista(Boolean lista) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Equipamento e WHERE e.lista =:param1");
			query.setParameter("param1", lista);
			return query.getResultList();			
			
		} catch (Exception e) {
			
			return new ArrayList<Equipamento>();
			
		}
		
	}
	
}
