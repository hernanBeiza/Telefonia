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
public class Privado implements Impuestos {
    private Compania compania;
    private Usuario usuario;
    
    private int numeroFono;
    private int codigoZona;

    private int region;
    private int comuna;
    
    private String fechaContrato;
    private int valorMinutoFijo;
    private int valorMinutoMovil;
    private int tarifaFija;
    private int identificadorLlamada;
    private int cantidadMinutosUsadosFijo;
    private PlanTelefonico planTelefonico;
    private int cantidadMinutosUsadosMovil;

    public Privado() {
    }

    public Privado(Compania compania, Usuario usuario, int numeroFono, int codigoZona, int region, int comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, int tarifaFija, int identificadorLlamada, int cantidadMinutosUsadosFijo, PlanTelefonico planTelefonico, int cantidadMinutosUsadosMovil) {
        this.compania = compania;
        this.usuario = usuario;
        this.numeroFono = numeroFono;
        this.codigoZona = codigoZona;
        this.region = region;
        this.comuna = comuna;
        this.fechaContrato = fechaContrato;
        this.valorMinutoFijo = valorMinutoFijo;
        this.valorMinutoMovil = valorMinutoMovil;
        this.tarifaFija = tarifaFija;
        this.identificadorLlamada = identificadorLlamada;
        this.cantidadMinutosUsadosFijo = cantidadMinutosUsadosFijo;
        this.planTelefonico = planTelefonico;
        this.cantidadMinutosUsadosMovil = cantidadMinutosUsadosMovil;
    }

    @Override
    public float impuestoAplicado() {
        return 0.0f;
    }

    @Override
    public float pagoPorMinutosUsados() {
        return 0.0f;
    }

    @Override
    public float totalAPagar() {
        return 0.0f;
    }

    @Override
    public float descuento() {
        return 0.0f;
    }
    
    
    
    
    
}
