

package utilitarios;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;


public class Mensajes {
    
  
    
    public static void mensajeINFO(String mensaje){
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, "detalle"));
    } 
    
     public static void mensajeERROR(String mensaje){
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, "detalle"));
    } 
    
    public static void mensajeFATAL(String mensaje){
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL, mensaje, "detalle"));
    }
   
    public static void mensajeWARN(String mensaje){
    FacesContext context = FacesContext.getCurrentInstance();
    context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, "detalle"));
    }
    
    
//    
//    public static String getMensaje(String resourceBundleKey) {
//
//        try {
//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, "bundle");
//            return bundle.getString(resourceBundleKey);
//        } catch (Exception e) {
//            mostrarMensajeError(e.getMessage());
//            e.printStackTrace();
//        }
//        return "N/E";
//    }

    /**
     * Presenta en pantalla el mensaje
     *
     * @param mensaje
     */
//    public static void mostrarMensajeInfo(String mensaje) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, "");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//
//    }

    /**
     * Presenta en pantalla el mensaje
     *
     * @param mensaje
     */
//    public static void mostrarMensajeError(String mensaje) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, "");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//
//    public static void mostrarMensajeError(String mensaje, Class clase) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, "");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        Logger.getLogger(clase.getName()).log(Level.SEVERE, mensaje);
//    }

//    public static void mostrarMensajeAdvertencia(String titulo, String descripcion) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, descripcion);
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    
//    public static void mostrarMensajeAdvertencia(String descripcion) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, descripcion, "");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }

    /**
     * Presenta en pantalla el mensaje funcional y en el logger el error tecnico
     *
     * @param e
     * @param clase
     */
//    public static void mostrarMensajeError(ExcepcionMesaAyuda e, Class clase) {
//        //TODO En produccion unicamente se debe presentar el error funcional (no el message) y el tecnico al logger
//        FacesMessage msg = null;
//        msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getErrorFuncional(), "");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        if (e.getExcepcionOrigen() != null) {
//            System.out.println(e.getErrorTecnico());
//        }
//        Logger.getLogger(clase.getName()).log(Level.SEVERE, e.getErrorTecnico(), e);
//    }

    /**
     * Muestra mensaje de excepciones no manejadas, escribe en el logger parte
     * del stack trace del error
     *
     * @param clase
     * @autor Ivan Viasus
     * @param e Excepcion generada
     */
//    public static void mostrarMensajeErrorNoManejado(Throwable e, Class clase) {
//        String mensaje = "Error no manejado, consulte con el administrador : " + e.getMessage() + ". ";
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, "");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//        Logger.getLogger(clase.getName()).log(Level.SEVERE, null, e);
//    }

    /**
     * Se visualiza el mensaje en un popup de dialogo
     *
     * @param mensaje
     */
//    public static void mostrarMensajeDialogo(String mensaje) {
//        FacesMessage message;
//        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", mensaje);
//        RequestContext.getCurrentInstance().showMessageInDialog(message);
//    }
//    
//    public static void mostrarMensajeError1(String mensaje) {
//        FacesMessage message;
//        message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", mensaje);
//        RequestContext.getCurrentInstance().showMessageInDialog(message);
//    }
//    
//    public static void mostrarMensajeDialogo(String titulo, String mensaje) {
//        FacesMessage message;
//        message = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje);
//        RequestContext.getCurrentInstance().showMessageInDialog(message);
//    }
    
}
