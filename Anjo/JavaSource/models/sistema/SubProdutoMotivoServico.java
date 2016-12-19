package models.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.sistema.Produto;
import entidades.sistema.SubProdutoMotivo;

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
	
	@SuppressWarnings("unchecked")
	public List<SubProdutoMotivo> listarSubProdutoMotivoProdutoEspecifico(Produto produto, Boolean ativo) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM SubProdutoMotivo s WHERE s.produto =:param1 AND s.ativo =:param2 ORDER BY s.nome ASC");
			query.setParameter("param1", produto);
			query.setParameter("param2", ativo);
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<SubProdutoMotivo>();
			
		}
		
	}


}
