/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.Lugares;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class LugaresEJB extends AbstractEJB<Lugares> {

    @PersistenceContext(unitName = "com.mycompany_tienda-ejb_ejb_1.0-SNAPSHOTPU")
   
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LugaresEJB() {
        super(Lugares.class);
    }

    /**
     * *********listar deaprtamento
     *
     * @return s************
     */
    public List<Lugares> ListarDepartametos() {
        return (List<Lugares>) em.createQuery("SELECT e FROM Lugares e WHERE e.tipo = 'DE' ").getResultList();
    }

    /**
     * *********listas ciudades de acuerdo a papa
     *
     * @param id
     * @return ************
     */
    public List<Lugares> ListarCiudades(int id) {
        Query q = em.createQuery("SELECT e FROM Lugares e WHERE e.lugePapa = ?1 ");
        q.setParameter(1, id);
        return (List<Lugares>) q.getResultList();
    }

     /**
     * *********listas ciudades por id
     *
     * @param id
     * @return ************
     */
    public Lugares consultarCiudadPorId(int id) {
        Query q = em.createQuery("SELECT e FROM Lugares e WHERE e.codigo = ?1");
        q.setParameter(1, id);
        try {
            return (Lugares) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
