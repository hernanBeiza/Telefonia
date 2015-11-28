package telefonia;

public abstract class Movil extends Telefonia{
    private int codigoAntena;
    private int peso;
    private int duracionBateria;

    public Movil(int codigoAntena, int peso, int duracionBateria) {
        this.codigoAntena = codigoAntena;
        this.peso = peso;
        this.duracionBateria = duracionBateria;
    }

    public Movil(int codigoAntena, int peso, int duracionBateria, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono, int costoEquipo) {
        super(compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono, costoEquipo);
        this.codigoAntena = codigoAntena;
        this.peso = peso;
        this.duracionBateria = duracionBateria;
    }


    public int getCodigoAntena() {
        return codigoAntena;
    }

    public void setCodigoAntena(int codigoAntena) {
        this.codigoAntena = codigoAntena;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getDuracionBateria() {
        return duracionBateria;
    }

    public void setDuracionBateria(int duracionBateria) {
        this.duracionBateria = duracionBateria;
    }

    @Override
    public String toString() {
        return "Movil{" + "codigoAntena=" + codigoAntena + ", peso=" + peso + ", duracionBateria=" + duracionBateria + ", "+super.toString()+'}';
    }
    
    
    
    
}
