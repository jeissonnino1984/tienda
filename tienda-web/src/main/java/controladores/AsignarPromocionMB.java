
package controladores;

import com.mycompany.ejb.ProductoEJB;
import com.mycompany.ejb.ProductoXPromocionEJB;
import com.mycompany.ejb.PromocionesEJB;
import com.mycompany.entidades.Producto;
import com.mycompany.entidades.ProductoXPromocion;
import com.mycompany.entidades.Promociones;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import utilitarios.Mensajes;


@Named(value = "asignarPromocionMB")
@ViewScoped
public class AsignarPromocionMB implements Serializable{

    @EJB
    ProductoXPromocionEJB productoXPromocionEJB;
    @EJB
    ProductoEJB productoEJB;
    @EJB
    PromocionesEJB promcionesEJB;
    
    Producto producto;
    Promociones promociones;
    
    private List<Producto> listProducto;
    private List<Producto> listProductoSeleccionado;
    private List<Promociones> listPromociones;
    private int promocionSeleccionada;
    private List<ProductoXPromocion> listProductoXPromocion;
    
    private int productoId;
    private int promocionId;
    private Date fechaCrea;
    private int userCrea;
    
    
    @PostConstruct
    public void init(){
    listProducto = productoEJB.findAll();
    listPromociones = promcionesEJB.findAll();
    listProductoXPromocion = productoXPromocionEJB.findAll();
    
            
    }
   
    public AsignarPromocionMB() {
    }
    
    
    public void asignarPromocionProducto() {
        
        try {
            
            for (Producto p : listProductoSeleccionado) {
                System.out.println("promo" + promocionId + "producto" + p.getId());
                productoXPromocionEJB.insertarProductoXPromocion(45, p.getId(), promocionId);
                Mensajes.mensajeINFO("Se asigno la promcion a los procuctos");
                
            }
            
        } catch (Exception e) {
            
            Mensajes.mensajeERROR("Erro en la asignacion" + e);
        }
        
    }
    
    
    
     /*************************************************/

    
    
    public List<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(List<Producto> listProducto) {
        this.listProducto = listProducto;
    }

  
    public List<Promociones> getListPromociones() {
        return listPromociones;
    }

    public void setListPromociones(List<Promociones> listPromociones) {
        this.listPromociones = listPromociones;
    }

   

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(int promocionId) {
        this.promocionId = promocionId;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public int getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(int userCrea) {
        this.userCrea = userCrea;
    }

    public int getPromocionSeleccionada() {
        return promocionSeleccionada;
    }

    public void setPromocionSeleccionada(int promocionSeleccionada) {
        this.promocionSeleccionada = promocionSeleccionada;
    }

    public List<ProductoXPromocion> getListProductoXPromocion() {
        return listProductoXPromocion;
    }

    public void setListProductoXPromocion(List<ProductoXPromocion> listProductoXPromocion) {
        this.listProductoXPromocion = listProductoXPromocion;
    }

    public List<Producto> getListProductoSeleccionado() {
        return listProductoSeleccionado;
    }

    public void setListProductoSeleccionado(List<Producto> listProductoSeleccionado) {
        this.listProductoSeleccionado = listProductoSeleccionado;
    }

  
    
}
