package telefonia;

public abstract class SmartPhone extends Movil{
    
    private String versionSO;
    private int cantidadmemoria;

    public SmartPhone(String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria) {
        super(codigoAntena, peso, duracionBateria);
        this.versionSO = versionSO;
        this.cantidadmemoria = cantidadmemoria;
    }

    public SmartPhone(String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono, int costoEquipo) {
        super(codigoAntena, peso, duracionBateria, compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono, costoEquipo);
        this.versionSO = versionSO;
        this.cantidadmemoria = cantidadmemoria;
    }

    public String getVersionSO() {
        return versionSO;
    }

    public void setVersionSO(String versionSO) {
        this.versionSO = versionSO;
    }

    public int getCantidadmemoria() {
        return cantidadmemoria;
    }

    public void setCantidadmemoria(int cantidadmemoria) {
        this.cantidadmemoria = cantidadmemoria;
    }

    @Override
    public String toString() {
        return "SmartPhone{" + "versionSO=" + versionSO + ", cantidadmemoria=" + cantidadmemoria + ", " +super.toString()+'}';
    }
    
    
    
    
    

}
