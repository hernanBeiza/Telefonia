package telefonia;


public abstract class Fijo extends Telefonia{
    private int codigoZona;

    public Fijo() {
    }

    public Fijo(int codigoZona) {
        this.codigoZona = codigoZona;
    }

    public Fijo(int codigoZona, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono, int costoEquipo) {
        super(compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono, costoEquipo);
        this.codigoZona = codigoZona;
    }

    public int getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(int codigoZona) {
        this.codigoZona = codigoZona;
    }

    @Override
    public String toString() {
        return "Fijo{" + "codigoZona=" + codigoZona + ", "+super.toString()+'}';
    }
    
    
    
}
