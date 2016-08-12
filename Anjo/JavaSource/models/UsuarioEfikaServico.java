package models;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.UsuarioEfika;
import entidades.sistema.Equipe;

@Stateless
public class UsuarioEfikaServico {
	
	@PersistenceContext(unitName = "vu")
	private EntityManager entityManager;
	
	public void cadastrarUsuarioEfika(UsuarioEfika usuarioEfika) throws Exception {
		
		try {
			
			this.entityManager.persist(usuarioEfika);
			
		} catch (Exception e) {

			throw new Exception("Erro ao cadastrar Usuário");
			
		}
		
	}
	
	public void modificarUsuarioEfika(UsuarioEfika usuarioEfika) throws Exception {
		
		try {
			
			this.entityManager.merge(usuarioEfika);
			
		} catch (Exception e) {

			throw new Exception("Erro ao modificar Usuário");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioEfika> listarUsuarioEfikaAtivo(Boolean ativo) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM UsuarioEfika u WHERE u.ativo =:param1");
			query.setParameter("param1", ativo);
			return query.getResultList();
			
		} catch (Exception e) {
			
			return new ArrayList<UsuarioEfika>();			
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioEfika> listarUsuarioEfikaAdm(Boolean adm) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM UsuarioEfika u WHERE u.adm =:param1");
			query.setParameter("param1", adm);
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<UsuarioEfika>();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioEfika> listarUsuarioEfikaEquipe(Equipe equipe) {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM UsuarioEfika u WHERE u.equipe =:param1");
			query.setParameter("param1", equipe);
			return query.getResultList();
			
		} catch (Exception e) {

			return new ArrayList<UsuarioEfika>();
			
		}
		
	}
	
	public UsuarioEfika listarUsuarioEfikaEspecifico(UsuarioEfika usuarioEfika) throws Exception {
		
		try {
			
			Query query = this.entityManager.createQuery("FROM UsuarioEfika u WHERE u.login =:param1");
			query.setParameter("param1", usuarioEfika.getLogin());
			return (UsuarioEfika) query.getSingleResult();
			
		} catch (Exception e) {

			throw new Exception("Usuário não cadastrado");
			
		}
	
	}

}
