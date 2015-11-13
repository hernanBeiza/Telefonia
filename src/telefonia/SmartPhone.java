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
public class SmartPhone extends Movil{
    
    private String versionSO;
    private int cantidadmemoria;

    public SmartPhone(String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria) {
        super(codigoAntena, peso, duracionBateria);
        this.versionSO = versionSO;
        this.cantidadmemoria = cantidadmemoria;
    }

    public SmartPhone(String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono) {
        super(codigoAntena, peso, duracionBateria, compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono);
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
        return "SmartPhone{" + "versionSO=" + versionSO + ", cantidadmemoria=" + cantidadmemoria + '}';
    }
    
    
    
    
    

}
