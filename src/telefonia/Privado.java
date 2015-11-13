package telefonia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hernanBeiza
 */
public class Privado extends Fijo{
    
    private boolean identificadorLlamada;

    public Privado(boolean identificadorLlamada) {
        this.identificadorLlamada = identificadorLlamada;
    }

    public Privado(boolean identificadorLlamada, int codigoZona) {
        super(codigoZona);
        this.identificadorLlamada = identificadorLlamada;
    }

    public Privado(boolean identificadorLlamada, int codigoZona, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono) {
        super(codigoZona, compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono);
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
        return "Privado{" + "identificadorLlamada=" + identificadorLlamada + '}';
    }
    
    
    
    
    
    
}
