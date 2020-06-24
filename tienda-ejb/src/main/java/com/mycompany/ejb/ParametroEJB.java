/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.Parametro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class ParametroEJB extends AbstractEJB<Parametro>  {

    @PersistenceContext(unitName = "com.mycompany_tienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParametroEJB() {
        super(Parametro.class);
    }
    
    public Parametro rutaImagenProducto(){
    Query qr = em.createQuery("SELECT c FROM Parametro c WHERE c.nombre =  'RUTA_IMAGEN'");
    return (Parametro) qr.getSingleResult();
    }
    
}
