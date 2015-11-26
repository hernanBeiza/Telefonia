/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import telefonia.DB;

/** Clase de la cual las ventanas flotantes heredan. Permite el control de la posición inicial y la interacción con la DB ubicada en el MainFrame
 *
 * @author hernanBeiza
 */
public abstract class Ventana extends JFrame{
    
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
    public DB obtenerDB (){
        MainFrame frame = (MainFrame)JFrame.getFrames()[0];
        //System.out.println(frame.getDb().getCompanias());
        return frame.getDb();
    }
}