package models.sistemainc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.UsuarioEfika;
import entidades.sistemainc.AtendimentoInc;

@Stateless
public class AtendimentoIncServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarAtendimentoInc(AtendimentoInc atendimentoInc, UsuarioEfika usuarioEfika) throws Exception {
		
		try {
			
			Date date = new Date();
			
			atendimentoInc.setDataRegistro(date);
			
			atendimentoInc.setUsuarioEfika(usuarioEfika);
			
			this.entityManager.persist(atendimentoInc);
			
		} catch (Exception e) {
			
			throw new Exception("Erro ao cadastrar INC");
			
		}
		
	}
	
	public void modificarAtendimentoInc(AtendimentoInc atendimentoInc) throws Exception {
		
		try {
			
			this.entityManager.merge(atendimentoInc);
			
		} catch (Exception e) {

			throw new Exception("Erro modificar INC");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<AtendimentoInc> listarAtendimentoIncDate(Date dataInicio, Date dataFim) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM AtendimentoInc a WHERE a.dataRegistro BETWEEN :param1 AND :param2");
			query.setParameter("param1", dataInicio);
			query.setParameter("param2", dataFim);
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<AtendimentoInc>();
			
		}
		
	}
		
}
