/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Gustavo
 */
public class juegoLogico {

    private int a, b, c, d, res1, res2, varAleatorio;
    private String operador1, operador2;
    private String comparador;
    private boolean res1MenorQue;
    private boolean sumarPuntos;

    public juegoLogico() {//Construimos
        
        sumarPuntos = false;
        res1MenorQue = true;

        a = (int) (Math.random() * 10);
        b = (int) (Math.random() * 10);
        c = (int) (Math.random() * 10);
        d = (int) (Math.random() * 10);

        

        varAleatorio = (int) (Math.random() * 100);//Pare generar un signo aleatoriamente (+ o -) primera operacion izquierda 
        if (varAleatorio < 50) {
            operador1 = "+";
        } else {
            operador1 = "-";
        }
        
        varAleatorio = (int) (Math.random() * 100);//Pare generar un signo aleatoriamente (+ o -) segunda operacion derecha
        if (varAleatorio < 50) {
            operador2 = "+";
        } else {
            operador2 = "-";
        }
        

        varAleatorio = (int) (Math.random() * 100);//Generamos otro número aleatorio, esta ves para decidir el comparador lógico
        if (varAleatorio < 50) {
            comparador = " menor que ";
        } else {
            comparador = " mayor que ";
        }
        
        if(operador1=="+"){//Inicializamos res1
            res1 = a+b;
        }else res1 = a-b;
        if(operador2=="+"){//Inicializamos res2
            res2 = c+d;
        }else res2 = c-d;
        System.out.println("a = "+a+"\nb = "+b+"\nc = "+c+"\nd = "+d+"\nComparador = "+comparador+"\nOperador1 = "+operador1+"\nOperador2 = "+operador2+"\nRes1 = "+res1+"\nRes2 = "+res2);

    }


    protected String logicaGenerada() {
        System.out.println("lo generado es: "+(a + operador1 + b + comparador + c+ operador2 + d));
        return ("¿"+a + operador1 + b +" es "+ comparador + c+ operador2 + d+"?"); // revisar aumentar operador generado
    }

    private void evaluaLogica() {

        if (res1 > res2 && comparador.equalsIgnoreCase(" menor que ")) {// si fuera falsa la afirmacion
            res1MenorQue = false;
        }

        if (res1 < res2 && comparador.equalsIgnoreCase(" mayor que ")) { //// si fuera falsa la afirmacion
            res1MenorQue = false;
        }
        
        //Caso especial
        if(res1==res2 && comparador.equalsIgnoreCase(" menor que ")){
            
            
        
        }

    }

    protected boolean puntos(boolean resJugador) {
        evaluaLogica();
        if (resJugador == res1MenorQue) {
            sumarPuntos = true;
        }
        System.out.println("Puntos = "+sumarPuntos);
        return this.sumarPuntos;
    }
}