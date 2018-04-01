/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complementos;

import com.sun.awt.AWTUtilities;
import javax.swing.*;
import dimensionesEscala.*;
import java.awt.*;
import java.awt.event.*;
//import javafx.scene.paint.ColorBuilder;
import logica.ventanaLogica;
import ordenamiento.VentanaOrdenarNumeros;
import ventanaPrincipal.*;
import logica.*;
import ordenamiento.*;
/**
 *
 * @author Gustavo
 */
public class Perdedor extends JFrame implements ActionListener {
    
    private DimensionesPantalla dimPan;
    private JLabel labelLastima, labelPerdedor, labelEmo1;
    private ImageIcon imagen, propiedades;
    private JButton botonVolverHome, botonReiniciar;
    private String nombreJuego;
    
    public Perdedor(String nombreJuego){
        this.nombreJuego = nombreJuego;
        setUndecorated(true);
        setLayout(null);
        
        getContentPane().setBackground(Color.RED);
        
        
        dimPan = new DimensionesPantalla();
        labelPerdedor = new JLabel("PERDISTE");
        labelPerdedor.setBounds(0,dimPan.PenY(5),dimPan.PenX(100), dimPan.PenY(30));
        labelPerdedor.setFont(new Font("New Times Roman", 1, 200));
        labelPerdedor.setForeground(Color.YELLOW);
        labelPerdedor.setHorizontalAlignment(SwingConstants.CENTER);
        add(labelPerdedor);
        
        //Cambio de fondo de pantalla
        labelLastima = new JLabel();
        labelLastima.setBounds(dimPan.PenX(0),dimPan.PenY(0),dimPan.horizontal(), dimPan.vertical());
        imagen = new ImageIcon(getClass().getResource("images/burlaDeHomero.gif"));
        propiedades = new ImageIcon(imagen.getImage().getScaledInstance(labelLastima.getWidth(), labelLastima.getHeight(), Image.SCALE_DEFAULT));
        labelLastima.setIcon(propiedades);
        setBounds(0, 0, new DimensionesPantalla().PenX(100F), new DimensionesPantalla().PenY(100F));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        add(labelLastima);
        
         //Emoticos
        labelEmo1 = new JLabel();
        labelEmo1.setBounds(dimPan.PenX(5), dimPan.PenY(80), dimPan.PenX(10), dimPan.PenY(9));
        imagen = new ImageIcon(getClass().getResource("images/que paso....gif"));
        propiedades = new ImageIcon(imagen.getImage().getScaledInstance(labelEmo1.getWidth(), labelEmo1.getHeight(), Image.SCALE_DEFAULT));
        labelEmo1.setIcon(propiedades);
        setBounds(0, 0, new DimensionesPantalla().PenX(100F), new DimensionesPantalla().PenY(100F));
        labelLastima.add(labelEmo1);
        
        botonVolverHome = new JButton("VOLVER AL MENU PRINCIPAL");
        botonVolverHome.setBounds(dimPan.PenX(1),dimPan.PenY(95),dimPan.PenX(20), dimPan.PenY(5));
        botonVolverHome.addActionListener(this);
        botonVolverHome.setForeground(Color.GREEN);
        botonVolverHome.setFont(new Font("Arial", 1, 15));
        botonVolverHome.setHorizontalAlignment(SwingConstants.LEFT);
        botonVolverHome.setOpaque(false);
        botonVolverHome.setContentAreaFilled(false);
        labelLastima.add(botonVolverHome);
        
        botonReiniciar = new JButton("VOLVER A JUGAR");
        botonReiniciar.setBounds(dimPan.PenX(1), dimPan.PenY(90), dimPan.PenX(20), dimPan.PenY(5));
        botonReiniciar.addActionListener(this);
        botonReiniciar.setForeground(Color.GREEN);
        botonReiniciar.setHorizontalAlignment(SwingConstants.LEFT);
        botonReiniciar.setFont(new Font("Arial", 1, 15));
        botonReiniciar.setOpaque(false);
        botonReiniciar.setContentAreaFilled(false);
        labelLastima.add(botonReiniciar);
        
        AWTUtilities.setWindowOpaque(this, false);
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