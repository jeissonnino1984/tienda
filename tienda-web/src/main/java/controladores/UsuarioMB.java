
package controladores;

import com.mycompany.ejb.LugaresEJB;
import com.mycompany.ejb.PuntoVentaEJB;
import com.mycompany.ejb.UsuarioXRolEJB;
import com.mycompany.ejb.UsuariosEJB;

import com.mycompany.entidades.Lugares;
import com.mycompany.entidades.PuntoVenta;
import com.mycompany.entidades.UsuarioXRol;

import com.mycompany.entidades.Usuarios;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import utilitarios.Mensajes;


@Named(value = "usuarioMB")
@ViewScoped
public class UsuarioMB implements Serializable{

    @EJB
    UsuariosEJB usuarioEJB;
    @EJB
    PuntoVentaEJB puntoVentaEJB;
    @EJB
    LugaresEJB lugaresEJB;
    @EJB
    UsuarioXRolEJB usuarioXRolEJB;

    private String nombres;
    private String apellidos;
    private Integer telefono;
    private String genero;
    private Integer ciudadId;
    private String direccion;
    private String correo;
    private String clave;
    private Date fechaCrea;
    private int puntoTrabajoId;
    UsuarioXRol usuarioXRol;

    /**
     * ******para llenar el listado del select one menu**
     */
    private int departamentoSeleccionado;

    private Boolean jefeBool;
    private int jefePunto;

    Usuarios usuarios;
    
    private Lugares lugares;
    PuntoVenta puntoVenta;

    private List<Usuarios> ListUsuarios;
   
    private List<Lugares> ListLugaresDEP;
    private List<Lugares> listCiudades;
    private List<PuntoVenta> ListPuntoVenta;
    private Lugares ciudadLocal;
    
    @PostConstruct
    public void inicializar() {
        ListLugaresDEP = lugaresEJB.ListarDepartametos();
        ListPuntoVenta = puntoVentaEJB.listaTodosPuntoVneta();
        ListUsuarios = usuarioEJB.listaTodosUsuarios();
           
    }
    
    public void mostrar () {
    
        System.out.println("lista deaptamentos" + ListLugaresDEP);
    }
   

    public UsuarioMB() {
        
    }
    
    public void crearClienteAsignaRol(){
        
     Usuarios u = crearCliente();
     
    usuarioXRolEJB.insertXIdRolxIdUsuario(setiarFecha(new Date()), u.getId(), 1);
    
    }
    
    public Usuarios crearCliente() {

        try {
             
        usuarios = new Usuarios();
        usuarios.setNombre(nombres);
        usuarios.setApellidos(apellidos);
        usuarios.setCorreo(correo);
        usuarios.setGenero(genero);
        usuarios.setTelefono(telefono);
        usuarios.setDireccion(direccion);
        usuarios.setCiudadResidFk(lugaresEJB.find(ciudadId));
        usuarioEJB.create(usuarios);
        /**********asigno rol por defecto cliente*/
        usuarioXRolEJB.insertXIdRolxIdUsuario(setiarFecha(new Date()), usuarios.getId(), 1);
         Mensajes.mensajeINFO("Cliente se registra con exito");
        return usuarios;
        } catch (Exception e) {
            Mensajes.mensajeERROR("Cliente se registra con exito" + e);
        }
        
        return null;

    }
    
    
     public void crearUsuario() {
        
         
        usuarios = new Usuarios();
        usuarios.setNombre(nombres);
        usuarios.setApellidos(apellidos);
        usuarios.setCorreo(correo);
        usuarios.setGenero(genero);
        usuarios.setTelefono(telefono);
        usuarios.setDireccion(direccion);
        usuarios.setCiudadResidFk(lugaresEJB.find(ciudadId));
        usuarioEJB.create(usuarios);
        System.out.println("se creo");

    }

    public void editarUsuario(Usuarios usuarios) {

        usuarioEJB.edit(usuarios);

    }

    public void borrarUsuario(Usuarios usuarios) {

        usuarioEJB.remove(usuarios);

    }

   public Date setiarFecha(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        return date;
    }

    public void listarCiudad() {
        listCiudades = lugaresEJB.ListarCiudades(departamentoSeleccionado);
    }

    

//    public void addMessage() {
//        jefePunto = jefeBool ? 1 : 0;
//    }

    public void checkJefe(boolean b) {

        if (b == true) {
            jefePunto = 1;
        } else {
            jefePunto = 0;
        }
    }
    
     /******************************************************************************/
    

    
    
    
    public int getJefePunto() {
        return jefePunto;
    }

    public void setJefePunto(int jefePunto) {
        this.jefePunto = jefePunto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getPuntoTrabajoId() {
        return puntoTrabajoId;
    }

    public void setPuntoTrabajoId(int puntoTrabajoId) {
        this.puntoTrabajoId = puntoTrabajoId;
    }

    public int getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(int departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

    public Boolean getJefeBool() {
        return jefeBool;
    }

    public void setJefeBool(Boolean jefeBool) {
        this.jefeBool = jefeBool;
    }

    public List<Usuarios> getListUsuarios() {
        return ListUsuarios;
    }

    public void setListUsuarios(List<Usuarios> ListUsuarios) {
        this.ListUsuarios = ListUsuarios;
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

    public List<PuntoVenta> getListPuntoVenta() {
        return ListPuntoVenta;
    }

    public void setListPuntoVenta(List<PuntoVenta> ListPuntoVenta) {
        this.ListPuntoVenta = ListPuntoVenta;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

  
}
