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

public class NivelJugador {
    private byte nivel;
    private int puntos;
    
    public NivelJugador ( ){
        nivel = 0;
    }
    
    public NivelJugador (String  puntaje){
        this.nivel = 0;
        this.puntos = Integer.parseInt(puntaje);
    }

    
    public String nivel(){
        
        
        if(puntos <500){
            nivel = 0;
        }
        if(puntos >=500 && puntos<1000){
            nivel = 1;
        }        
        if(puntos >=1000 && puntos<1500){
            nivel = 2;
        }
        
        if(puntos >=1500 && puntos<=2000){
            nivel = 3;
        }
      
        return ""+nivel;
    }  
}