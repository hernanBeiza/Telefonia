package telefonia;

public interface ServicioTecnico {
  /**
   * que corresponde si un fono fue llevado al servicio técnico o no(un fono solo puede ir 1 vez al servicio técnico). 
   * @return true si no lo han llevado antes. ¡Aplica!. false si ya lo llevaron. ¡No aplica!
   */
    boolean aplicaServicio();
    /**
     * método que retorna monto a pagar por servicio técnico, que corresponde al 
     * 37 % del valor del aparato
     */
    float pagarServicioTecnico();
}
