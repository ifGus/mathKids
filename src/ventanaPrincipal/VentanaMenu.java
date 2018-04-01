
package ventanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import dimensionesEscala.*;
import ordenamiento.*;
import logica.*;
import dimensionesEscala.*;

/**
 *
 * @author Gustavo
 */

public class VentanaMenu extends JFrame implements ActionListener {

    private JButton botonJuego1, botonJuego2, botonJuego3, botonJuego4, botonSalir;
    private JLabel labelTitulo, lavelPiePagina;
    private JuegoOrdenarNumeros ordenar;
    private ventanaLogica jdl;
    private ImageIcon imagen;
    private Icon escala;
    //private JuegoDeLogica logica;
   // private 

       public  VentanaMenu() {
        
           
        setUndecorated(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Esta es la ventana principal");
        getContentPane().setBackground(Color.BLACK);
        setBounds(0, 0, new DimensionesPantalla().PenX(100), new DimensionesPantalla().PenY(100));
        
 
        labelTitulo = new JLabel("AQUI VA EL TITULO DEL JUEGO");
        labelTitulo.setBounds(new DimensionesPantalla().PenX(15), new DimensionesPantalla().PenY(5), new DimensionesPantalla().PenX(80), new DimensionesPantalla().PenY(10));
        labelTitulo.setForeground(Color.MAGENTA);
        labelTitulo.setFont(new Font("Arial", 4, 80));
        add(labelTitulo);
        
        botonJuego1 = new JButton();
        botonJuego1.setLocation(new DimensionesPantalla().PenX(5), new DimensionesPantalla().PenY(20));
        botonJuego1.setSize(new DimensionesPantalla().PenX(40), new DimensionesPantalla().PenY(35));
        imagen = new ImageIcon("src/ventanaPrincipal/images/juego1.png");
        escala = new ImageIcon(imagen.getImage().getScaledInstance(botonJuego1.getWidth(), botonJuego1.getHeight(), Image.SCALE_DEFAULT));
        botonJuego1.setIcon(escala);
        botonJuego1.setBorder(null);
        botonJuego1.setBackground(null);
        botonJuego1.addActionListener(this);
        add(botonJuego1);
        botonJuego2 = new JButton("JUEGO 2");
        botonJuego2.setLocation(new DimensionesPantalla().PenX(55), new DimensionesPantalla().PenY(20));
        botonJuego2.setSize(new DimensionesPantalla().PenX(40), new DimensionesPantalla().PenY(30));
        botonJuego2.addActionListener(this);
        add(botonJuego2);

        botonJuego3 = new JButton("JUEGO 3");
        botonJuego3.setLocation(new DimensionesPantalla().PenX(5), new DimensionesPantalla().PenY(60));
        botonJuego3.setSize(new DimensionesPantalla().PenX(40), new DimensionesPantalla().PenY(30));
        add(botonJuego3);

        botonJuego4 = new JButton("JUEGO 4");
        botonJuego4.setLocation(new DimensionesPantalla().PenX(55), new DimensionesPantalla().PenY(60));
        botonJuego4.setSize(new DimensionesPantalla().PenX(40), new DimensionesPantalla().PenY(30));
        add(botonJuego4);
        
        botonSalir = new JButton();
        botonSalir.setBounds(new DimensionesPantalla().PenX(85F), new DimensionesPantalla().PenY(5F), new DimensionesPantalla().PenX(8F), new DimensionesPantalla().PenY(12F));
        imagen = new ImageIcon("src/ventanaPrincipal/images/salir.png");
        escala = new ImageIcon(imagen.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_DEFAULT));
        botonSalir.setIcon(escala); 
        botonSalir.setBorder(null);
        botonSalir.setBackground(null);
        botonSalir.setSelectedIcon(null);
        botonSalir.addActionListener(this);
        botonSalir.setToolTipText("PRESIONA PARA SALIR DEL JUEGO");
        add(botonSalir);
        
  
    }

    public static void main(String[] args) {

        VentanaMenu ventanaMenu = new VentanaMenu();
        
        
        //ventanaMenu.setExtendedState(Frame.MAXIMIZED_BOTH);
        ventanaMenu.setVisible(true);
        ventanaMenu.setResizable(false);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonJuego1) {
            //instanciacion de los juegos
            ordenar = new JuegoOrdenarNumeros();  
            ordenar.setVisible(true);
            setVisible(false);
        }
        
        if(e.getSource()==botonJuego2){
            
           jdl = new ventanaLogica();
            jdl.setVisible(true);
            setVisible(false);
            
            //new JuegoDeLogica().makeFrame();
            
        }

        if (e.getSource() == botonSalir) {
            System.exit(0);
        }
    }
}

