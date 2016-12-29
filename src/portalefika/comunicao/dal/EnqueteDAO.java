package portalefika.comunicao.dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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

            return new ArrayList<>();

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

            return new ArrayList<>();

        }

    }

    public List<Enquete> listarEnqEsp(List<Enquete> le) {        
        try {            
            if (le.size() > 1) {
                
                le = new ArrayList<Enquete>(new HashSet<Enquete>(le));                
                StringBuilder concat = new StringBuilder();
                int cont = 0;
                for (Enquete enquete : le) {
                    if (cont == 0) {
                        concat.append("e.id != " + enquete.getId() + " ");
                        cont++;
                    } else {
                        concat.append(" AND e.id != " + enquete.getId());
                    }
                }                
                Query query = this.entityManager.createQuery("FROM Enquete e WHERE " + concat.toString());
                return query.getResultList();
            } else {
                Query query = this.entityManager.createQuery("FROM Enquete e");
                return query.getResultList();
            }
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
