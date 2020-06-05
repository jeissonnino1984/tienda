/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejb;

import com.mycompany.entidades.UsuarioXRol;
import java.util.Date;
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
public class UsuarioXRolEJB extends AbstractEJB<UsuarioXRol>{

    @PersistenceContext(unitName = "com.mycompany_tienda-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioXRolEJB() {
        super(UsuarioXRol.class);
    }
    
    
      /************************************QUERY INSERT  A USUARIO_X_ROL*******************************************/

    public void insertXIdRolxIdUsuario(Date fechaCrea, int idUser, int idRol) {
        
        try {

            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO USUARIO_X_ROL (ID, FECHA_CREA, USER_CREA, ROL_PK, USUARIO_FK)");
            sb.append("VALUES (SEC_USUARIO_X_ROL.NEXTVAL, ?1, 45, ?3, ?4) ");
            Query q = em.createNativeQuery(sb.toString());
            q.setParameter(1, fechaCrea);
            q.setParameter(3, idRol);
            q.setParameter(4, idUser);
            q.executeUpdate();
            System.out.println("regitro exito en EJB");
        } catch (Exception e) {
            System.out.println("regitro fallo en EJB" + e);
        }

    }
    
//    /************************************lista user clientes******************/
//    
//    public List<UsuarioXRol> listarTodosUsuariosClientesNativeQuery(Integer a) {
//       try {
//            StringBuilder sb = new StringBuilder();
//            sb.append("SELECT e.ID, e.ROL_PK, e.USUARIO_FK FROM USUARIO_X_ROL e");
//            sb.append(" WHERE e.ROL_PK = ?1");
//            Query q = em.createNativeQuery(sb.toString());
//            q.setParameter(1, a);
//            System.out.println("listado en EJB" + (List<UsuarioXRol>) q.getResultList());
//            return (List<UsuarioXRol>) q.getResultList();
//       } catch (Exception e) {
//           System.out.println("error--------" + e);
//       }
//       
//      return null;
//   }
//    
//    public List<UsuarioXRol> listaclientes() {
//
//        try {
//            Query nativeQuery = em.createNativeQuery("SELECT e.ID, e.ROL_PK, e.USUARIO_FK FROM USUARIO_X_ROL e WHERE e.ROL_PK = 1");
//            List<UsuarioXRol> results = nativeQuery.getResultList();
//            System.out.println("lista en EJB" + results);
//            return results;
//        } catch (Exception e) {
//            System.out.println("error-----" + e);
//        }
//        return null;
//    }
     
 public List<UsuarioXRol> listaclientes1(Integer rolId) {
        try {
            Query qr = em.createQuery("SELECT e FROM UsuarioXRol e WHERE e.rolPk.id = ?1");
            qr.setParameter(1, rolId);
            return (List<UsuarioXRol>) qr.getResultList();
        } catch (Exception e) {
            System.out.println("error-----" + e);
            return null;
        }
    }
    
    
     /**
     * @return *************************************************************************/
//   public List<UsuarioXRol> listarUsuariosClientesNative() {
//
//        try {
//
//            StringBuilder sb = new StringBuilder();
//            sb.append("SELECT A.* FROM USUARIO_X_ROL A");
//            sb.append(" WHERE A.ROL_PK = ?1");
//            Query q = em.createNativeQuery(sb.toString());
//            q.setParameter(1, 1);   /* el rol 1 es de cliente*/
//            System.out.println(" listado EJB-------------" + q.getResultList());
//            List<UsuarioXRol> lista = (List<UsuarioXRol>) q.getResultList();
//            return lista;
//
//        } catch (Exception e) {
//            System.out.println("fallo " + e);
//        }
//        return null;
//    } 
 
//   public List<UsuarioXRol> listarTodosUsuariosClientesQuery(Integer a) {
//       try {
//            StringBuilder sb = new StringBuilder();
//            sb.append("SELECT e FROM UsuarioXRol e WHERE e. = ?1");
//            Query q = em.createQuery(sb.toString());
//            q.setParameter(1, a); /* 1 ES CLIENTE EN LA TABLA DE ROLES*/
//            System.out.println("listado en EJB" + (List<UsuarioXRol>) q.getResultList());
//            return  (List<UsuarioXRol>) q.getResultList();
//       } catch (Exception e) {
//           System.out.println("error--------" + e);
//       }
//       
//      return null;
//   }
//   
   
   
}
