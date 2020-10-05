
package controladores;

import com.mycompany.ejb.LugaresEJB;
import com.mycompany.ejb.PuntoVentaEJB;
import com.mycompany.ejb.UsuariosEJB;
import com.mycompany.entidades.Lugares;
import com.mycompany.entidades.PuntoVenta;
import com.mycompany.entidades.Usuarios;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "puntosVentaMB")
@ViewScoped
public class PuntosVentaMB implements Serializable{

    @EJB
    PuntoVentaEJB puntoVentaEJB;
    @EJB
    UsuariosEJB usuariosEJB;
    @EJB
    LugaresEJB lugaresEJB;
    
    private String nombre;
    private int ciudadId;
    private String direccion;
    private int usuarioCrea;
    private Date fechaCrea;
    private int jefeId;
    private int estado;
    private int departamentoSeleccionado;
    
    PuntoVenta puntoVenta;
    private Usuarios usuarios;
    Lugares lugares;
            
    
    private List<Usuarios> listUsuarios;
    private List<Lugares> ListLugaresDEP;
    private List<Lugares> listCiudades;
    private List<PuntoVenta> listPuntoVenta;

    
    public PuntosVentaMB() {
       

    }
    
    @PostConstruct
    public void inicializar() {
        estado = 1;
        ListLugaresDEP = lugaresEJB.ListarDepartametos();
        listPuntoVenta = puntoVentaEJB.findAll();

    }
    
      public PuntosVentaMB(String nombre, int ciudadId, String direccion,  int usuarioCrea, Date fechaCrea, int jefeId) {
        this.nombre = nombre;
        this.ciudadId = ciudadId;
        this.direccion = direccion;
        this.usuarioCrea = usuarioCrea;
        this.fechaCrea = fechaCrea;
        this.jefeId = jefeId;
    }
    
    
    public void crearPuntoVenta(){
        puntoVenta = new PuntoVenta();
        puntoVenta.setCiudadFk(lugaresEJB.find(ciudadId));
        puntoVenta.setNombrePunto(nombre);
        puntoVenta.setDireccion(direccion);
        puntoVenta.setEstado(estado);
        puntoVenta.setFechaCrea(new Date());
        puntoVenta.setJefeFk(usuariosEJB.find(jefeId));
        puntoVentaEJB.create(puntoVenta);
        System.out.println("se creo registro");
     
    }
    
     public void editarPuntoVenta(PuntoVenta puntoVenta){
    
         puntoVentaEJB.edit(puntoVenta);
         
    }
     
     
     public void borrarPuntoVenta(PuntoVenta puntoVenta){
    
          puntoVentaEJB.remove(puntoVenta);
         
    }
     
     public void listarCiudad() {
        listCiudades = lugaresEJB.ListarCiudades(departamentoSeleccionado);
    }
     
     /***********************************************************************************************/
     

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(int ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(int usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public int getJefeId() {
        return jefeId;
    }

    public void setJefeId(int jefeId) {
        this.jefeId = jefeId;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Usuarios> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuarios> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    

    public List<PuntoVenta> getListPuntoVenta() {
        return listPuntoVenta;
    }

    public void setListPuntoVenta(List<PuntoVenta> listPuntoVenta) {
        this.listPuntoVenta = listPuntoVenta;
    }

    public List<Lugares> getListLugaresDEP() {
        return ListLugaresDEP;
    }

    public void setListLugaresDEP(List<Lugares> ListLugaresDEP) {
        this.ListLugaresDEP = ListLugaresDEP;
    }

    public List<Lugares> getListCiudades() {
        return listCiudades;
    }

    public void setListCiudades(List<Lugares> listCiudades) {
        this.listCiudades = listCiudades;
    }

    public int getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(int departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }
     
     
     
    
}
