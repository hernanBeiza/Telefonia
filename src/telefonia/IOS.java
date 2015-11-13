package telefonia;

public class IOS extends SmartPhone{
    /**
     * 1,2,3,4,5,6
     */
    private String modelo;

    public IOS(String modelo, String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria) {
        super(versionSO, cantidadmemoria, codigoAntena, peso, duracionBateria);
        this.modelo = modelo;
    }

    public IOS(String modelo, String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono) {
        super(versionSO, cantidadmemoria, codigoAntena, peso, duracionBateria, compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "IOS{" + "modelo=" + modelo + '}';
    }
    
    

    
    
    

}
