/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonia;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author hernanBeiza
 */
public class main {
    /**
     * Companias de teléfono registradas en el sistema
     */
    private static ArrayList <Compania> companias = new ArrayList<Compania>();
    /**
     * Planes de teléfono registrados en el sistema
     */
    private static ArrayList <PlanTelefonico> planes = new ArrayList<PlanTelefonico>();
    /**
     * Usuarios registrados en el sistema
     */
    private static ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
    /**
     * Teléfonos móviles registrados en el sistema
     */
    private static ArrayList <Movil> moviles = new ArrayList<Movil>();
    /**
     * Teléfonos fijos registrados en el sistema
     */
    private static ArrayList <Fijo> fijos = new ArrayList<Fijo>();
    /**
     * Módelos iOS registrados en el sistema
     */
    private static String[] modelosIOS = {"1","2","3","4","5","6"};
    /**
     * Marcas Android registradas en el sistema
     */
    private static String[] marcasAndroid = {"Samsung","Huawei","OWN"};
    /**
     * Tipos de teléfonos tradicionales
     */
    private static String[] tipos = {"Almeja","Normal","Slice"};
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        /*
        0. Tener companias y planes por defecto
        Crear compañia
        Crear planes
        */
        Compania movistar = new Compania("70123456-1", "MOVISTAR", "ESPAÑA");
        Compania entel = new Compania("70234543-2", "ENTEL", "CHILE");
        companias.add(movistar);
        companias.add(entel);
        Iterator it = companias.iterator();
        while(it.hasNext()){
            Compania unaCompania = (Compania)it.next();
            System.out.println(unaCompania.toString());
        }        

        PlanTelefonico economico = new PlanTelefonico("ABC123", "ECONOMICO", "RODRIGO", 10, true);
        PlanTelefonico normal = new PlanTelefonico("ABC123", "NORMAL", "RODRIGO", 50, true);
        PlanTelefonico premium = new PlanTelefonico("ABC123", "PREMIUM", "HERNAN", 100, true);
        planes.add(economico);
        planes.add(normal);
        planes.add(premium);
        it = planes.iterator();
        while(it.hasNext()){
            PlanTelefonico unPlan = (PlanTelefonico)it.next();
            System.out.println(unPlan.toString());
        }

        /**
        1.Agregar fono
        * Crear usuario
        * Pedir Datos
        *   Pedir numero, para ver si es movil o fijo
        *       Crear fijo o móvil
        *           Si es móvil
                *       pedir sistema oeprativo
                *       si es iphone, modelo
                *       si es android, marca
                *       pedir que plan desea
                *       crear móvil finalmente
                *   
         */
        JOptionPane.showMessageDialog(null, "Agregar Usuario");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre").toUpperCase();
        String apellido= JOptionPane.showInputDialog("Ingrese apellido").toUpperCase();
        String run= JOptionPane.showInputDialog("Ingrese run").toUpperCase();
        String fechaNacimiento= JOptionPane.showInputDialog("Ingrese fecha de nacimiento");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
        String estadoCivil = JOptionPane.showInputDialog("Ingrese estado civil").toUpperCase();
        
        Usuario miUsuario = new Usuario(nombre, apellido, run, fechaNacimiento, edad, estadoCivil);
        usuarios.add(miUsuario);
        it = usuarios.iterator();
        while(it.hasNext()){
            Usuario unUsuario = (Usuario)it.next();
            System.out.println(unUsuario.toString());
        }
    
        
        
        
        
        
        
        /*
        String numeroTelefono= JOptionPane.showInputDialog("Ingrese el número del usuario: " + miUsuario.getRun());
        if(revisarNumero(numeroTelefono)){
            //Existe en la DB, no se puede crear
            System.out.println("Número de teléfono ya existe");
        } else {
            System.out.println("Número de teléfono no existe");
            if(esMovil(numeroTelefono)){
                //Pedir datos de móvil
                //...
                //Luego crear el tipo de móvil
                String[] tipos = new String[2];
                tipos[0]="Smartphone";
                tipos[1]="Tradicional";
                
                int tipoMovil = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "¿Qué tipo de móvil?", //Object message,
                               "Elegir tipo de movil", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               tipos, //Object[] options,
                               tipos[0]);//Object initialValue 
                System.out.println("tipoMovil " + tipos[tipoMovil]);
                //Smartphone
                if(tipoMovil==0){
                    String[] so = new String[2];
                    so[0]="iOS Apple";
                    so[1]="Android";                    
                    int sistema = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "¿Qué SO de Smartphone?", //Object message,
                               "Elegir SO del Smartphone", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               so, //Object[] options,
                               so[0]);//Object initialValue 
                    System.out.println("sistema " + so[sistema]);
                    if(sistema==1){
                        //Android
                        int marca = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "¿Qué marca de Android?", //Object message,
                               "Elegir marca de Android", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               marcasAndroid, //Object[] options,
                               marcasAndroid[0]);//Object initialValue 
                        System.out.println("marca " + marcasAndroid[marca]);
                        
                    } else {
                        //IOS
                        int modelo = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "¿Qué modelo de iPhone?", //Object message,
                               "Elegir modelo de iPhone", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               modelosIOS, //Object[] options,
                               modelosIOS[0]);//Object initialValue 
                        System.out.println("modelo " + modelosIOS[modelo]);
                        //guardar en la db
                    }
                    
                //Tradicional
                } else {
                    int tipo = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "¿Qué tipo de equipo es?", //Object message,
                               "Elegir tipo de equipo tradicional", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               tipos, //Object[] options,
                               tipos[0]);//Object initialValue 
                    System.out.println("tipo " + tipos[tipo]);
                    int color = JOptionPane.showConfirmDialog(null, "¿Tiene pantalla a color?");
                    System.out.println("color " + color);
                }
            } else {
                //Fijo
                
            }
            
        }
        */



    }
    /**
     * Verifica si el teléfono es de un móvil o fijo
     * @param numero del teléfono
     * @return true si es móvil. false si es fijo
     */
    private static boolean esMovil(String numero){
        boolean resultado = false;
        if(numero.startsWith("9", 0) || numero.startsWith("8",0)){
            System.out.println("Es móvil");
            resultado = true;
        } else {
            System.out.println("Es fijo");  
            resultado = false;
        }        
        return resultado;
    }
     /**
     * Busca el número en la DB correspondiente
     * @param numero del teléfono
     * @return true si existe. false si no
     */
    private static boolean revisarNumero(String numero){
        boolean encontrado = false;
        Iterator iterador = null;
        if(esMovil(numero)){
            System.out.println("Buscar en moviles");
            iterador = moviles.iterator();
            while(iterador.hasNext()){
                Movil unMovil = (Movil)iterador.next();
                if(unMovil.getNumeroFono().equals(numero)){
                    encontrado = true;
                    break;
                }
            }            
        } else {
            System.out.println("Buscar en fijos");  
            throw new UnsupportedOperationException("Aún no soportado. Falta que Andrés termine sus clases."); //To change body of generated methods, choose Tools | Templates.
            /*
            iterador = fijos.iterator();
            while(iterador.hasNext()){
                Fijo unFijo = (Fijo)iterador.next();
                //Terminar cuando Andrés tenga la clase lista
                if(unFijo..equals(numero)){
                    encontrado = true;
                    break;
                }
            }            
            */            
        }

        return encontrado;
    }
    
}
