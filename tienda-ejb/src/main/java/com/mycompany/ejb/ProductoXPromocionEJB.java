/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.ProductoXPromocion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class ProductoXPromocionEJB extends AbstractEJB<ProductoXPromocion> {

    @PersistenceContext(unitName = "com.mycompany_tienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoXPromocionEJB() {
        super(ProductoXPromocion.class);
    }
    
      
    public void insertarProductoXPromocion(int userCrea, int productoId, int promocionId){
    
        try {

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO PRODUCTO_X_PROMOCION (ID, FECHA_CREA, USER_CREA, PRODUCTO_FK, PROMOCION_FK)");
            sb.append("VALUES (SEC_PRODUCTO_PROMOCION.NEXTVAL, SYSDATE, ?1, ?2, ?3) ");
            Query q = em.createNativeQuery(sb.toString());
            q.setParameter(1, userCrea);
            q.setParameter(2, productoId);
            q.setParameter(3, promocionId);
            q.executeUpdate();
            System.out.println("regitro exito en EJB");
        } catch (Exception e) {
            System.out.println("regitro fallo en EJB" + e);
        }
    
    
    }
    
}
