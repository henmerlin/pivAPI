package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Transmicao;

@Stateless
public class TransmicaoServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarTransmicao(Transmicao transmicao) throws Exception {
		
		try {
			
			this.entityManager.persist(transmicao);
			
		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Transmicão");
			
		}
		
	}
	
	public void modificarTransmicao(Transmicao transmicao) throws Exception {
		
		try {
			
			this.entityManager.merge(transmicao);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Transmicão");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Transmicao> listarTransmicao() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Transmicao t");
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<Transmicao>();
			
		}
		
	}
	
}
