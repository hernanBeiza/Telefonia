package telefonia;

import java.lang.reflect.Array;
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

        PlanTelefonico economico = new PlanTelefonico("ABC123", "ECONOMICO", "RODRIGO", 10, true);
        PlanTelefonico normal = new PlanTelefonico("ABC123", "NORMAL", "RODRIGO", 50, true);
        PlanTelefonico premium = new PlanTelefonico("ABC123", "PREMIUM", "HERNAN", 100, true);
        planes.add(economico);
        planes.add(normal);
        planes.add(premium);
        Iterator it = planes.iterator();
        /*
        it = planes.iterator();
        while(it.hasNext()){
            PlanTelefonico unPlan = (PlanTelefonico)it.next();
            System.out.println(unPlan.toString());
        }   
        */
        Compania movistar = new Compania("70123456-1", "MOVISTAR", "ESPAÑA",planes);
        Compania entel = new Compania("70234543-2", "ENTEL", "CHILE",planes);
        companias.add(movistar);
        companias.add(entel);
        it = companias.iterator();
        while(it.hasNext()){
            Compania unaCompania = (Compania)it.next();
            System.out.println(unaCompania.toString());
        }  
        
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
                        it = usuarios.iterator();
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
                                        
                                //Luego crear el tipo de móvil
                                String[] opciones = new String[2];
                                opciones[0]="Smartphone";
                                opciones[1]="Tradicional";
                                //tipo
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
                                        
                                        String[] memoria = {"16gb","32gb","64gb"};
                                        int opcionMemoria = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                            "¿Qué cantidad de memoria de iOS?", //Object message,
                                                            "Elegir cantidad memoria de iOS", //String title
                                                            JOptionPane.YES_NO_OPTION, //int optionType
                                                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                            null, //Icon icon,
                                                            memoria, //Object[] options,
                                                            memoria[0]);//Object initialValue 
                                        System.out.println("memoria " + memoria[opcionMemoria]);
                                        
                                        String[] versiones = {"6.0","7.0","8.0","9.0"};
                                        int opcionVersion = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                            "¿Qué versión de SO tiene?", //Object message,
                                                            "Elegir versión de SO", //String title
                                                            JOptionPane.YES_NO_OPTION, //int optionType
                                                            JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                            null, //Icon icon,
                                                            versiones, //Object[] options,
                                                            versiones[0]);//Object initialValue 
                                        System.out.println("versiones " + versiones[opcionVersion]);                                    
                                        
                                        
                                        //    public IOS(String modelo, String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono) {

                                        
                                    }
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                //Teléfono móvil tradicional
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
                                    
                                    int color = JOptionPane.showConfirmDialog(null, "¿Tiene pantalla a color?");
                                    System.out.println("color " + color);
                                }                                
                                
                                //Todo lo común para tradicional y smartphone
                                //Pedir datos de móvil
                                //antena
                                String codigoAntena = JOptionPane.showInputDialog(null, "Ingrese el código de la antena");
                                System.out.println("codigoAntena " + codigoAntena);

                                //peso móvil
                                String[] peso = {"100","130","150"};
                                int opcionPeso = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Cuánto pesa?", //Object message,
                                                    "Elegir el peso", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    peso, //Object[] options,
                                                    peso[0]);//Object initialValue 
                                System.out.println("peso " + peso[opcionPeso]);
                                
                                //duracion
                                String[] duracion = {"1","2","3"};
                                int opcionDuracion = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Cuánto dura la batería?", //Object message,
                                                    "Elegir la duración", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    duracion, //Object[] options,
                                                    duracion[0]);//Object initialValue 
                                System.out.println("duracion " + duracion[opcionDuracion]);

                                //Seleccionar un plan de la lista
                                PlanTelefonico plan = (PlanTelefonico)planes.get(0);
                                System.out.println(planes.size());
                                String[] listaPlanes = new String[planes.size()];
                                
                                for (int i = 0; i < planes.size(); i++) {
                                    listaPlanes[i]=planes.get(i).getNombrePlan();
                                }
                                
                                int opcionPlan = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Qué plan?", //Object message,
                                                    "Elegir plan", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    listaPlanes, //Object[] options,
                                                    plan.getNombrePlan());//Object initialValue 
                                System.out.println("opcionPlan " + listaPlanes[opcionPlan]);     
                                
                                
                                

 
                            } else {
                                //Fijo
                                

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
    
    /**
     * Eliminar un fono
     * @param numero a buscar para eliminar
     * @return estado, true eliminado, false no eliminado
     */
    private static boolean eliminarFono(String numero){
        boolean estado = false;
        
        
        return estado;
    }
    
}
