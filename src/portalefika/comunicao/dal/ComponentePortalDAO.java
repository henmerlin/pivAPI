package portalefika.comunicao.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import portalefika.comunicao.entidades.ComponentePortal;

@Stateless
public class ComponentePortalDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    public ComponentePortalDAO() {
    }

    public void cadastrar(ComponentePortal param1) {
        this.entityManager.persist(param1);
    }

    public void editar(ComponentePortal param1) {
        this.entityManager.merge(param1);
    }

    public void excluir(ComponentePortal param1) {
        this.entityManager.remove(this.entityManager.merge(param1));
    }

    public List<ComponentePortal> listar(ComponentePortal a) {
        try {
            return (List<ComponentePortal>) this.entityManager.createQuery("SELECT a FROM " + a.getClass().getSimpleName() + " a", a.getClass()).getResultList();
        } catch (Exception e) {
            return new ArrayList<ComponentePortal>();
        }
    }

    public ComponentePortal buscarPorId(ComponentePortal ob) {

        try {
            Query query;
            query = this.entityManager.createQuery("SELECT a FROM " + ob.getClass().getSimpleName() + " a WHERE a.id =:param1", ob.getClass());
            query.setParameter("param1", ob.getId());
            return (ComponentePortal) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
