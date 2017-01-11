/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import javax.persistence.Query;
import model.entitiy.IndicadoresOperador;

public class IndicadoresOperadorDAO extends AbstractDAO {

    public IndicadoresOperadorDAO() {
    }

    public IndicadoresOperador buscaPorLoginOperador(IndicadoresOperador i) {

        try {
            Query query;
            query = this.entityManager.createQuery("FROM " + i.getClass().getSimpleName() + " m WHERE m.loginOperador =:param1", i.getClass());
            query.setParameter("param1", i.getLoginOperador());
            return (IndicadoresOperador) query.getSingleResult();
        } catch (Exception e) {
            System.out.println(e.getCause());
            return null;
        }

    }

}
