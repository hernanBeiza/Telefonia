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
public class Movil extends Telefonia{
    private Compania compania;
    private Usuario usuario;
    private String numeroFono;
    private String codigoAntena;

    private int region;
    private int comuna;
    
    private String fechaContrato;
    
    private int valorMinutoFijo;
    private int valorMinutoMovil;
    private int tarifaFija;
    
    private float peso;
    private int duracionBateria;
    
    private PlanTelefonico planTelefonico;
    private int cantidadMinutosUsadosFijo;
    private int cantidadMinutosUsadosMovil;

    public Movil() {
        
    }

    public Movil(Compania compania, Usuario usuario, String numeroFono, String codigoAntena, int region, int comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, int tarifaFija, float peso, int duracionBateria, PlanTelefonico planTelefonico, int cantidadMinutosUsadosFijo, int cantidadMinutosUsadosMovil) {
        this.compania = compania;
        this.usuario = usuario;
        this.numeroFono = numeroFono;
        this.codigoAntena = codigoAntena;
        this.region = region;
        this.comuna = comuna;
        this.fechaContrato = fechaContrato;
        this.valorMinutoFijo = valorMinutoFijo;
        this.valorMinutoMovil = valorMinutoMovil;
        this.tarifaFija = tarifaFija;
        this.peso = peso;
        this.duracionBateria = duracionBateria;
        this.planTelefonico = planTelefonico;
        this.cantidadMinutosUsadosFijo = cantidadMinutosUsadosFijo;
        this.cantidadMinutosUsadosMovil = cantidadMinutosUsadosMovil;
    }

    public Compania getCompania() {
        return compania;
    }

    public void setCompania(Compania compania) {
        this.compania = compania;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNumeroFono() {
        return numeroFono;
    }

    public void setNumeroFono(String numeroFono) {
        this.numeroFono = numeroFono;
    }

    public String getCodigoAntena() {
        return codigoAntena;
    }

    public void setCodigoAntena(String codigoAntena) {
        this.codigoAntena = codigoAntena;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public int getValorMinutoFijo() {
        return valorMinutoFijo;
    }

    public void setValorMinutoFijo(int valorMinutoFijo) {
        this.valorMinutoFijo = valorMinutoFijo;
    }

    public int getValorMinutoMovil() {
        return valorMinutoMovil;
    }

    public void setValorMinutoMovil(int valorMinutoMovil) {
        this.valorMinutoMovil = valorMinutoMovil;
    }

    public int getTarifaFija() {
        return tarifaFija;
    }

    public void setTarifaFija(int tarifaFija) {
        this.tarifaFija = tarifaFija;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getDuracionBateria() {
        return duracionBateria;
    }

    public void setDuracionBateria(int duracionBateria) {
        this.duracionBateria = duracionBateria;
    }

    public PlanTelefonico getPlanTelefonico() {
        return planTelefonico;
    }

    public void setPlanTelefonico(PlanTelefonico planTelefonico) {
        this.planTelefonico = planTelefonico;
    }

    public int getCantidadMinutosUsadosFijo() {
        return cantidadMinutosUsadosFijo;
    }

    public void setCantidadMinutosUsadosFijo(int cantidadMinutosUsadosFijo) {
        this.cantidadMinutosUsadosFijo = cantidadMinutosUsadosFijo;
    }

    public int getCantidadMinutosUsadosMovil() {
        return cantidadMinutosUsadosMovil;
    }

    public void setCantidadMinutosUsadosMovil(int cantidadMinutosUsadosMovil) {
        this.cantidadMinutosUsadosMovil = cantidadMinutosUsadosMovil;
    }

    @Override
    public String toString() {
        return "Movil{" + "compania=" + compania + ", usuario=" + usuario + ", numeroFono=" + numeroFono + ", codigoAntena=" + codigoAntena + ", region=" + region + ", comuna=" + comuna + ", fechaContrato=" + fechaContrato + ", valorMinutoFijo=" + valorMinutoFijo + ", valorMinutoMovil=" + valorMinutoMovil + ", tarifaFija=" + tarifaFija + ", peso=" + peso + ", duracionBateria=" + duracionBateria + ", planTelefonico=" + planTelefonico + ", cantidadMinutosUsadosFijo=" + cantidadMinutosUsadosFijo + ", cantidadMinutosUsadosMovil=" + cantidadMinutosUsadosMovil + '}';
    }
    
    
    
    
    
    
}
