/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefonia;

/**
 *
 * @author hernanBeiza
 */
public class Telefonia {
    private Compania compania;
    private Usuario usuario;
    private String region;
    private String comuna;
    private String fechaContrato;
    private int valorMinutoFijo;
    private int valorMinutoMovil;
    private float tarifaFija;
    private int cantidadMinutosUsadosFijos;
    private int cantidadMinutosUsadosMovil;
    private PlanTelefonico planTelefonico;
    private String numeroFono;

    public Telefonia() {
    }

    public Telefonia(Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono) {
        this.compania = compania;
        this.usuario = usuario;
        this.region = region;
        this.comuna = comuna;
        this.fechaContrato = fechaContrato;
        this.valorMinutoFijo = valorMinutoFijo;
        this.valorMinutoMovil = valorMinutoMovil;
        this.tarifaFija = tarifaFija;
        this.cantidadMinutosUsadosFijos = cantidadMinutosUsadosFijos;
        this.cantidadMinutosUsadosMovil = cantidadMinutosUsadosMovil;
        this.planTelefonico = planTelefonico;
        this.numeroFono = numeroFono;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
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

    public float getTarifaFija() {
        return tarifaFija;
    }

    public void setTarifaFija(float tarifaFija) {
        this.tarifaFija = tarifaFija;
    }

    public int getCantidadMinutosUsadosFijos() {
        return cantidadMinutosUsadosFijos;
    }

    public void setCantidadMinutosUsadosFijos(int cantidadMinutosUsadosFijos) {
        this.cantidadMinutosUsadosFijos = cantidadMinutosUsadosFijos;
    }

    public int getCantidadMinutosUsadosMovil() {
        return cantidadMinutosUsadosMovil;
    }

    public void setCantidadMinutosUsadosMovil(int cantidadMinutosUsadosMovil) {
        this.cantidadMinutosUsadosMovil = cantidadMinutosUsadosMovil;
    }

    public PlanTelefonico getPlanTelefonico() {
        return planTelefonico;
    }

    public void setPlanTelefonico(PlanTelefonico planTelefonico) {
        this.planTelefonico = planTelefonico;
    }

    public String getNumeroFono() {
        return numeroFono;
    }

    public void setNumeroFono(String numeroFono) {
        this.numeroFono = numeroFono;
    }

    @Override
    public String toString() {
        return "Telefonia{" + "compania=" + compania + ", usuario=" + usuario + ", region=" + region + ", comuna=" + comuna + ", fechaContrato=" + fechaContrato + ", valorMinutoFijo=" + valorMinutoFijo + ", valorMinutoMovil=" + valorMinutoMovil + ", tarifaFija=" + tarifaFija + ", cantidadMinutosUsadosFijos=" + cantidadMinutosUsadosFijos + ", cantidadMinutosUsadosMovil=" + cantidadMinutosUsadosMovil + ", planTelefonico=" + planTelefonico + ", numeroFono=" + numeroFono + '}';
    }
    
    
}
