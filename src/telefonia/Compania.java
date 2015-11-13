package telefonia;

public class Compania {
    private String rut;
    private String nombre;
    private String direccion;

    public Compania() {
    }

    public Compania(String rut, String nombre, String direccion) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Compania{" + "rut=" + rut + ", nombre=" + nombre + ", direccion=" + direccion + '}';
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
    
    
}
