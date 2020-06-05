
package controladores;

import com.mycompany.ejb.SkuEJB;
import com.mycompany.entidades.Sku;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

@Named(value = "skuMB")
@ViewScoped
public class SkuMB implements Serializable{

    @EJB
    SkuEJB skuEJB;
    
   private String referencia; 
   private int estado;
   private int userCrea;
   private int userEdita;
   private String descripcion;
   private Date fechaCrea;
   private Date fechaEdita;
   
   Sku sku;
   
   private List<Sku> listSku;
   

    public SkuMB() {
        estado = 1;
    }
    
    @PostConstruct
    public void init(){
        listSku = skuEJB.findAll();
    }

    public void crearSku() {
        sku = new Sku();
        sku.setDescripcionReferencia(descripcion);
        sku.setEstado(estado);
        sku.setFechaCrea(setiarFecha(new Date()));
        sku.setReferencia(referencia);
        skuEJB.create(sku);
        System.out.println("se creo registro");
    }

    public void editarSku(Sku sku) {

        skuEJB.edit(sku);
        System.out.println("se edito registro");
    }

    public void borrarSku(Sku sku) {
        skuEJB.remove(sku);
         System.out.println("se borra registro");
    }
    

    public Date setiarFecha(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        return date;
    }
    
    /****************************************************************************************/

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getUserCrea() {
        return userCrea;
    }

    public void setUserCrea(int userCrea) {
        this.userCrea = userCrea;
    }

    public int getUserEdita() {
        return userEdita;
    }

    public void setUserEdita(int userEdita) {
        this.userEdita = userEdita;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaEdita() {
        return fechaEdita;
    }

    public void setFechaEdita(Date fechaEdita) {
        this.fechaEdita = fechaEdita;
    }

    public List<Sku> getListSku() {
        return listSku;
    }

    public void setListSku(List<Sku> listSku) {
        this.listSku = listSku;
    }
    
    
    
    
}
