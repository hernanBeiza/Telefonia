/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonia;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author hernanBeiza
 */
public class DB {
    /**
     * Companias de teléfono registradas en el sistema
     * 
     */
    private ArrayList <Compania> companias = new ArrayList<Compania>();
    
    /**
     * Telefonos registrados en el sistema
     */
    private ArrayList <Telefonia> telefonos = new ArrayList<Telefonia>();

    /**
     * Usuarios registrados en el sistema
     */
    private ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
    /**
     * Módelos de teléfonos iPhone
     */
    private String[] modelosIOS = {"1","2","3","4","5","6"};
    /**
     * Marcas Android registradas en el sistema
     */
    private String[] marcasAndroid = {"Samsung","Huawei","OWN"};
    /**
     * Tipos de teléfonos tradicionales
     */
    private String[] tipos = {"Almeja","Normal","Slice"};
    /**
     * Modelos de teléfonos tradicionales
     */
    private String[] modelosTradicionales = {"3320","3310"};
    /**
     * Marcas de teléfonos 
     */
    private String[] marcasTradicionales = {"Nokia","LG"};
    /**
     * Planes telefónicos
     */
    private ArrayList planes = new ArrayList<PlanTelefonico>();
    
    public DB() {
        System.out.println("DB: init");
    }

    public ArrayList<Compania> getCompanias() {
        return companias;
    }

    public void setCompanias(ArrayList<Compania> companias) {
        this.companias = companias;
    }

