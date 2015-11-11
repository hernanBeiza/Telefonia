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
public interface Cuenta {
    
    /**
     * muestra montos a pagar en detalle (pago por minutos usados, pago por impuestos), 
     * descuentos y monto total a cancelar. Además, toda la información asociada al fono que es relevante
     * para identificar a la compañía, usuario y fono
     */
    void mostrarCuentaCompleta();
    
    /**
     * muestra solo el nombre de usuario, número de teléfono y total a pagar.
     */
    void cuentaSimple();
    
}
