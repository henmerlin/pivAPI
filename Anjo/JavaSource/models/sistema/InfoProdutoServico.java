package models.sistema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.sistema.InfoProduto;

@Stateless
public class InfoProdutoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarInfoProduto(InfoProduto infoProduto) throws Exception {

		try {

			this.entityManager.persist(infoProduto);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Informa��es do Produto");

		}

	}

	public void modificarInfoProduto(InfoProduto infoProduto) throws Exception {

		try {

			this.entityManager.merge(infoProduto);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Informa��es do Produto");

		}

	}

}
