package telefonia;

public interface Impuestos {
    /**
     * Si el consumo de minutos es menor a 100
     */
    public static final float impNormal = 0.13f;
    /**
     * Si el consumo de minutos sobrepasa los 100
     */
    public static final float impEsp = 0.19f;
    /**
     * Se calcula al pagoPorMinutosUsados:  si el consumo de minutos es menos de 100 minutos  corresponde al impNormal; 
     * si sobrepasa los 100 minutos, corresponde al impEsp
     * @return monto a cancelar por impuestos 
     */    
    public float impuestoAplicado();
    /**
     * (valorMinutoFijo*cantidadMinutosUsadosFijo +valorMinutoMovil *cantidadMinutosUsadosMovil)
     * @return retorna el monto a pagar por la cantidad de minutos usados 
     */
    public float pagoPorMinutosUsados();
    /**
     * calcula y devuelve el total del monto a pagar, el que corresponde a, 
     * pagoPorMinutosUsados+tarifaFija – descuento+impuestoAplicado(donde corresponda).
     * @return calcula y devuelve el total del monto a pagar
     */
    public float totalAPagar();
    /**
     * método que retorna el monto a descontar en el pagoPorMinutosUsados: 
     * Si es Comercial y posee más de 100 anexos descuenta un 7%, 
     * si es privado y el total de minutos móvil + minutos fijo es menor a 50 se descuenta un 9%, 
     * si es tradicional y el plan es económico se descuenta un 17%
     * @return monto a descontar
     */
    public float descuento();
}
