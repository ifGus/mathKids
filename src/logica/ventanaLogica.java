/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import complementos.puntosJugador;
import dimensionesEscala.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import ventanaPrincipal.*;
import complementos.*;

/**
 *
 * @author Gustavo
 */
public class ventanaLogica extends JFrame implements ActionListener {

    private JLabel labelTitulo, labelLogica, labelPuntos, labelPuntosNum, labelCaritas;
    private JButton botonSi, botonNo, botonHome;
    private DimensionesPantalla pantalla;
    private juegoLogico logico;
    private int puntaje;
    private puntosJugador sumaPuntos;

    public ventanaLogica() {
        setUndecorated(true);
        
        setLayout(null);
        logico = new juegoLogico();
        pantalla = new DimensionesPantalla();
        getContentPane().setBackground(Color.BLACK);
        
        puntaje = 0; // Para poder asignar desde una base de datos
        sumaPuntos = new puntosJugador(puntaje);

        refrescarDatosNuevos();

        setBounds(0, 0, pantalla.horizontal(), pantalla.vertical());
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelTitulo = new JLabel("JUEGO DE LÓGICA");
        labelTitulo.setBounds(pantalla.PenX(30), pantalla.PenY(2), pantalla.PenX(70), pantalla.PenY(20));
        labelTitulo.setFont(new Font("Arial", 3, 80));
        labelTitulo.setForeground(Color.red);
        add(labelTitulo);

        labelLogica = new JLabel(logico.logicaGenerada());
        labelLogica.setBounds(pantalla.PenX(25), pantalla.PenY(30), pantalla.PenX(70), pantalla.PenY(20));
        labelLogica.setFont(new Font("Arial", 0, 70));
        labelLogica.setForeground(Color.PINK);
        add(labelLogica);

        labelPuntos = new JLabel("PUNTOS");
        labelPuntos.setBounds(pantalla.PenX(75), 0, pantalla.PenX(20), pantalla.PenY(10));
        labelPuntos.setFont(new Font("Arial", 1, 40));
        labelPuntos.setForeground(Color.PINK);
        add(labelPuntos);

        labelPuntosNum = new JLabel(""+puntaje);
        labelPuntosNum.setBounds(pantalla.PenX(85), 0, pantalla.PenX(20), pantalla.PenY(10));
        labelPuntosNum.setFont(new Font("Arial", 1, 40));
        labelPuntosNum.setForeground(Color.PINK);
        add(labelPuntosNum);
        
        labelCaritas = new JLabel(";)");
        labelCaritas.setBounds(pantalla.PenX(45F), pantalla.PenY(20F), pantalla.PenX(20F), pantalla.PenY(10F));
        labelCaritas.setFont(new Font("Arial", 1, 100));
        labelCaritas.setForeground(Color.MAGENTA);
        add(labelCaritas);

        botonSi = new JButton("SI");
        botonSi.setBounds(pantalla.PenX(35), pantalla.PenY(60), pantalla.PenX(10), pantalla.PenY(10));
        botonSi.setBackground(Color.GREEN);
        botonSi.setFont(new Font("Arial", 2,25));
        add(botonSi);
        botonSi.addActionListener(this);

        botonNo = new JButton("NO");
        botonNo.setBounds(pantalla.PenX(50), pantalla.PenY(60), pantalla.PenX(10), pantalla.PenY(10));
        botonNo.setBackground(Color.RED);
        botonNo.setFont(new Font("Arial", 2,25));
        add(botonNo);
        botonNo.addActionListener(this);

        botonHome = new JButton("HOME");
        botonHome.setBounds(pantalla.PenX(5), pantalla.PenY(80), pantalla.PenX(10), pantalla.PenY(10));
        add(botonHome);
        botonHome.addActionListener(this);

    }

    private void refrescarDatosNuevos() {

        logico = new juegoLogico();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonSi) {

            puntaje = sumaPuntos.puntos(logico.puntos(true));//Con true el jugador dice que la lógica es verdadera
            labelPuntosNum.setText(""+puntaje);
            if(logico.puntos(true)){
                labelCaritas.setText(":)");
            } else labelCaritas.setText(":'(");
            refrescarDatosNuevos();
            labelLogica.setText(logico.logicaGenerada());

        }
        if (e.getSource() == botonNo) {

            puntaje = sumaPuntos.puntos(logico.puntos(false)); //con false el jugador dice qla lógica es falsa
            labelPuntosNum.setText("" + puntaje);
            
            if(logico.puntos(false)){
                labelCaritas.setText(":)");
            } else labelCaritas.setText(":'(");
            
            refrescarDatosNuevos();
            labelLogica.setText(logico.logicaGenerada());
        }
        if (e.getSource() == botonHome) {
            new VentanaMenu().setVisible(true);
            setVisible(false);
        }
    }
}
