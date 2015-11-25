package telefonia;
//Implements Impuestos, ServicioTecnico
public abstract class Telefonia implements ServicioTecnico, Impuestos{
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
    private int costoEquipo;

    public Telefonia() {
    }

    public Telefonia(Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono,int costoEquipo) {
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
        this.costoEquipo = costoEquipo;
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

    public int getCostoEquipo() {
        return costoEquipo;
    }

    public void setCostoEquipo(int costoEquipo) {
        this.costoEquipo = costoEquipo;
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
    public boolean aplicaServicio() {
        //Si ya está en el servicio técnico, no aplica. 
        if(planTelefonico.isEstadoServicioTecnico()){
            return false;
        } else {
            //Se lleva por primera vez
            planTelefonico.setEstadoServicioTecnico(true);
            return true;
        }        
    }

    //Cálculo de impuestos
    @Override
    public float pagarServicioTecnico() {
        //37% del valor del aparato... ¿Dónde nos piden el valor del aparato? Se agregó una propiedad, costoEquipo
        float valor = (float)0.37*this.getCostoEquipo();        
        return valor;
    }

    @Override
    public float impuestoAplicado() {        
        int cantidadMinutosUsados = getCantidadMinutosUsadosFijos()+getCantidadMinutosUsadosMovil();
        if(cantidadMinutosUsados>100){
            return impEsp;
        } else {
            return impNormal;
        }
    }

    @Override
    public float pagoPorMinutosUsados() {
        float totalPagar = getValorMinutoMovil()*getCantidadMinutosUsadosMovil()+getValorMinutoFijo()*getCantidadMinutosUsadosFijos();
        return totalPagar;
    }

    @Override
    public float totalAPagar() {
        return pagoPorMinutosUsados()+getTarifaFija() - descuento()+impuestoAplicado();
    }
    @Override
    public float descuento() {
        float elDescuento = 0.0f;
        return elDescuento;
    }
    
    @Override
    public String toString() {
        return "Telefonia{" + "compania=" + compania + ", usuario=" + usuario + ", region=" + region + ", comuna=" + comuna + ", fechaContrato=" + fechaContrato + ", valorMinutoFijo=" + valorMinutoFijo + ", valorMinutoMovil=" + valorMinutoMovil + ", tarifaFija=" + tarifaFija + ", cantidadMinutosUsadosFijos=" + cantidadMinutosUsadosFijos + ", cantidadMinutosUsadosMovil=" + cantidadMinutosUsadosMovil + ", planTelefonico=" + planTelefonico + ", numeroFono=" + numeroFono + ", costoEquipo=" + costoEquipo + '}';
    }
    
}
