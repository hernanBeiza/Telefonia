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
public class PlanTelefonico {
    /**
     * alfanumérico, forma ABC123, todo al azar
     */
    private String codigo;
    /**
     * económico, normal, premium
     */
    private String tipoPlan;
    private String nombrePlan;
    private int valorPlan;
    /**
     * indica si se le aplicó servicio técnico al dispositivo
     */
    private boolean estadoServicioTecnico;

    public PlanTelefonico() {
    
    }

    public PlanTelefonico(String codigo, String tipoPlan, String nombrePlan, int valorPlan, boolean estadoServicioTecnico) {
        this.codigo = codigo;
        this.tipoPlan = tipoPlan;
        this.nombrePlan = nombrePlan;
        this.valorPlan = valorPlan;
        this.estadoServicioTecnico = estadoServicioTecnico;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public int getValorPlan() {
        return valorPlan;
    }

    public void setValorPlan(int valorPlan) {
        this.valorPlan = valorPlan;
    }

    public boolean isEstadoServicioTecnico() {
        return estadoServicioTecnico;
    }

    public void setEstadoServicioTecnico(boolean estadoServicioTecnico) {
        this.estadoServicioTecnico = estadoServicioTecnico;
    }

    @Override
    public String toString() {
        return "PlanTelefonico{" + "codigo=" + codigo + ", tipoPlan=" + tipoPlan + ", nombrePlan=" + nombrePlan + ", valorPlan=" + valorPlan + ", estadoServicioTecnico=" + estadoServicioTecnico + '}';
    }
    
    
    
    
}