    public ArrayList<Telefonia> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<Telefonia> telefonos) {
        this.telefonos = telefonos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String[] getModelosIOS() {
        return modelosIOS;
    }

    public void setModelosIOS(String[] modelosIOS) {
        this.modelosIOS = modelosIOS;
    }

    public String[] getMarcasAndroid() {
        return marcasAndroid;
    }

    public void setMarcasAndroid(String[] marcasAndroid) {
        this.marcasAndroid = marcasAndroid;
    }

    public String[] getTipos() {
        return tipos;
    }

    public void setTipos(String[] tipos) {
        this.tipos = tipos;
    }

    public String[] getModelosTradicionales() {
        return modelosTradicionales;
    }

    public void setModelosTradicionales(String[] modelosTradicionales) {
        this.modelosTradicionales = modelosTradicionales;
    }

    public String[] getMarcasTradicionales() {
        return marcasTradicionales;
    }

    public void setMarcasTradicionales(String[] marcasTradicionales) {
        this.marcasTradicionales = marcasTradicionales;
    }

    public ArrayList getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList planes) {
        this.planes = planes;
    }

    
    /**
     * Inicia la DB con data precargada
     */
    public void iniciarData(){
        //Planes Telefónicos
        PlanTelefonico economicoEntel = new PlanTelefonico("ABC123", "ECONOMICO", "RODRIGO", 10, false);
        PlanTelefonico normalEntel = new PlanTelefonico("ABC123", "NORMAL", "ANDRÉS", 50, false);
        PlanTelefonico premiumEntel = new PlanTelefonico("ABC123", "PREMIUM", "HERNAN", 100, false);
        PlanTelefonico normalMovistar = new PlanTelefonico("ABC123", "NORMAL", "GRACIELA", 50, false);
        PlanTelefonico premiumMovistar = new PlanTelefonico("ABC123", "PREMIUM", "Victor", 100, false);
        planes.add(economicoEntel);
        planes.add(normalEntel);
        planes.add(premiumEntel);
        planes.add(normalMovistar);
        planes.add(premiumMovistar);
        //Compañías
        ArrayList <PlanTelefonico> planesEntel = new ArrayList<PlanTelefonico>();
        planesEntel.add(economicoEntel);
        planesEntel.add(normalEntel);
        planesEntel.add(premiumEntel);
        
        ArrayList <PlanTelefonico> planesMovistar = new ArrayList<PlanTelefonico>();        
        planesMovistar.add(normalMovistar);
        planesMovistar.add(premiumMovistar);
        
        Compania movistar = new Compania("70123456-1", "MOVISTAR", "ESPAÑA",planesMovistar);
        Compania entel = new Compania("70234543-2", "ENTEL", "CHILE",planesEntel);
        companias.add(movistar);
        companias.add(entel);
        
        //Usuarios
        Usuario doris = new Usuario("Doris", "Napolitano", "5929028-2","05-02-1955" , 60, "SOLTERO");
        Usuario domingo = new Usuario("Domingo", "Beiza", "9040207-4","25-12-1965" , 50, "SOLTERO");
        usuarios.add(doris);
        usuarios.add(domingo);
        
        //Teléfonos Fijo
        //    public Privado(boolean identificadorLlamada, int codigoZona, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono, int costoEquipo) {
        Privado telefonoPrivado = new Privado(false, 033, movistar, domingo, "Petorca", "Papudo", "04/07/2010", 10, 100, 1000, 100, 200, premiumEntel, "790123", 5000);
        telefonos.add(telefonoPrivado);
        telefonoPrivado.descuento();
        //Teléfono Comercial
        //    public Comerciales(int cantidadAnexos, int codigoZona, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono, int costoEquipo) {
        Comerciales telefonoComercial = new Comerciales(10, 02, entel, doris, "RM", "La Florida", "01/01/1990", 10, 100, 22000, 0,0, economicoEntel, "2813797", 1000);
        telefonos.add(telefonoComercial);
        
    }
    
    /**
     * Guarda un usuario en la DB
     * @param unUsuario a guardar
     * @return true si se pudo guardar correctamente. false en caso contrario (se encontró un usuario con el mismo rut guardado previamente)
     */
    public boolean usuarioGuardar(Usuario unUsuario){
        boolean estado = true;
        if(usuarioBuscar(unUsuario)==null){
            this.usuarios.add(unUsuario);
        } else {
            estado = false;
        }
        return estado;
    }
    /**
     * Busca si existe un usuario en la DB
     * @param unUsuario tipo Usuario. Usuario a buscar
     * @return instancia de tipo Usuario si el usuario se encontró. null en caso contrario
     */
    public Usuario usuarioBuscar (Usuario unUsuario){
        Iterator it = usuarios.iterator();
        while(it.hasNext()){
            Usuario usuario = (Usuario)it.next();
            if(usuario.getRun().equals(unUsuario.getRun())){
                return usuario;
            }
        }
        return null;
    }
    
    /**
     * Busca un usuario por el rut
     * @param rutUsuario String. Rut del usuario a buscar
     * @return usuario si existe. null en caso contrario
     */
    public Usuario usuarioBuscarPorRut (String rutUsuario){
        Iterator it = usuarios.iterator();
        while(it.hasNext()){
            Usuario usuario = (Usuario)it.next();
            if(usuario.getRun().equals(rutUsuario)){
                return usuario;
            }
        }
        return null;
    }
    
    public boolean planesGuardar(PlanTelefonico unPlan){
        boolean estado = true;
        if(planesBuscar(unPlan)==null){
            this.planes.add(unPlan);
        } else {
            estado = false;
        }
        return estado;
    }
    
    public PlanTelefonico planesBuscar(PlanTelefonico unPlan){
        Iterator it = planes.iterator();
        while(it.hasNext()){
            PlanTelefonico plan = (PlanTelefonico)it.next();
            if(plan.getCodigo().equals(unPlan.getCodigo())){
                return plan;
            }
        }
        return null;
    }

    /**
     * Guarda una companía en la DB
     * @param unaCompania a guadar. Instancia de Compania
     * @return true si se guardó con éxito. false encaso contrario (existe otra con el mismo rut)
     */
    public boolean companiaGuardar(Compania unaCompania){
        boolean estado = true;
        if(companiaBuscar(unaCompania)==null){
            this.companias.add(unaCompania);
        } else {
            estado = false;
        }
        return estado;
    }

    /**
     * Busca una compania en la DB
     * @param unaCompania a buscar usando el rut
     * @return la compania encontrada. null en caso contrario
     */
    public Compania companiaBuscar (Compania unaCompania){
        Iterator it = companias.iterator();
        while(it.hasNext()){
            Compania compania = (Compania)it.next();
            if(compania.getRut().equals(unaCompania.getRut())){
                return compania;
            }
        }
        return null;
    }
        
    /**
     * Devuelve la cantidad de teléfonos privados
     * @return cantidad de teléfonos privados
     */
    public int cantidadPrivados(){
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
    /**
     * Retorna los teléfonos que están en el servici técnico
     * @return ArrayList de Telefonia
     */    
    public ArrayList <Telefonia> telefonosServicio(){
        ArrayList<Telefonia>servicio = new ArrayList<Telefonia>();
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono.getPlanTelefonico().isEstadoServicioTecnico()){
                System.out.println("Fono Encontrado");
                servicio.add(unTelefono);
            }
        }              
        return servicio;            
    }
    /**
     * Retorna la cantidad de teléfonos iOS
     * @return int con la cantidad
     */
    public int cantidadIOS(){
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
     * Devuelve los teléfonos privados
     * @return ArrayList con los teléfonos
     */
    
    public ArrayList <Telefonia> obtenerPrivados(){
        ArrayList<Telefonia>privados = new ArrayList<Telefonia>();
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono instanceof Privado){
                System.out.println("Fono Encontrado");
                privados.add(unTelefono);
            } else {
                //System.out.println("Fono no encontrado");
            }
        }              
        return privados;            
    }
    /**
     * Devuelve los teléfonos comerciales
     * @return ArrayList con los teléfonos
     */
    public ArrayList <Telefonia> obtenerComerciales(){
        ArrayList<Telefonia>comerciales = new ArrayList<Telefonia>();
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono instanceof Comerciales){
                System.out.println("Fono Encontrado");
                comerciales.add(unTelefono);
            } else {
                //System.out.println("Fono no encontrado");
            }
        }              
        return comerciales;                    
    }
    /**
     * Busca un teléfono por número
     * @param numero a buscar
     * @return Telefonia. null en caso no encontrar
     */
    public ArrayList <Telefonia>buscarFonoPorNumero(String numero){
        ArrayList<Telefonia>telefonosNumero = new ArrayList<Telefonia>();
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono.getNumeroFono().equals(numero)){
                System.out.println("Fono Encontrado");
                telefonosNumero.add(unTelefono);
            } else {
                //System.out.println("Fono no encontrado");
            }
        }              
        return telefonosNumero;            
    }
    /**
     * Busca un fono por el rut
     * @param rut a buscar
     * @return Telefonia. null en caso de no encontrado
     */
    public ArrayList <Telefonia> buscarFonoPorRut(String rut){
        ArrayList<Telefonia>telefonosRut = new ArrayList<Telefonia>();
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono.getUsuario().getRun().equals(rut)){
                telefonosRut.add(unTelefono);
            }
        }
        return telefonosRut;
    }
    
    public ArrayList <Telefonia> cuentasSobre(){
        ArrayList <Telefonia> cuentas = new ArrayList<Telefonia>();
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia unTelefono = (Telefonia)it.next();
            if(unTelefono.getCantidadMinutosUsadosFijos()+unTelefono.getCantidadMinutosUsadosMovil()>=250){
                cuentas.add(unTelefono);
            }            
        }
        return cuentas;
    }
    /**
     * Busca los teléfonos según la marca
     * @param marca a buscar
     * @return arraylist con los teléfonos 
     */
    public ArrayList<Telefonia> buscarFonoPorMarca(String marca){
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
    public boolean revisarNumero(String numero){
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
     * Verifica si el teléfono es de un móvil o fijo
     * @param numero del teléfono
     * @return true si es móvil. false si es fijo
     */
    public boolean esMovil(String numero){
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
     * Lista los números guardados. 
     */
    public void listarNumeros(){
        System.out.println("listarNumeros");
        Iterator it = telefonos.iterator();
        while(it.hasNext()){
            Telefonia telefono = (Telefonia)it.next();
            System.out.println(telefono.toString());
        }
    }
    
    @Override
    public String toString() {
        return "DB{" + "companias=" + companias + ", telefonos=" + telefonos + ", usuarios=" + usuarios + ", modelosIOS=" + modelosIOS + ", marcasAndroid=" + marcasAndroid + ", tipos=" + tipos + ", modelosTradicionales=" + modelosTradicionales + ", marcasTradicionales=" + marcasTradicionales + ", planes=" + planes + '}';
    }

}
    
    