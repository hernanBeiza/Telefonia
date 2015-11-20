package telefonia;

public class Comerciales extends Fijo {
    private int cantidadAnexos;

    public Comerciales(int cantidadAnexos, int codigoZona) {
        super(codigoZona);
        this.cantidadAnexos = cantidadAnexos;
    }

    public Comerciales(int cantidadAnexos, int codigoZona, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono, int costoEquipo) {
        super(codigoZona, compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono, costoEquipo);
        this.cantidadAnexos = cantidadAnexos;
    }

    public int getCantidadAnexos() {
        return cantidadAnexos;
    }

    public void setCantidadAnexos(int cantidadAnexos) {
        this.cantidadAnexos = cantidadAnexos;
    }

    @Override
    public String toString() {
        return "Comerciales{" + "cantidadAnexos=" + cantidadAnexos +  ", "+super.toString()+'}';
    }
    
    
    
    
    
    
    
}
