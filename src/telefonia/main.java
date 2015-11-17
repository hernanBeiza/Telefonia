package telefonia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class main {
    /**
     * Companias de teléfono registradas en el sistema
     * 
     */
    private static ArrayList <Compania> companias = new ArrayList<Compania>();
    
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
     * Modelos de teléfonos tradicionales
     */
    private static String[] modelosTradicionales = {"3320","3310"};
    /**
     * Marcas de teléfonos 
     */
    private static String[] marcasTradicionales = {"Nokia","LG"};

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        Iterator it = null;
        ArrayList <PlanTelefonico> planesEntel = new ArrayList<PlanTelefonico>();

        PlanTelefonico economicoEntel = new PlanTelefonico("ABC123", "ECONOMICO", "RODRIGO", 10, true);
        PlanTelefonico normalEntel = new PlanTelefonico("ABC123", "NORMAL", "ANDRÉS", 50, true);
        PlanTelefonico premiumEntel = new PlanTelefonico("ABC123", "PREMIUM", "HERNAN", 100, true);
        planesEntel.add(economicoEntel);
        planesEntel.add(normalEntel);
        planesEntel.add(premiumEntel);
        
        ArrayList <PlanTelefonico> planesMovistar = new ArrayList<PlanTelefonico>();        
        PlanTelefonico normalMovistar = new PlanTelefonico("ABC123", "NORMAL", "GRACIELA", 50, true);
        PlanTelefonico premiumMovistar = new PlanTelefonico("ABC123", "PREMIUM", "HERNAN", 100, true);
        planesMovistar.add(normalMovistar);
        planesMovistar.add(premiumMovistar);
        
        /*
        it = planes.iterator();
        it = planes.iterator();
        while(it.hasNext()){
            PlanTelefonico unPlan = (PlanTelefonico)it.next();
            System.out.println(unPlan.toString());
        }   
        */
        Compania movistar = new Compania("70123456-1", "MOVISTAR", "ESPAÑA",planesMovistar);
        Compania entel = new Compania("70234543-2", "ENTEL", "CHILE",planesEntel);
        companias.add(movistar);
        companias.add(entel);
        /*
        it = companias.iterator();
        while(it.hasNext()){
            Compania unaCompania = (Compania)it.next();
            System.out.println(unaCompania.toString());
        }  
        */
        
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
            switch(opcionPrincipal){
                case 1:
                    //1. Agregar fono
                    String numeroTelefono= JOptionPane.showInputDialog("Ingrese el número");
                    if(revisarNumero(numeroTelefono)){
                        //Existe en la DB, no se puede crear
                        System.out.println("Número de teléfono ya existe");
                        JOptionPane.showMessageDialog(null, "Número de teléfono ya existe");
                    } else {
                        System.out.println("Número de teléfono no existe");

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

                        //Variables del teléfono
                        Compania compania = null;
                        int tipoMovil;
                        int valorMinutoFijo = 0;
                        int valorMinutoMovil = 0;
                        int tarifaFija = 0;
                        PlanTelefonico planTelefono = null;
                        String modelo = "";
                        int cantidadMemoria = 0;
                        String versionOS = "";
                        int codigoAntena = 0;
                        int peso = 0;
                        int duracionBateria = 0;
                        if(esMovil(numeroTelefono)){

                            //Luego crear el tipo de móvil
                            String[] opciones = new String[2];
                            opciones[0]="Smartphone";
                            opciones[1]="Tradicional";
                            //tipo
                            tipoMovil = JOptionPane.showOptionDialog(null, //Component parentComponent
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
                                opciones[0] = "iOS Apple";
                                opciones[1] = "Android";                    
                                int sistemaOpcion = JOptionPane.showOptionDialog(null, //Component parentComponent
                                           "¿Qué SO de Smartphone?", //Object message,
                                           "Elegir SO del Smartphone", //String title
                                           JOptionPane.YES_NO_OPTION, //int optionType
                                           JOptionPane.INFORMATION_MESSAGE, //int messageType
                                           null, //Icon icon,
                                           opciones, //Object[] options,
                                           opciones[0]);//Object initialValue 
                                System.out.println("sistema " + opciones[sistemaOpcion]);
                                //Código antena
                                codigoAntena = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la antena"));
                                System.out.println("codigoAntena " + codigoAntena);
                                //peso móvil
                                peso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el peso del equipo"));
                                //duracion
                                duracionBateria = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la duración de lbatería"));

                                //Seleccionar compañía
                                compania = companias.get(0);
                                String[] listaCompanias = new String[companias.size()];
                                for (int i = 0; i < companias.size(); i++) {
                                    listaCompanias[i]=companias.get(i).getNombre();
                                }
                                int opcionCompania = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Qué compaía?", //Object message,
                                                    "Elegir compañia", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    listaCompanias, //Object[] options,
                                                    compania.getNombre());//Object initialValue 
                                System.out.println("opcionCompania " + listaCompanias[opcionCompania]);    
                                compania = companias.get(opcionCompania);

                                //Seleccionar un plan de la lista
                                PlanTelefonico plan = (PlanTelefonico)compania.getPlan().get(0);
                                //System.out.println(planes.size());
                                String[] listaPlanes = new String[compania.getPlan().size()];
                                for (int i = 0; i < compania.getPlan().size(); i++) {
                                    listaPlanes[i] = compania.getPlan().get(i).getNombrePlan();
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
                                planTelefono = compania.getPlan().get(opcionPlan);

                                String[] memoria = {"16","32","64"};
                                int opcionMemoria = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Qué cantidad de memoria de iOS?", //Object message,
                                                    "Elegir cantidad memoria de iOS", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    memoria, //Object[] options,
                                                    memoria[0]);//Object initialValue 
                                System.out.println("memoria " + memoria[opcionMemoria]);
                                cantidadMemoria = Integer.parseInt(memoria[opcionMemoria]);

                                if(sistemaOpcion==1){
                                    //Android
                                    int opcionAndroid = JOptionPane.showOptionDialog(null, 
                                               "¿Qué marca de Android?", //Object message,
                                               "Elegir marca de Android", //String title
                                               JOptionPane.YES_NO_OPTION, //int optionType
                                               JOptionPane.INFORMATION_MESSAGE, //int messageType
                                               null, //Icon icon,
                                               marcasAndroid, //Object[] options,
                                               marcasAndroid[0]);//Object initialValue 
                                    System.out.println("marca " + marcasAndroid[opcionAndroid]);
                                    String marca = marcasAndroid[opcionAndroid];
                                    String[] versiones = {"4.3 Jelly Bean (Michel)","4.4 KitKat (Doger)","5.0 Lollipop","6.0 Marshmallow"};
                                    int opcionVersion = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                        "¿Qué versión de SO tiene?", //Object message,
                                                        "Elegir versión de SO", //String title
                                                        JOptionPane.YES_NO_OPTION, //int optionType
                                                        JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                        null, //Icon icon,
                                                        versiones, //Object[] options,
                                                        versiones[0]);//Object initialValue 
                                    System.out.println("versiones " + versiones[opcionVersion]);
                                    versionOS = versiones[opcionVersion];
                                    Android android = new Android(marca, versionOS, cantidadMemoria, codigoAntena, peso, duracionBateria, compania, miUsuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMemoria, valorMinutoMovil, planTelefono, numeroTelefono);
                                    telefonos.add(android);
                                    System.out.println(android.toString());
                                } else {
                                    //IOS
                                    int opcionIOS = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                        "¿Qué modelos de iOS?", //Object message,
                                                        "Elegir modelo de iOS", //String title
                                                        JOptionPane.YES_NO_OPTION, //int optionType
                                                        JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                        null, //Icon icon,
                                                        modelosIOS, //Object[] options,
                                                        modelosIOS[0]);//Object initialValue 
                                    System.out.println("modelo " + modelosIOS[opcionIOS]);
                                    modelo = modelosIOS[opcionIOS];

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
                                    versionOS = versiones[opcionVersion];
                                    // public IOS(String modelo, String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono) {
                                    IOS ios = new IOS(modelo, versionOS, cantidadMemoria, codigoAntena, peso, duracionBateria, compania, miUsuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, valorMinutoFijo, valorMinutoMovil, planTelefono, numeroTelefono);
                                    telefonos.add(ios);
                                    System.out.println(ios.toString());
                                }
                            } else {
                                //Teléfono móvil tradicional
                                int opcionTradicional = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Qué tipo de equipo?", //Object message,
                                                    "Elegir tipo de equipo", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    tipos, //Object[] options,
                                                    tipos[0]);//Object initialValue 
                                System.out.println("opcionTradicional " + tipos[opcionTradicional]);  

                                int opcionMarca = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Qué marca de equipo?", //Object message,
                                                    "Elegir marca de equipo", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    marcasTradicionales, //Object[] options,
                                                    marcasTradicionales[0]);//Object initialValue 
                                System.out.println("opcionMarca " + marcasTradicionales[opcionMarca]);  

                                int opcionModelo = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Qué modelo de equipo?", //Object message,
                                                    "Elegir modelo de equipo", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    modelosTradicionales, //Object[] options,
                                                    modelosTradicionales[0]);//Object initialValue 
                                modelo = modelosTradicionales[opcionModelo];
                                System.out.println("opcionModelo " + modelosTradicionales[opcionModelo]);
                                System.out.println("modelo " + modelo);  
                                //Código antena
                                codigoAntena = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la antena"));
                                System.out.println("codigoAntena " + codigoAntena);
                                //peso móvil
                                peso = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el peso del equipo"));
                                //duracion
                                duracionBateria = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la duración de lbatería"));

                                //Seleccionar compañía
                                compania = companias.get(0);
                                String[] listaCompanias = new String[companias.size()];
                                for (int i = 0; i < companias.size(); i++) {
                                    listaCompanias[i]=companias.get(i).getNombre();
                                }
                                int opcionCompania = JOptionPane.showOptionDialog(null, //Component parentComponent
                                                    "¿Qué compaía?", //Object message,
                                                    "Elegir compañia", //String title
                                                    JOptionPane.YES_NO_OPTION, //int optionType
                                                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                                                    null, //Icon icon,
                                                    listaCompanias, //Object[] options,
                                                    compania.getNombre());//Object initialValue 
                                System.out.println("opcionCompania " + listaCompanias[opcionCompania]);    
                                compania = companias.get(opcionCompania);

                                //Seleccionar un plan de la lista
                                PlanTelefonico plan = (PlanTelefonico)compania.getPlan().get(0);
                                //System.out.println(planes.size());
                                String[] listaPlanes = new String[compania.getPlan().size()];
                                for (int i = 0; i < compania.getPlan().size(); i++) {
                                    listaPlanes[i] = compania.getPlan().get(i).getNombrePlan();
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
                                planTelefono = compania.getPlan().get(opcionPlan);

                                int colorOpcion = JOptionPane.showConfirmDialog(null, "¿Tiene pantalla a color?");
                                boolean color = true;
                                if(colorOpcion==0){
                                    color = true;
                                } else {
                                    color = false;
                                }

                                System.out.println("colorOpcion " + colorOpcion);
                                System.out.println("color " + color);

                                Tradicional tradicional = new Tradicional(color,modelo, codigoAntena, peso, duracionBateria, compania, miUsuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMemoria, valorMinutoMovil, planTelefono, numeroTelefono);
                                System.out.println(tradicional.toString());
                                telefonos.add(tradicional);
                            }                                

                        } else {
                            //Fijo
                            //Lógica de Andrés acá....
                           //Luego crear el tipo de móvil
                            String[] OpFijo = new String[2];
                            OpFijo[0]="Comerciales";
                            OpFijo[1]="Privado";
                            //tipo
                            int TipoPlan = JOptionPane.showOptionDialog(null, //Component parentComponent
                                           "¿Qué tipo de teléfono?", //Object message,
                                           "Elegir tipo de teléfono", //String title
                                           JOptionPane.YES_NO_OPTION, //int optionType
                                           JOptionPane.INFORMATION_MESSAGE, //int messageType
                                           null, //Icon icon,
                                           OpFijo, //Object[] options,
                                           OpFijo[0]);//Object initialValue 
                            System.out.println("TipoPlan " + TipoPlan);

                            if (TipoPlan ==0){
                                    System.out.println("Opción Comercial " + OpFijo[TipoPlan]);    
                                    Comerciales com = new Comerciales(cantidadMemoria, codigoAntena, compania, miUsuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMemoria, valorMinutoMovil, planTelefono, numeroTelefono);
                                    telefonos.add(com);
                                    int cantidadAnexos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad de Anexos"));
                                    System.out.println(cantidadAnexos);
                                    com.setCantidadAnexos(cantidadAnexos);
                                    System.out.println(com.toString());
                            }else if( TipoPlan == 1){
                                    System.out.println("Opción Privado " + OpFijo[TipoPlan]);    
                                    Privado pri =new Privado(run, codigoAntena, compania, miUsuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMemoria, valorMinutoMovil, planTelefono, numeroTelefono);
                                    telefonos.add(pri);
                                    int identificador = JOptionPane.showConfirmDialog(null,"¿Tiene identificador de llamadas?");
                                    if(identificador==1){
                                        pri.setIdentificadorLlamada(false);                                   
                                    } else {
                                        pri.setIdentificadorLlamada(true);
                                    }
                                    System.out.println(pri.toString());
                                }                        

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
                        JOptionPane.showMessageDialog(null, "¡Teléfono encontrado! Usuario Rut:"+telefono.getUsuario().getRun());
                        System.out.println(telefono.toString());
                    } else {
                        System.out.println("No encontado");
                        JOptionPane.showMessageDialog(null, "Fono no encontrado");
                    }
                    break;
                case 3:
                    //eliminar fono por número
                    JOptionPane.showMessageDialog(null, "3. Eliminar fono por número");
                    String numeroEliminar = JOptionPane.showInputDialog(null, "Ingrese el número a eliminar");
                    Telefonia telefonoEliminar = buscarPorFono(numeroEliminar);
                    if(telefonoEliminar!=null){
                        System.out.println("Sí encontrado");
                        JOptionPane.showMessageDialog(null, "¡Teléfono encontrado! Usuario Rut:"+telefonoEliminar.getUsuario().getRun());
                        System.out.println(telefonoEliminar.toString());
                        if(telefonos.remove(telefonoEliminar)){
                            JOptionPane.showMessageDialog(null, "Fono eliminado correctamente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Fono no encontrado");
                    }

                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Modificar fono número");
                    String numeroModificar = JOptionPane.showInputDialog("Ingrese el número a modificar");
                    Telefonia telefonoModificar = buscarPorFono(numeroModificar);
                    if(telefonoModificar != null){
                        JOptionPane.showMessageDialog(null, "Fono encontrado");                            
                    } else {
                        JOptionPane.showMessageDialog(null, "Fono no encontrado");
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "5. Buscar fono por rut");
                    String rutBuscar = JOptionPane.showInputDialog(null, "Ingrese el rut a buscar");
                    Telefonia telefonoRut = buscarFonoPorRut(rutBuscar);
                    if(telefonoRut!=null){
                        JOptionPane.showMessageDialog(null, "¡Teléfono encontrado! Usuario Fono:"+telefonoRut.getNumeroFono());
                        System.out.println(telefonoRut.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Fono no encontrado");
                    }

                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "6. Eliminar fono por rut");
                    String rutEliminar = JOptionPane.showInputDialog(null, "Ingrese el rut a eliminar");
                    Telefonia telefonoEliminarRut = buscarFonoPorRut(rutEliminar);
                    if(telefonoEliminarRut!=null){
                        System.out.println("Sí encontrado");
                        JOptionPane.showMessageDialog(null, "¡Rut encontrado! Usuario Numero:"+telefonoEliminarRut.getNumeroFono());
                        System.out.println(telefonoEliminarRut.toString());
                        if(telefonos.remove(telefonoEliminarRut)){
                            JOptionPane.showMessageDialog(null, "Fono eliminado correctamente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Fono no encontrado");
                    }                        
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "7. Mostrar cuenta para X fono completa");
                    String rutCuentaCompleta = JOptionPane.showInputDialog(null, "Ingrese el rut del teléfono a mostrar");
                    Telefonia elTelefono = buscarFonoPorRut(rutCuentaCompleta);
                    if(elTelefono!=null){
                        System.out.println(elTelefono.toString());                     
                    } else {
                        System.out.println("Teléfono no encontrado");
                        JOptionPane.showMessageDialog(null, "Fono no encontrado");
                    }
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "8. Mostrar cuenta simple para rut X (todos los asociados al elemento)");
                    String rutCuentaSimple = JOptionPane.showInputDialog(null, "Ingrese el rut del teléfono a mostrar");
                    Telefonia telefonoSimple = buscarFonoPorRut(rutCuentaSimple);
                    if(telefonoSimple!=null){
                        System.out.println(telefonoSimple.toString());                     
                    } else {
                        System.out.println("Teléfono no encontrado");
                    }
                    break;
                case 9:                    
                    JOptionPane.showMessageDialog(null, "9. Aplicar servicio técnico a un fono X");
                    String fonoTecnico = JOptionPane.showInputDialog("Ingrese el fono para llevar al servicio técnico");
                    Telefonia telefonoTecnico = buscarPorFono(fonoTecnico);
                    if(telefonoTecnico!=null){
                        System.out.println(telefonoTecnico.toString());                     
                        int opcionTecnico = JOptionPane.showConfirmDialog(null, "¿Desea llevar a servicio técnico?");
                        System.out.println(opcionTecnico);
                        if(opcionTecnico==0){
                            telefonoTecnico.getPlanTelefonico().setEstadoServicioTecnico(true);
                        } else {
                            telefonoTecnico.getPlanTelefonico().setEstadoServicioTecnico(false);
                        }
                    } else {
                        System.out.println("Teléfono no encontrado");
                        JOptionPane.showMessageDialog(null, "Fono no encontrado");
                    }
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "10. Buscar teléfono asociado a una marca");                    
                    int opcionMarca = JOptionPane.showOptionDialog(null, //Component parentComponent
                    "¿Qué marca de equipo desea buscar?", //Object message,
                    "Elegir marca de equipo", //String title
                    JOptionPane.YES_NO_OPTION, //int optionType
                    JOptionPane.INFORMATION_MESSAGE, //int messageType
                    null, //Icon icon,
                    marcasAndroid, //Object[] options,
                    marcasAndroid[0]);//Object initialValue 
                    //Puede ser marcas de tradicionales también, arreglar!
                    System.out.println("opcionMarca " + marcasAndroid[opcionMarca]);  
                    ArrayList <Telefonia> telefonosMarca = buscarPorMarca(marcasAndroid[opcionMarca]);
                    System.out.println(telefonosMarca);
                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:
                    run = false;                    
                    break;
                case 15:
                    listarNumeros();

                    break;
                }
            
        
     
        }
    }
    
    
    
    
    
    
    
    
    /**
     * Devuelve la cantidad de teléfonos privados
     * @return cantidad de teléfonos privados
     */
    private static int cantidadPrivados(){
        int totalPrivados = 0;
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono instanceof Privado){
                totalPrivados++;
            }
        }
        return totalPrivados;
    }
    
    private static int cantidadIOS(){
        int totalIOS = 0;
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono instanceof IOS){
                totalIOS++;
            }
        }
        return totalIOS;
    }
    /**
     * Busca un teléfono por fono
     * @param fono a buscar
     * @return Telefonia. null en caso no encontrar
     */
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
     * Busca un fono por el rut
     * @param rut a buscar
     * @return Telefonia. null en caso de no encontrado
     */
    private static Telefonia buscarFonoPorRut(String rut){
        Telefonia telefonia = null;
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono.getUsuario().getRun().equals(rut)){
                telefonia = unTelefono;
                break;
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
    
    private static ArrayList<Telefonia> buscarPorMarca(String marca){
        ArrayList<Telefonia>telefonosAndroid = new ArrayList<Telefonia>();
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono instanceof Android){
                Android android = (Android)unTelefono;
                if(android.getMarcaFono().equals(marca)){
                    telefonosAndroid.add(android);
                }
            }
        }
        return telefonosAndroid;
    }
     /**
     * Busca el número en la DB correspondiente
     * @param numero del teléfono
     * @return true si existe. false si no
     */    
    private static boolean revisarNumero(String numero){
        boolean encontrado = false;
        Iterator iterador = telefonos.iterator();
        while(iterador.hasNext()){
            Telefonia unTelefono = (Telefonia)iterador.next();
            if(unTelefono.getNumeroFono().equals(numero)){
                encontrado = true;
                break;
            }
        }            
        return encontrado;
    }
    /**
     * Opción 15. Oculta. Lista los números guardados. Solo para pruebas. 
     */
    private static void listarNumeros(){
        System.out.println("listarNumeros");
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia telefono = (Telefonia)it.next();
            System.out.println(telefono.toString());
        }
    }
}
