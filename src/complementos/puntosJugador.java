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
public class puntosJugador {

    private int puntos;
    private boolean sumarPuntos;

    public puntosJugador(int puntosActuales) {
        this.sumarPuntos = false;
        puntos = puntosActuales;

    }

    public int puntos(boolean sumarPuntos) {
        this.sumarPuntos = sumarPuntos;
        if (this.sumarPuntos) {
            puntos = puntos+10;
        }

        return this.puntos;
    }

}
