package models;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entidades.UsuarioEfika;
import webservices.EfikaUsersProxy;
import webservices.Usuario;


@Stateless
public class LoginServico {

	@PersistenceContext(unitName="vu")
	private EntityManager entityManager;

	private EfikaUsersProxy efikaUsersProxy;

	public LoginServico() {

		this.efikaUsersProxy = new EfikaUsersProxy();

	}


	public Usuario buscaLoginWS(String login) throws Exception {

		Usuario usuarioWS = efikaUsersProxy.consultarUsuario(login);
				
		if (usuarioWS == null){

			throw new Exception("Usu�rio n�o encontrado, se voc� n�o possui login de acesso utilize a op��o \"Solicite o seu acesso\" na pagina http://efika/web");

		}

		return usuarioWS;		

	}

	public void autenticaLogin(Usuario usuario, String senha) throws Exception {

		Boolean auth = efikaUsersProxy.autenticarUsuario(usuario.getLogin(), senha);

		if (!auth) {

			throw new Exception("Login e senha incorretos, se voc� esqueceu da sua senha utilize a op��o \"Esqueci minha senha\" na pagina http://efika/web");

		}

		this.buscaLogin(usuario);

	}
	
	public void buscaLogin(Usuario usuario) throws Exception {

		try {

			Query query = this.entityManager.createQuery("FROM UsuarioEfika u WHERE u.login =:param1");
			query.setParameter("param1", usuario.getLogin());	

			UsuarioEfika usuarioEfika = (UsuarioEfika) query.getSingleResult();

			if (usuarioEfika.getNivel() != usuario.getNivel()) {

				usuarioEfika.setNivel(usuario.getNivel());

				this.updateLogin(usuarioEfika);

			}else{
				
				
			}

		} catch (Exception e) {

			this.salvaLogin(usuario);

		}

	}	

	public void salvaLogin(Usuario usuario) throws Exception {

		UsuarioEfika usuarioEfika = new UsuarioEfika();

		usuarioEfika.setLogin(usuario.getLogin());
		usuarioEfika.setNivel(usuario.getNivel());		

		this.entityManager.persist(usuarioEfika);

	}

	public void updateLogin(UsuarioEfika usuarioEfika) {		

		this.entityManager.merge(usuarioEfika);		

	}	

}
