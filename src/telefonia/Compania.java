package telefonia;

import java.util.ArrayList;

public class Compania {
    private String rut;
    private String nombre;
    private String direccion;
    private ArrayList <PlanTelefonico> Plan; 
    
    public Compania() {
        
    }

    public Compania(String rut, String nombre, String direccion, ArrayList<PlanTelefonico> Plan) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.Plan = Plan;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<PlanTelefonico> getPlan() {
        return Plan;
    }

    public void setPlan(ArrayList<PlanTelefonico> Plan) {
        this.Plan = Plan;
    }

    @Override
    public String toString() {
        return "Compania{" + "rut=" + rut + ", nombre=" + nombre + ", direccion=" + direccion + ", Plan=" + Plan + '}';
    }    
    
}
