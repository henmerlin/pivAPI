package portalefika.comunicao.dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import portalefika.comunicao.entidades.Enquete;

/**
 *
 * @author G0034481
 */
public class EnqueteDAO extends ComponentePortalDAO {

    public List<Enquete> listarTodasEnquetes() {

        try {

            Query query = this.entityManager.createQuery("FROM Enquete e");
            return query.getResultList();

        } catch (Exception e) {

            return new ArrayList<Enquete>();

        }

    }

    public List<Enquete> listarEnquetesAtivo() {

        try {

            Date date = new Date();

            Query query = this.entityManager.createQuery("FROM Enquete e WHERE e.ativo =:param1 AND e.dataFim < :param2");
            query.setParameter("param1", true);
            query.setParameter("param2", date);

            return query.getResultList();

        } catch (Exception e) {

            return new ArrayList<Enquete>();

        }

    }

}
