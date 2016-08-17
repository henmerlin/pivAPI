package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Produto;

@Stateless
public class ProdutoServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarProduto(Produto produto) throws Exception {
		
		try {
			
			this.entityManager.persist(produto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar Produto");
			
		}
		
	}
	
	public void modificarProduto(Produto produto) throws Exception {
		
		try {
			
			this.entityManager.merge(produto);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao modificar Produto");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listarProduto() {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM Produto p");
			return query.getResultList();
			
		} catch (Exception e) {
		
			return new ArrayList<Produto>();			
			
		}
		
	}
	
}