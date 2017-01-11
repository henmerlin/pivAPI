/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AbstractDAO {

    @PersistenceContext
    protected EntityManager entityManager;

    public void cadastrar(Object object) {
        this.entityManager.persist(object);
    }

    public void modificar(Object object) {
        this.entityManager.merge(object);
    }

    public void excluir(Object object) {
        this.entityManager.remove(this.entityManager.merge(object));
    }

}
