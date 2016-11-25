package portalefika.comunicao.dal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.entities.EntityCrudInterface;
import portalefika.comunicao.entidades.ComponentePortal;

@Stateless
public class ComponentePortalDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    public void cadastrar(ComponentePortal param1) {
        this.entityManager.persist(param1);
    }

    public void editar(ComponentePortal param1) {
        this.entityManager.merge(param1);
    }

    public void excluir(ComponentePortal param1) {
        this.entityManager.remove(this.entityManager.merge(param1));
    }

    public ComponentePortal buscarPorId(ComponentePortal ob) {

        try {
            Query query = this.entityManager.createQuery("FROM " + ob.getClass().getSimpleName() + " m WHERE m.id =:param1");
            query.setParameter("param1", ob.getId());
            return (ComponentePortal) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
