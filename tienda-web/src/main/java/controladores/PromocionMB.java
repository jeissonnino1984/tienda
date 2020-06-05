
package controladores;

import com.mycompany.ejb.PromocionesEJB;
import com.mycompany.entidades.Promociones;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "promocionMB")
@ViewScoped
public class PromocionMB implements Serializable{

    @EJB
PromocionesEJB promocionesEJB;

private Date fechaInicio;
private Date fechaFin;
private int porcentDescuento;
private int estado;
private int userCrea;
private String nombre;
private String condiciones;
private String promocionId;

Promociones promociones;

private List<Promociones> listPromociones;
    
    public PromocionMB() {
        estado = 1;
    }
    
    @PostConstruct
    public void inicilizar(){
    listPromociones = promocionesEJB.findAll();
    }
    
     
    public void crearPromocion(){
    promociones = new Promociones();
    promociones.setNombre(nombre);
    promociones.setCondiciones(condiciones);
    promociones.setFechaInicio(setiarFecha(fechaInicio));
    promociones.setFechaTermina(setiarFecha(fechaFin));
    promociones.setPorcentajeDes(porcentDescuento);
    promociones.setEstado(estado);
    promocionesEJB.create(promociones);
    System.out.println("registro creado");
    }
    
    public void borrarPromocion(Promociones promociones){
    
        promocionesEJB.remove(promociones);
         System.out.println("registro borrado");
    }
    
    public void editarPromocion(Promociones promociones){
    
        promocionesEJB.edit(promociones);
    }
    
     public Date setiarFecha(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
                return date;
	}
     
      
     /**********************************************************************************************************/
     

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPorcentDescuento() {
        return porcentDescuento;
    }

    public void setPorcentDescuento(int porcentDescuento) {
        this.porcentDescuento = porcentDescuento;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(String condiciones) {
        this.condiciones = condiciones;
    }

    public String getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(String promocionId) {
        this.promocionId = promocionId;
    }

    public List<Promociones> getListPromociones() {
        return listPromociones;
    }

    public void setListPromociones(List<Promociones> listPromociones) {
        this.listPromociones = listPromociones;
    }
    
     
     
}
