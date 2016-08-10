package models;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.ControleUsuario;

@Stateless
public class ControleUsuarioServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarControleUsuario(ControleUsuario controleUsuario) throws Exception {
		
		try {
			
			this.entityManager.persist(controleUsuario);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Controle de Usuário");			
			
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
	
}
