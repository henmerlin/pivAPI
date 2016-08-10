package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Equipe;

@Stateless
public class EquipeServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarEquipe(Equipe equipe) throws Exception {
		
		try {
			
			this.entityManager.persist(equipe);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Equipe.");
			
		}
		
	}
	
	public void modificarEquipe(Equipe equipe) throws Exception {
		
		try {
			
			this.entityManager.merge(equipe);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Equipe");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipe> listaEquipe() {
		
		try {
			
			 Query query = this.entityManager.createQuery("FROM Equipe e");
			 return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Equipe>();
			
		}
		
	}
	
	
}
