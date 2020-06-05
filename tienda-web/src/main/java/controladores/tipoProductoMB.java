
package controladores;


import com.mycompany.ejb.TipoProductoEJB;
import com.mycompany.entidades.TipoProducto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;
import utilitarios.Mensajes;



@Named(value = "tipoProductoMB")
@ViewScoped
public class tipoProductoMB implements Serializable{
    
    @EJB
    TipoProductoEJB tipoProductoEJB;
 
    private int idTiproducto;
    private String producto;
    TipoProducto tipoProducto;
    private int estado;
    private boolean estadobool;
    int tipoId;
    
  

    //listado
    private List<TipoProducto> listTipoProducto;
    private List<TipoProducto> FiltradolistTipoProducto;
    
    
    public tipoProductoMB() { 
    estado = 1;
    }

    @PostConstruct
    private void inicializar() {
       listTipoProducto = tipoProductoEJB.findAll();
       
    }

    public tipoProductoMB(int idTiproducto, String producto) {
        this.idTiproducto = idTiproducto;
        this.producto = producto;
    }
    
    
    public void createTipoProducto(){
        List<TipoProducto> a =  tipoProductoEJB.BuscarTipoProductoXtipo(producto.toUpperCase());
        tipoProducto = new TipoProducto();
        if(producto.isEmpty()){
            System.out.println("No puede se nulo el registro");
        }if (a.size()> 0) {
             Mensajes.mensajeWARN("ya existe el tipo de producto");
        }else{
         tipoProducto.setTipo(producto.toUpperCase());
         tipoProducto.setEstado(estado);
         tipoProductoEJB.create(tipoProducto);
         Mensajes.mensajeINFO("Se crea el tipo de producto");
       
        }
    }
 
    public void editarTipoSoporte(TipoProducto tipoProducto) {
        
        tipoProductoEJB.edit(tipoProducto);
        System.out.println("registro actualizado");

    }
 
   
    /******hola********/
//public void convertirBoleanAnumber() {
//
//        if (estadobool = true) {
//            estado = 1;
//        } else {
//            estado = 0;
//        }
//
//    }
//    
//     public void editEstado(){
//         estado();
//         try {
//             tipoProductoEJB.editarEstado(estado, tipoId);
//             Mensajes.mensajeINFO("Se edito estado correctamente");
//         } catch (Exception e) {
//             Mensajes.mensajeERROR("error al editar" + e);
//         }
//         
//    }

    public void eliminarTipoSoporte(TipoProducto tipoProducto ) {
        
        tipoProductoEJB.remove(tipoProducto);
        System.out.println("registro borrado");
                
    }
    
    public void limpiarVariables(){
    
    tipoProducto = null;
    
    }
    
//    public void estado(){
//        System.out.println("estado" + estado + " - " + estadobool );
//    }
//   
//    
    
    
    
    /*get y set*/
    
    
 
    public int getIdTiproducto() {
        return idTiproducto;
    }

    public void setIdTiproducto(int idTiproducto) {
        this.idTiproducto = idTiproducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
   


    public List<TipoProducto> getListTipoProducto() {
        return listTipoProducto;
    }

    public void setListTipoProducto(List<TipoProducto> listTipoProducto) {
        this.listTipoProducto = listTipoProducto;
    }

   

    public List<TipoProducto> getFiltradolistTipoProducto() {
        return FiltradolistTipoProducto;
    }

    public void setFiltradolistTipoProducto(List<TipoProducto> FiltradolistTipoProducto) {
        this.FiltradolistTipoProducto = FiltradolistTipoProducto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isEstadobool() {
        return estadobool;
    }

    public void setEstadobool(boolean estadobool) {
        this.estadobool = estadobool;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

   
  
}
