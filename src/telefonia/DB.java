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
                System.out.println("Fono no encontrado");
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
                System.out.println("Fono no encontrado");
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
                System.out.println("Fono no encontrado");
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
        return "DB{" + "companias=" + companias + ", telefonos=" + telefonos + ", usuarios=" + usuarios + ", modelosIOS=" + modelosIOS + ", marcasAndroid=" + marcasAndroid + ", tipos=" + tipos + ", modelosTradicionales=" + modelosTradicionales + ", marcasTradicionales=" + marcasTradicionales + '}';
    }

    

    

}
    
    