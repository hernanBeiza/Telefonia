package telefonia;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

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
     * Telefonos registrados en el sistema
     */
    private static ArrayList <Telefonia> telefonos = new ArrayList<Telefonia>();

    /**
     * Usuarios registrados en el sistema
     */
    private static ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
    /**
     * Módelos de teléfonos iPhone
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
        
        boolean run = true;
        while(run){
            String mensajeInicial ="Telefonía\n";
            mensajeInicial+="1. Agregar fono\n";
            mensajeInicial+="2. Buscar fono por número\n";
            mensajeInicial+="3. Eliminar fono número\n";
            mensajeInicial+="4. Modificar fono número X (solo datos asociados)\n";
            mensajeInicial+="5. BUscar fono por run/rut (todos los asociados al elemento)\n";
            mensajeInicial+="6. Eliminar fono por run/rut (todos los asociados al elemento)\n";
            mensajeInicial+="7. Mostrar cuenta para fono X completa\n";
            mensajeInicial+="8. Mostrar cuenta simpel para run X\n";
            mensajeInicial+="9. Aplicar servicio técnico a un fono X\n";
            mensajeInicial+="10. Buscar teléfonos asociados a una marca X\n";
            mensajeInicial+="11. Buscar los fonos que han sido llevados a servicio técnico\n";
            mensajeInicial+="12. Cantidad de cuentas que superarn los 250 minutos\n";
            mensajeInicial+="13. Cantidad de teléfonos privados\n";
            mensajeInicial+="14. Salir\n";
            int opcionPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null, mensajeInicial));
            System.out.println(opcionPrincipal);
            if(opcionPrincipal !=14){
                switch(opcionPrincipal){
                    case 1:
                        //agregar fono
                        //crear usuario
                        JOptionPane.showMessageDialog(null, "Agregar Usuario");
                        String nombre = JOptionPane.showInputDialog("Ingrese nombre").toUpperCase();
                        String apellido= JOptionPane.showInputDialog("Ingrese apellido").toUpperCase();
                        String rut= JOptionPane.showInputDialog("Ingrese run").toUpperCase();
                        String fechaNacimiento= JOptionPane.showInputDialog("Ingrese fecha de nacimiento");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
                        String estadoCivil = JOptionPane.showInputDialog("Ingrese estado civil").toUpperCase();

                        Usuario miUsuario = new Usuario(nombre, apellido, rut, fechaNacimiento, edad, estadoCivil);
                        usuarios.add(miUsuario);
                        Iterator it = usuarios.iterator();
                        while(it.hasNext()){
                            Usuario unUsuario = (Usuario)it.next();
                            System.out.println(unUsuario.toString());
                        }
                        String region = JOptionPane.showInputDialog(null, "Ingrese la región");
                        String comuna = JOptionPane.showInputDialog(null, "Ingrese la comuna");
                        String fechaContrato = JOptionPane.showInputDialog(null, "Ingrese la fecha del contrato");
                        
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
                                        int opcionAndroid = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                   "¿Qué marca de Android?", //Object message,
                                                   "Elegir marca de Android", //String title
                                                   JOptionPane.YES_NO_OPTION, //int optionType
                                                   JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                   null, //Icon icon,
                                                   marcasAndroid, //Object[] options,
                                                   marcasAndroid[0]);//Object initialValue 
                                        System.out.println("marca " + marcasAndroid[opcionAndroid]);

                                        
                                    } else {
                                        int opcionIOS = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                            "¿Qué modelos de iOS?", //Object message,
                                                            "Elegir modelo de iOS", //String title
                                                            JOptionPane.YES_NO_OPTION, //int optionType
                                                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                            null, //Icon icon,
                                                            modelosIOS, //Object[] options,
                                                            modelosIOS[0]);//Object initialValue 
                                        System.out.println("modelo " + modelosIOS[opcionIOS]);
                                    }

                                //Tradicional
                                } else {
                                    int opcionTradicional = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                        "¿Qué tipo de equipo?", //Object message,
                                                        "Elegir tipo de equipo", //String title
                                                        JOptionPane.YES_NO_OPTION, //int optionType
                                                        JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                        null, //Icon icon,
                                                        tipos, //Object[] options,
                                                        tipos[0]);//Object initialValue 
                                    System.out.println("opcionTradicional " + tipos[opcionTradicional]);                                    
                                }
                                //Seleccionar un plan de la lista
                                /*
                                PlanTelefonico plan = (PlanTelefonico)planes.get(0);
                                System.out.println(planes.size());
                                String[] listaPLanes = new String[planes.size()];
                                
                                for (int i = 0; i < planes.size(); i++) {
                                    listaPLanes[i]=planes.get(i).getNombrePlan();
                                }
                                int opcionPlan = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Qué plan?", //Object message,
                                                    "Elegir plan", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    listaPLanes, //Object[] options,
                                                    plan.getNombrePlan());//Object initialValue 
                                System.out.println("opcionPlan " + listaPLanes[opcionPlan]);     
                                */

                            } else {

                            }
                        }
                
                            break;
                    case 2:
                        //buscar fono por número
                        JOptionPane.showMessageDialog(null, "2. Buscar fono por número");
                        String numero = JOptionPane.showInputDialog(null, "Ingrese el número a buscar");
                        Telefonia telefono = buscarPorFono(numero);
                        if(telefono!=null){
                            System.out.println("Sí encontrado");
                            System.out.println(telefono.toString());
                        } else {
                            System.out.println("No encontado");
                        }
                            break;
                    }                    
            } else {
                run = false;
            }
        
        
     
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static Telefonia buscarPorFono(String fono){
        Telefonia telefonia = null;
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono.getNumeroFono().equals(fono)){
                System.out.println("Fono Encontrado");
                telefonia = unTelefono;
            } else {
                System.out.println("Fono no encontrado");
                telefonia = null;
            }
        }
                
        return telefonia;            
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
            /*
            iterador = moviles.iterator();
            while(iterador.hasNext()){
                Movil unMovil = (Movil)iterador.next();
                if(unMovil.getNumeroFono().equals(numero)){
                    encontrado = true;
                    break;
                }
            } 
            */
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
