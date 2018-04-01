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

    private JLabel labelTitulo, labelLogica, labelPuntos, labelCaritas, labelVidas, labelNivel, labelIntentos, labelFondo;
    private JButton botonSi, botonNo, botonHome, botonEmpezarNuevo;
    private DimensionesPantalla pantalla;
    private juegoLogico logico;
    private int puntaje, nivel,intentos;
    private byte vidas;
    private puntosJugador sumaPuntos;
    private nivelYVidas nivelVidas;
    
    //Fondo de pantalla
    private ImageIcon fondo, propiedadesFondo;

    public ventanaLogica() {
        
        setUndecorated(true);

        setLayout(null);
        //logico = new juegoLogico();
        pantalla = new DimensionesPantalla();
        getContentPane().setBackground(Color.BLACK);
        setTitle("Logica - Si - No");
        //FONDO DE PANTALLA
        labelFondo = new JLabel();
        labelFondo.setSize(new DimensionesPantalla().PenX(100), new DimensionesPantalla().PenY(100));
        fondo = new ImageIcon(getClass().getResource("images/animadoJuego1.gif"));
        propiedadesFondo = new ImageIcon(fondo.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
        labelFondo.setIcon(propiedadesFondo);
        setBounds(-10, 0, new DimensionesPantalla().PenX(100F), new DimensionesPantalla().PenY(100F));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        add(labelFondo);

        //ESTADO INICIAL DEL JUEGO
        puntaje = 0; // Para poder asignar desde una base de datos
        vidas = 3;// Para poder asignar desde una base de datos
        nivel = 1;// Para poder asignar desde una base de datos
        intentos = 0; // Para poder asignar desde una base de datos
        
        sumaPuntos = new puntosJugador(puntaje);

        refrescarDatosNuevos();

        setBounds(0, 0, pantalla.horizontal(), pantalla.vertical());
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelTitulo = new JLabel("JUEGO DE LÓGICA");
        labelTitulo.setBounds(0, pantalla.PenY(5), pantalla.PenX(100), pantalla.PenY(20));
        labelTitulo.setFont(new Font("Algerian", 1, 80));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setForeground(new Color(53, 231,53));
        labelFondo.add(labelTitulo);

        labelVidas = new JLabel("Vidas: " + vidas);
        labelVidas.setBounds(0, pantalla.PenY(1), pantalla.PenX(33), pantalla.PenY(5));
        labelVidas.setFont(new Font("Andale Mono", 1, 30));
        labelVidas.setForeground(Color.ORANGE);
        labelVidas.setHorizontalAlignment(SwingConstants.CENTER);
        labelFondo.add(labelVidas);

        labelNivel = new JLabel("Nivel: " + nivel);
        labelNivel.setBounds(pantalla.PenX(33), pantalla.PenY(1), pantalla.PenX(33), pantalla.PenY(5));
        labelNivel.setFont(new Font("Andale Mono", 1, 30));
        labelNivel.setForeground(Color.ORANGE);
        labelNivel.setHorizontalAlignment(SwingConstants.CENTER);
        labelFondo.add(labelNivel);
        
        labelPuntos = new JLabel("Puntaje: "+puntaje);
        labelPuntos.setBounds(pantalla.PenX(66), pantalla.PenY(1), pantalla.PenX(33), pantalla.PenY(5));
        labelPuntos.setFont(new Font("Arial", 1, 30));
        labelPuntos.setForeground(Color.ORANGE);
        labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
        labelFondo.add(labelPuntos);

        labelLogica = new JLabel(logico.logicaGenerada());
        labelLogica.setBounds(0, pantalla.PenY(30), pantalla.PenX(100), pantalla.PenY(20));
        labelLogica.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogica.setFont(new Font("Arial", 1, 70));
        labelLogica.setForeground(Color.cyan);
        labelFondo.add(labelLogica);
    
        labelCaritas = new JLabel(";)");
        labelCaritas.setBounds(0, pantalla.PenY(20F), pantalla.PenX(100), pantalla.PenY(10));
        labelCaritas.setFont(new Font("Andale Mono", 1, 75));
        labelCaritas.setForeground(Color.MAGENTA);
        labelCaritas.setHorizontalAlignment(SwingConstants.CENTER);
        labelFondo.add(labelCaritas);

        botonSi = new JButton("SI");
        botonSi.setBounds(pantalla.PenX(35), pantalla.PenY(60), pantalla.PenX(10), pantalla.PenY(10));
        botonSi.setFont(new Font("Arial", 1, 70));
        botonSi.setCursor(new Cursor(HAND_CURSOR));
        botonSi.setOpaque(false);
        botonSi.setContentAreaFilled(false);
        botonSi.setForeground(Color.GREEN);
        labelFondo.add(botonSi);
        botonSi.addActionListener(this);

        botonNo = new JButton("NO");
        botonNo.setBounds(pantalla.PenX(55), pantalla.PenY(60), pantalla.PenX(10), pantalla.PenY(10));
        botonNo.setFont(new Font("Arial", 1, 70));
        labelFondo.add(botonNo);
        botonNo.setCursor(new Cursor(HAND_CURSOR));
        botonNo.setOpaque(false);
        botonNo.setContentAreaFilled(false);
        botonNo.setForeground(Color.RED);
        botonNo.addActionListener(this);

        botonHome = new JButton("HOME");
        botonHome.setBounds(pantalla.PenX(5), pantalla.PenY(80), pantalla.PenX(10), pantalla.PenY(10));
        labelFondo.add(botonHome);
        botonHome.setForeground(Color.YELLOW);
        botonHome.setFont(new Font("", 1, 30));
        botonHome.setBackground(new Color(86, 73, 27));
        botonHome.setCursor(new Cursor(HAND_CURSOR));
        botonHome.addActionListener(this);
        botonHome.setOpaque(false); // Vuelve transparente al boton
        botonHome.setContentAreaFilled(false);//Quita el fondo al pulsar
        //botonHome.setBorderPainted(false);
        
        //Este boton no esta siendo usado por ahora//////////////////////
        botonEmpezarNuevo = new JButton("Empezar de nuevo");
        botonEmpezarNuevo.setBounds(pantalla.PenX(80), pantalla.PenY(80), pantalla.PenX(10), pantalla.PenY(10)); 
        botonEmpezarNuevo.setEnabled(false);
        botonEmpezarNuevo.addActionListener(this);
        //labelFondo.add(botonEmpezarNuevo);////////////////////////////
        
        labelIntentos = new JLabel(""+intentos);
        labelIntentos.setBounds(pantalla.PenX(90), pantalla.PenY(80), pantalla.PenX(20), pantalla.PenY(20));
        labelIntentos.setForeground(new Color(87, 69, 8));
        labelIntentos.setFont(new Font("Andale Mono", 1, 100));
        labelFondo.add(labelIntentos);

    }

    private void refrescarDatosNuevos() {

        logico = new juegoLogico(nivel);
        nivelVidas = new nivelYVidas(puntaje, vidas, false, intentos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonSi) {
            puntaje = sumaPuntos.puntos(logico.puntos(true));//Con true el jugador dice que la lógica es verdadera
            labelPuntos.setText("Puntaje: " + puntaje);
            
            if (logico.puntos(true)) {
                labelCaritas.setText(":)");
            } else {
                labelCaritas.setText(":'(");
            }         
            //CONTROL DE LAS VIDAS Y EL NIVEL
            intentos ++;
            nivelVidas = new nivelYVidas(puntaje, vidas, logico.puntos(true), intentos);
            vidas = nivelVidas.vidas();
            nivel = nivelVidas.nivel();
            labelNivel.setText("Nivel: " + nivel);
            labelVidas.setText("Vidas: " + vidas);
            
            if(vidas==0){
                labelLogica.setForeground(Color.red);
                labelLogica.setText("Perdiste el juego...");                
                botonSi.setEnabled(false);
                botonNo.setEnabled(false);
                botonEmpezarNuevo.setEnabled(true);//ojo            
            }
            else{
                refrescarDatosNuevos();
                labelLogica.setText(logico.logicaGenerada());
            }     
            
            labelIntentos.setText(""+intentos);
            
        }
        if (e.getSource() == botonNo) {

            puntaje = sumaPuntos.puntos(logico.puntos(false)); //con false el jugador dice que la lógica es falsa
            labelPuntos.setText("Puntaje: " + puntaje);

            if (logico.puntos(false)) {
                labelCaritas.setText(":)");
            } else {
                labelCaritas.setText(":'(");
            }
            
            labelLogica.setText(logico.logicaGenerada());

            //CONTROL DE LAS VIDAS Y EL NIVEL
            intentos ++;
            nivelVidas = new nivelYVidas(puntaje, vidas, logico.puntos(false),intentos);
            vidas = nivelVidas.vidas();
            nivel = nivelVidas.nivel();
            labelNivel.setText("Nivel: " + nivel);
            labelVidas.setText("Vidas: " + vidas);
            
            if(vidas==0){
                labelLogica.setForeground(Color.red);
                labelLogica.setText("Perdiste el juego...");
                botonSi.setEnabled(false);
                botonNo.setEnabled(false);
                botonEmpezarNuevo.setEnabled(true);  
                
            }else{
            refrescarDatosNuevos();
            labelLogica.setText(logico.logicaGenerada());
            }      
            
            labelIntentos.setText(""+intentos);
        }
        
        if(e.getSource()==botonEmpezarNuevo){
            nivel = 1;
            vidas = 3;
            puntaje = 0;
            sumaPuntos.puntos(false);
            
            labelLogica.setForeground(Color.CYAN);
            
            refrescarDatosNuevos();
            sumaPuntos = new puntosJugador(puntaje); //Reinicia puntos
            
            botonSi.setEnabled(true);
            botonNo.setEnabled(true);
            intentos = 0;
            
            labelLogica.setText(logico.logicaGenerada());
            labelIntentos.setText(""+intentos);
            labelVidas.setText("Vidas: "+vidas);
            labelNivel.setText("Nivel: "+nivel);
            labelPuntos.setText("Puntos: "+puntaje );
            
            botonEmpezarNuevo.setEnabled(false);
        }
        
        if (e.getSource() == botonHome) {
            new VentanaMenu().setVisible(true);
            setVisible(false);
        }      
        
        if(nivel == 6){
                new Campeon("juego2").setVisible(true);
                setVisible(false);
            }
        
        if(vidas == 0){
        
            new Perdedor("juego2").setVisible(true);
            setVisible(false);
        
        }
    }
}