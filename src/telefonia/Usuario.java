package telefonia;

public class Usuario {
    private String nombre;
    private String apellido;
    private String run;
    private String fechaNacimiento;
    private int edad;
    private String estadoCivil;


    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String run, String fechaNacimiento, int edad, String estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.run = run;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", run=" + run + ", fechaNacimiento=" + fechaNacimiento + ", edad=" + edad + ", estadoCivil=" + estadoCivil + '}';
    }


}
