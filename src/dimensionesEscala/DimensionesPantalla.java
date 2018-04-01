
package dimensionesEscala;

import java.awt.Dimension;
import java.awt.Toolkit;
/**
 *
 * @author Gustavo
 */
public class DimensionesPantalla {
    //Dimensiones automáticas a escala
    private int TamPanX;
    private int TamPanY;
    private float a;
    private float b;
    private int x;
    private int y;
    private int X;
    private int Y; 
    
    private Toolkit ventanaDimension;
    private Dimension dimensiones;
    
    public DimensionesPantalla(){
    //DIMENSIONES
        ventanaDimension = Toolkit.getDefaultToolkit();
        dimensiones = ventanaDimension.getScreenSize();//Le pasamos las dimensiones de pantalla a dimensiones
        
        TamPanX = dimensiones.width;//IOptenemos las dimensiones de la pantalla (X = Horizontal)
        TamPanY = dimensiones.height;//OPtenemos las dimensiones de la pantalla (Y = Vertical)
        a = ((float) TamPanX)*1F;//Tamaño horizontal en float *0.25F
        b = ((float)(TamPanY))*1F;//Tamaño horizontal en float *0.731489F
        x = (int)Math.round(a);//Se enviarán para la interfaz
        y = (int)Math.round(b);//Se enviarán para la interfaz
    }
    
   public int horizontal(){  //DEVUELVE LA DIMENSION EN X EQUIVALENTE DEL DISEÑO
       
      return x;
       
   }
   public int vertical(){//DEVUELVE LA DIMENSION EN Y EQUIVALENTE DEL DISEÑO
      return y;
   }
   
   public int PenX(float porcentaje){//DEVUELVE LAS DIMENSIONES EQUIVALENTES A LOS PORCENTAJES INGRESADOS (X)
       float aux = porcentaje/100;
       float valor = aux*x;
       X = (int)Math.round(valor);
       return X;
   }
   public int PenY(float porcentaje){//DEVUELVE LAS DIMENSIONES EQUIVALENTES A LOS PORCENTAJES INGRESADOS (Y)
       float aux = porcentaje/100;
       float valor = aux*y;
       Y = (int)Math.round(valor);
       return Y;
   }
}