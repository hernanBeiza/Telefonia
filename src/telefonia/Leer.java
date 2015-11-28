
package telefonia;

import java.io.*;
class Leer
{    
    public static String dato()
    {    String sdato="";
        try
        {    InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader flujoe=new BufferedReader(isr);
            sdato=flujoe.readLine();
        }
        catch(IOException e)
        {
             System.err.println("Error: "+ e.getMessage());
        }
        return(sdato);
    }
    public static char datoChar()
    {
        try
        {
            char resp=dato().charAt(0);
            return(resp);
        }
        catch(Exception error)
        {
            return('z');
        }
    }
    public static int datoInt()
    {
        try
        {    return (Integer.parseInt(dato()));
        }
        catch(NumberFormatException error)
        {
            return(Integer.MIN_VALUE);
        }
    }
    public static byte datoByte()
    {
        try
        {    return (Byte.parseByte(dato()));
        }
        catch(NumberFormatException error)
        {
            return(Byte.MIN_VALUE);
        }
    }
    public static boolean datoBoolean()
    {
        try
        {    return (Boolean.parseBoolean(dato()));
        }
        catch(NumberFormatException error)
        {
            return(false);
        }
    }       
    public static short datoShort()
    {
        try
        {
            return (Short.parseShort(dato()));
        }
        catch(NumberFormatException error)
        {
            return(Short.MIN_VALUE);
        }
    }
    public static long datoLong()
    {
        try
        {
            return (Long.parseLong(dato()));
        }
        catch(NumberFormatException error)
        {
            return(Long.MIN_VALUE);
        }
    }   
    public static float datoFloat()
    {
        try
        {    Float f =new Float(dato());
            return (f.floatValue());
        }
        catch(NumberFormatException error)
        {
            return(Float.NaN);
        }
    }   
    public static double datoDouble()
    {
        try
        {    Double f =new Double(dato());
            return (f.doubleValue());
        }
        catch(NumberFormatException error)
        {
            return(Double.NaN);
        }
    }
}

