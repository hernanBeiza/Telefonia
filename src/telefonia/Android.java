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
public class Android extends SmartPhone {
    private String marcaFono;

    public Android(String marcaFono, String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria) {
        super(versionSO, cantidadmemoria, codigoAntena, peso, duracionBateria);
        this.marcaFono = marcaFono;
    }

    public Android(String marcaFono, String versionSO, int cantidadmemoria, int codigoAntena, int peso, int duracionBateria, Compania compania, Usuario usuario, String region, String comuna, String fechaContrato, int valorMinutoFijo, int valorMinutoMovil, float tarifaFija, int cantidadMinutosUsadosFijos, int cantidadMinutosUsadosMovil, PlanTelefonico planTelefonico, String numeroFono) {
        super(versionSO, cantidadmemoria, codigoAntena, peso, duracionBateria, compania, usuario, region, comuna, fechaContrato, valorMinutoFijo, valorMinutoMovil, tarifaFija, cantidadMinutosUsadosFijos, cantidadMinutosUsadosMovil, planTelefonico, numeroFono);
        this.marcaFono = marcaFono;
    }

    public String getMarcaFono() {
        return marcaFono;
    }

    public void setMarcaFono(String marcaFono) {
        this.marcaFono = marcaFono;
    }

    @Override
    public String toString() {
        return "Android{" + "marcaFono=" + marcaFono + '}';
    }
    
    

}
