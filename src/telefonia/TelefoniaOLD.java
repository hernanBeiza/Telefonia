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
public class TelefoniaOLD implements Cuenta, Impuestos, ServicioTecnico{
    /**
     * Companias de teléfono registradas en el sistema
     */
    private ArrayList <Compania> companias = new ArrayList<Compania>();
    /**
     * Planes de teléfono registrados en el sistema
     */
    private ArrayList <PlanTelefonico> planes = new ArrayList<PlanTelefonico>();
    /**
     * Usuarios registrados en el sistema
     */
    private ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
    /**
     * Teléfonos móviles registrados en el sistema
     */
    private ArrayList <Movil> moviles = new ArrayList<Movil>();
    /**
     * Teléfonos fijos registrados en el sistema
     */
    private ArrayList <Fijo> fijos = new ArrayList<Fijo>();
    
    public TelefoniaOLD() {
        // Necesario para ejecutar
        // Tener ArrayList de Compañia
        // Tener ArrayList de PlanTelefonico

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

    }
    
    public ArrayList<Compania> getCompanias() {
        return companias;
    }

    public void setCompanias(ArrayList<Compania> companias) {
        this.companias = companias;
    }

    public ArrayList<PlanTelefonico> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<PlanTelefonico> planes) {
        this.planes = planes;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Movil> getMoviles() {
        return moviles;
    }

    public void setMoviles(ArrayList<Movil> moviles) {
        this.moviles = moviles;
    }

    public ArrayList<Fijo> getFijos() {
        return fijos;
    }

    public void setFijos(ArrayList<Fijo> fijos) {
        this.fijos = fijos;
    }

    /**
    1. Agregar fono
        Crear usuario
            Pedir Datos
        Pedir numero, para ver si es movil o fijo
            Crear fijo o móvil
            Si es fijo
     */
    public void agregarFono() {        
        JOptionPane.showMessageDialog(null, "Agregar Usuario");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre").toUpperCase();
        String apellido= JOptionPane.showInputDialog("Ingrese apellido").toUpperCase();
        String run= JOptionPane.showInputDialog("Ingrese run").toUpperCase();
        String fechaNacimiento= JOptionPane.showInputDialog("Ingrese fecha de nacimiento");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
        String estadoCivil = JOptionPane.showInputDialog("Ingrese estado civil").toUpperCase();
        
        Usuario miUsuario = new Usuario(nombre, apellido, run, fechaNacimiento, edad, estadoCivil);
        usuarios.add(miUsuario);
        Iterator it = usuarios.iterator();
        while(it.hasNext()){
            Usuario unUsuario = (Usuario)it.next();
            System.out.println(unUsuario.toString());
        }
    
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
                String[] opciones = new String[2];
                opciones[0]="Smartphone";
                opciones[1]="Tradicional";
                
                int tipoMovil = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "¿Qué tipo de móvil?", //Object message,
                               "Elegir tipo de movil", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               opciones, //Object[] options,
                               opciones[0]);//Object initialValue 
                System.out.println("tipoMovil " + tipoMovil);
                //Smartphone
                if(tipoMovil==0){
                    opciones = new String[2];
                    opciones[0]="iOS Apple";
                    opciones[1]="Android";                    
                    int sistema = JOptionPane.showOptionDialog(null, //Component parentComponent
                               "¿Qué SO de Smartphone?", //Object message,
                               "Elegir SO del Smartphone", //String title
                               JOptionPane.YES_NO_OPTION, //int optionType
                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                               null, //Icon icon,
                               opciones, //Object[] options,
                               opciones[0]);//Object initialValue 
                    System.out.println("sistema " + sistema);

                    if(sistema==1){
                        //Android
                    } else {
                       
                        
                        
                    }
                    
                //Tradicional
                } else {
                    
                }
            } else {
                
            }

            
        }
        //Revisar que este número no exista en la DB de teléfonos fijos
        
    }
    /**
     * Verifica si el teléfono es de un móvil o fijo
     * @param numero del teléfono
     * @return true si es móvil. false si es fijo
     */
    private boolean esMovil(String numero){
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
    private boolean revisarNumero(String numero){
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

    @Override
    public void mostrarCuentaCompleta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cuentaSimple() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float impuestoAplicado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float pagoPorMinutosUsados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float totalAPagar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float descuento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aplicaServicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float pagarServicioTecnico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    @Override
    public String toString() {
        return "Telefonia{" + "companias=" + companias + ", planes=" + planes + ", usuarios=" + usuarios + '}';
    }
    
    
    
}
