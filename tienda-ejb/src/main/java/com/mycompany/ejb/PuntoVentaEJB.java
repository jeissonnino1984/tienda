/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.PuntoVenta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class PuntoVentaEJB extends AbstractEJB<PuntoVenta>  {

    @PersistenceContext(unitName = "com.mycompany_tienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuntoVentaEJB() {
        super(PuntoVenta.class);
    }
    
    public List<PuntoVenta> listaTodosPuntoVneta(){
    Query q = em.createQuery("SELECT e FROM PuntoVenta e WHERE e.estado = 1 ");
    return  (List<PuntoVenta>) q.getResultList();
        
    }
}
