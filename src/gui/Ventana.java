/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import telefonia.Usuario;
import telefonia.DB;
import telefonia.PlanTelefonico;
import telefonia.Compania;
import telefonia.Telefonia;

/** Clase de la cual las ventanas flotantes heredan. Permite el control de la posición inicial y la interacción con la DB ubicada en el MainFrame
 *
 * @author hernanBeiza
 */
public class Ventana extends JFrame{
    
    /**
     * Inicia la ventana centrada
     */
    protected void iniciarCentrada(){
        this.setAlwaysOnTop(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    /**
     * Retorna la instancia de la DB en el MainFrame
     * @return DB
     */
    private DB obtenerDB (){
        MainFrame frame = (MainFrame)JFrame.getFrames()[0];
        //System.out.println(frame.getDb().getCompanias());
        return frame.getDb();
    }
    /**
     * Obtener los usuarios desde la DB
     * @return ArrayList de tipo usuario con los usuarios ingresados al sistema
     */
    protected ArrayList <Usuario> obtenerUsuarios(){
        MainFrame frame = (MainFrame)JFrame.getFrames()[0];
        //System.out.println(frame.getDb().getCompanias());
        return frame.getDb().getUsuarios();
    }
    /**
     * Guarda un usuario en la db  
     * @param unUsuario del tipo Usuario a guardar
     * @return true si se guardó correcamente. false en caso contrario (existe un usuario con el mismo rut previamente
     */
    protected boolean usuarioGuardar (Usuario unUsuario){
        boolean estado = false;
        System.out.println(unUsuario.toString());
        if(obtenerDB().usuarioGuardar(unUsuario)){
            estado = true;
        } else {
            estado = false;
        }
        
        return estado;
    }
    /**
     * Retorna la lista de planes telefónicos disponibles en el sistema
     * @return ArrayList de tipo PlanTelefónico. size(9 = 0 en caso de no tener nada
     */
    protected ArrayList <PlanTelefonico> obtenerPlanes(){
        MainFrame frame = (MainFrame)JFrame.getFrames()[0];
        //System.out.println(frame.getDb().getCompanias());
        return frame.getDb().getPlanes();
    }

    /**
     * Guarda una compañía en el sistema
     * @param unaCompania Instancia de Compania. 
     * @return true si se guarda correctamente. false en caso contrario (ya existe una compañía con el mismo rut)
     */
    protected boolean companiaGuardar (Compania unaCompania){
        boolean estado = false;
        System.out.println(unaCompania.toString());
        if(obtenerDB().companiaGuardar(unaCompania)){
            estado = true;
        } else {
            estado = false;
        }        
        return estado;
    }
    
    protected boolean telefonoBorrar (Telefonia elTelefono){
        if(this.obtenerDB().getTelefonos().remove(elTelefono)){
            return true;
        } else {
            return false;
        }
    }
    

}
