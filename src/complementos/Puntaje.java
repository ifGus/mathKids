/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complementos;

/**
 *
 * @author Gustavo
 */
public class Puntaje {
    
    private int puntuacion;
    private String puntos;
   // private boolean sumarPuntos;
    
    public Puntaje (){
    
    this.puntuacion = 0;
    this.puntos = "0"; 
        
    }
    
    public String puntos(boolean sumarPuntos){

        if(sumarPuntos){
        
            puntuacion+=100;
            puntos = ""+(puntuacion);
           // String.valueOf(numero);
        }
        
        else{
            //puntuacion-=50; reduce la puntuacion en caso de falla
            puntos = String.valueOf(puntuacion);
        }
        
        return puntos;
    }
    
}
