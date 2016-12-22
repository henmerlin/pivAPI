/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portalefika.comunicao.dal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import portalefika.comunicao.entidades.Banner;
import portalefika.comunicao.entidades.BannerLocal;

/**
 *
 * @author G0034481
 */
public class BannerDAO extends ComponentePortalDAO {

    public List<Banner> listarTodos() {

        try {
            Query query = this.entityManager.createQuery("FROM Banner b");
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<Banner> listarBannerLocal(BannerLocal bannerLocal) {
        try {
            Query query = this.entityManager.createQuery("FROM Banner b WHERE b.local =:param1 AND b.ativo =:param2 AND CURRENT_TIMESTAMP BETWEEN b.dataInicio AND b.dataFim");
            query.setParameter("param1", bannerLocal);
            query.setParameter("param2", true);
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
