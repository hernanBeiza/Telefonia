package telefonia;

public class Privado extends Fijo{
    
    private boolean identificadorLlamada;

    public Privado(boolean identificadorLlamada, int codigoZona) {
        super(codigoZona);
        this.identificadorLlamada = identificadorLlamada;
    }

    public Privado(boolean identificadorLlamada, int codigoZona, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono, int costoEquipo) {
        super(codigoZona, compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono, costoEquipo);
        this.identificadorLlamada = identificadorLlamada;
    }

    public boolean isIdentificadorLlamada() {
        return identificadorLlamada;
    }

    public void setIdentificadorLlamada(boolean identificadorLlamada) {
        this.identificadorLlamada = identificadorLlamada;
    }

    @Override
    public String toString() {
        return "Privado{" + "identificadorLlamada=" + identificadorLlamada + ", "+super.toString()+'}';
    }
    
    
    
    
    
    
}
