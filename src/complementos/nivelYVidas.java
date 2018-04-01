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
public class nivelYVidas {

    private int nivel, puntos, intentos;
    private byte vidas;
    private boolean resultado;

    public nivelYVidas(int puntos, byte vidas, boolean resultado, int intentos) {

        this.puntos = puntos;
        this.vidas = vidas;
        this.nivel = 1;
        this.resultado = resultado;
        this.intentos = intentos;
    }

    public int nivel() {

        if (intentos > 0) {
            if (puntos < 800) {
                nivel = 1;
            }
            if (puntos >= 800 && puntos < 1600) {
                nivel = 2;
            }
            if (puntos >= 1600 && puntos < 2400) {
                nivel = 3;
            }
            if (puntos >= 2400 && puntos < 3200) {
                nivel = 4;
            }
            if (puntos >= 3200 && puntos < 3999) {
                nivel = 5;
            }
            if(puntos >= 4000){
                nivel = 6;
            }
        }

        return nivel;

    }

    public byte vidas() {

        if (intentos > 0) {
            if (!resultado && vidas > 0) {
                vidas--;
            }
        }

        return vidas;

    }
}
