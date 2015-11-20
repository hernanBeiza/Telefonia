package telefonia;

public class Tradicional extends Movil{
    
    /**
     * Indica si tiene pantalla a color
     */
    private boolean pantallaColor;
    /**
     * Tipo de teléfono: almeja, slice, normal
     */
    private String tipoFono;

    public Tradicional(boolean pantallaColor, String tipoFono, int codigoAntena, int peso, int duracionBateria) {
        super(codigoAntena, peso, duracionBateria);
        this.pantallaColor = pantallaColor;
        this.tipoFono = tipoFono;
    }

    public Tradicional(boolean pantallaColor, String tipoFono, int codigoAntena, int peso, int duracionBateria, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono, int costoEquipo) {
        super(codigoAntena, peso, duracionBateria, compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono, costoEquipo);
        this.pantallaColor = pantallaColor;
        this.tipoFono = tipoFono;
    }

    public boolean isPantallaColor() {
        return pantallaColor;
    }

    public void setPantallaColor(boolean pantallaColor) {
        this.pantallaColor = pantallaColor;
    }

    public String getTipoFono() {
        return tipoFono;
    }

    public void setTipoFono(String tipoFono) {
        this.tipoFono = tipoFono;
    }

    @Override
    public String toString() {
        return "Tradicional{" + "pantallaColor=" + pantallaColor + ", tipoFono=" + tipoFono +", "+super.toString()+'}';
    }    
    
    
    
}
