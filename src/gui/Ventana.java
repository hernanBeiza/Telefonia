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
<<<<<<< HEAD
    public String TransformaMayuscula(String Dato){
         String Aux = "" ; 
         Aux+=String.valueOf(Dato).toUpperCase();
         return (Aux);
    }
    /**
     * Retorna si es un String está compuesto de números
     * @param s cadena a evaluar
     * @return true si es número, false si es string
     */
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }
    private static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
    public boolean isLetters(String name) {
        return name.matches("[a-zA-Z]+");
    }

=======
>>>>>>> origin/master
}