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
public interface ServicioTecnico {
    
    /**
     * corresponde si un fono fue llevado al servicio técnico o no
     * Un fono solo puede ir 1 vez al servicio técnico
     */
    void aplicaServicio();
    /**
     * método que retorna monto a pagar por servicio técnico, que corresponde al 
     * 37 % del valor del aparato
     */
    float pagarServicioTecnico();
}
