/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complementos;

import com.sun.awt.AWTUtilities;//transparencia de la ventana
import javax.swing.*;
import dimensionesEscala.*;
import java.awt.*;
import java.awt.event.*;
//import ordenamiento.VentanaOrdenarNumeros;
import ventanaPrincipal.*;
import logica.*;
import ordenamiento.*;

/**
 *
 * @author Gustavo
 */
public class Campeon extends JFrame implements ActionListener {

    private DimensionesPantalla dimPan;
    private String nombreJuego;
    private JLabel labelFelicidades, labelCampeon, labelEmo1;
    private ImageIcon imagen, propiedades;
    private JButton botonVolverHome, botonReiniciar;

    public Campeon(String juego) {

        nombreJuego = juego;
        setUndecorated(true);
        setLayout(null);

        getContentPane().setBackground(Color.BLACK);

        dimPan = new DimensionesPantalla();
        labelCampeon = new JLabel("CAMPEON!!!");
        labelCampeon.setBounds(0, dimPan.PenY(5), dimPan.PenX(100), dimPan.PenY(30));
        labelCampeon.setFont(new Font("New Times Roman", 1, 200));
        labelCampeon.setForeground(Color.YELLOW);
        labelCampeon.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelCampeon);

        //IMAGEN DE GANADOR
        labelFelicidades = new JLabel();
        labelFelicidades.setBounds(dimPan.PenX(20), dimPan.PenY(30), dimPan.PenX(60), dimPan.PenY(60));
        imagen = new ImageIcon(getClass().getResource("images/homeroAsustado.gif"));
        propiedades = new ImageIcon(imagen.getImage().getScaledInstance(labelFelicidades.getWidth(), labelFelicidades.getHeight(), Image.SCALE_DEFAULT));
        labelFelicidades.setIcon(propiedades);
        setBounds(0, 0, new DimensionesPantalla().PenX(100F), new DimensionesPantalla().PenY(100F));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        add(labelFelicidades);
        
        //Emoticos
        labelEmo1 = new JLabel();
        labelEmo1.setBounds(dimPan.PenX(5), dimPan.PenY(80), dimPan.PenX(10), dimPan.PenY(10));
        imagen = new ImageIcon(getClass().getResource("images/reverencia.gif"));
        propiedades = new ImageIcon(imagen.getImage().getScaledInstance(labelEmo1.getWidth(), labelEmo1.getHeight(), Image.SCALE_DEFAULT));
        labelEmo1.setIcon(propiedades);
        setBounds(0, 0, new DimensionesPantalla().PenX(100F), new DimensionesPantalla().PenY(100F));
        add(labelEmo1);


        botonVolverHome = new JButton("VOLVER AL MENU PRINCIPAL");
        botonVolverHome.setBounds(dimPan.PenX(1), dimPan.PenY(95), dimPan.PenX(20), dimPan.PenY(5));
        botonVolverHome.addActionListener(this);
        botonVolverHome.setForeground(Color.GREEN);
        botonVolverHome.setFont(new Font("Arial", 1, 15));
        botonVolverHome.setHorizontalAlignment(SwingConstants.LEFT);
        botonVolverHome.setOpaque(false);
        botonVolverHome.setContentAreaFilled(false);
        add(botonVolverHome);

        botonReiniciar = new JButton("VOLVER A JUGAR");
        botonReiniciar.setBounds(dimPan.PenX(1), dimPan.PenY(90), dimPan.PenX(20), dimPan.PenY(5));
        botonReiniciar.addActionListener(this);
        botonReiniciar.setForeground(Color.GREEN);
        botonReiniciar.setFont(new Font("Arial", 1, 15));
        botonReiniciar.setHorizontalAlignment(SwingConstants.LEFT);
        botonReiniciar.setOpaque(false);
        botonReiniciar.setContentAreaFilled(false);
        add(botonReiniciar);
        
        //AWTUtilities.setWindowOpaque(this, false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonVolverHome) {
            new VentanaMenu().setVisible(true);
            setVisible(false);
        } else {

            if (nombreJuego.equalsIgnoreCase("juego1")) {
                new VentanaOrdenarNumeros().setVisible(true);
                setVisible(false);
                
            }
            
            if (nombreJuego.equalsIgnoreCase("juego2")) {
                new ventanaLogica().setVisible(true);
                setVisible(false);
                
            }
            
            if (nombreJuego.equalsIgnoreCase("juego3")) {
                
                
            }
            if (nombreJuego.equalsIgnoreCase("juego4")) {
                
                
            }

        }

    }
}
