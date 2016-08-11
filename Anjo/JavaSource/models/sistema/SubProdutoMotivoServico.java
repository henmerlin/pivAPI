package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SubProdutoMotivoServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarSubProdutoMotivo(SubProdutoMotivo subProdutoMotivo) throws Exception {
		
		try {
			
			this.entityManager.persist(subProdutoMotivo);
			
		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Sub Produto Motivo");
			
		}
		
	}
	
	public void modificaSubProdutoMotivo(SubProdutoMotivo subProdutoMotivo) throws Exception {
		
		try {
			
			this.entityManager.merge(subProdutoMotivo);
			
		} catch (Exception e) {

			throw new Exception("Erro ao modificar Sub Produto Motivo");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<SubProdutoMotivo> listarSubProdutoMotivo() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM SubProdutoMotivo s");
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<SubProdutoMotivo>();
			
		}
		
	}
	
}
