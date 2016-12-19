package models.sistema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.sistema.InfoEquipamento;

@Stateless
public class InfoEquipamentoServico {

	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;

	public void cadastrarInfoEquipamento(InfoEquipamento infoEquipamento) throws Exception {

		try {

			this.entityManager.persist(infoEquipamento);

		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Informações de Equipamento");

		}

	}

	public void modificarInfoEquipamento(InfoEquipamento infoEquipamento) throws Exception {

		try {

			this.entityManager.merge(infoEquipamento);

		} catch (Exception e) {

			throw new Exception("Erro ao modificar Informações de Equipamento");

		}

	}
	
}
