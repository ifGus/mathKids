
package ventanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import dimensionesEscala.*;
import ordenamiento.*;
import logica.*;
import complementos.*;
import operacionesmk.operaciones;

/**
 *
 * @author Gustavo
 */

public class VentanaMenu extends JFrame implements ActionListener {

    private JButton botonJuego1, botonJuego2, botonJuego3, botonJuego4, botonSalir;
    private JLabel labelTitulo;
    private VentanaOrdenarNumeros ordenar;
    private ventanaLogica logica;
    private ImageIcon imagen;
    private Icon escala;
   
    private ImageIcon imagenEscalado;
    private DimensionesPantalla dimPan;


       public  VentanaMenu() {
        
           
        setUndecorated(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Esta es la ventana principal");
        getContentPane().setBackground(new Color(71,57,8));
        
        
        setBounds(0, 0, new DimensionesPantalla().PenX(100), new DimensionesPantalla().PenY(100));
        
        //TITULO DEL MENU
        dimPan = new DimensionesPantalla();
        labelTitulo = new JLabel();
        labelTitulo.setBounds(dimPan.PenX(15), dimPan.PenY(0), dimPan.PenX(70), dimPan.PenY(20));
        imagen = new ImageIcon(getClass().getResource("images/tituloMenuPrincipal.png"));
        imagenEscalado = new ImageIcon(imagen.getImage().getScaledInstance(labelTitulo.getWidth(), labelTitulo.getHeight(), Image.SCALE_DEFAULT));
        labelTitulo.setIcon(imagenEscalado);
        this.add(labelTitulo);
 
        botonJuego1 = new JButton();
        botonJuego1.setLocation(new DimensionesPantalla().PenX(7), new DimensionesPantalla().PenY(20));
        botonJuego1.setSize(new DimensionesPantalla().PenX(40), new DimensionesPantalla().PenY(35));
        imagen = new ImageIcon("src/ventanaPrincipal/images/juego1of.png");
        escala = new ImageIcon(imagen.getImage().getScaledInstance(botonJuego1.getWidth(), botonJuego1.getHeight(), Image.SCALE_DEFAULT));
        botonJuego1.setIcon(escala);
        botonJuego1.setBorder(null);
        botonJuego1.setBackground(null);
        botonJuego1.addActionListener(this);
        add(botonJuego1);
        
        
        botonJuego2 = new JButton();
        botonJuego2.setBounds(dimPan.PenX(52), dimPan.PenY(20), dimPan.PenX(40), dimPan.PenY(35));
        imagen = new ImageIcon("src/ventanaPrincipal/images/juego2of.png");
        escala = new ImageIcon(imagen.getImage().getScaledInstance(botonJuego2.getWidth(), botonJuego2.getHeight(), Image.SCALE_DEFAULT));
        botonJuego2.setIcon(escala);
        botonJuego2.setBorder(null);
        botonJuego2.setBackground(null);
        botonJuego2.addActionListener(this);
        add(botonJuego2);

        botonJuego3 = new JButton("JUEGO 3");
        botonJuego3.setLocation(new DimensionesPantalla().PenX(7), new DimensionesPantalla().PenY(60));
        botonJuego3.setSize(new DimensionesPantalla().PenX(40), new DimensionesPantalla().PenY(30));
        botonJuego3.addActionListener(this);
        add(botonJuego3);

        botonJuego4 = new JButton("JUEGO 4");
        botonJuego4.setLocation(new DimensionesPantalla().PenX(52), new DimensionesPantalla().PenY(60));
        botonJuego4.setSize(new DimensionesPantalla().PenX(40), new DimensionesPantalla().PenY(30));
        add(botonJuego4);
        
        botonSalir = new JButton();
        botonSalir.setBounds(new DimensionesPantalla().PenX(85F), new DimensionesPantalla().PenY(5F), new DimensionesPantalla().PenX(8F), new DimensionesPantalla().PenY(12F));
        imagen = new ImageIcon("src/ventanaPrincipal/images/salir.png");
        escala = new ImageIcon(imagen.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_DEFAULT));
        botonSalir.setIcon(escala); 
        botonSalir.setBorder(null);
        botonSalir.setSelectedIcon(null);
        botonSalir.addActionListener(this);
        botonSalir.setToolTipText("PRESIONA PARA SALIR DEL JUEGO");
        botonSalir.setOpaque(false);
        botonSalir.setContentAreaFilled(false);
        botonSalir.setBorderPainted(false);
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
            ordenar = new VentanaOrdenarNumeros();  
            ordenar.setVisible(true);
            setVisible(false);
        }
        
        if(e.getSource()==botonJuego2){
            
            logica = new ventanaLogica();
            logica.setVisible(true);
            setVisible(false);
        }
        
        if(e.getSource()==botonJuego3){
            operaciones x=new operaciones();
            x.setVisible(true);
        }
        if(e.getSource()==botonJuego4){
        
        
        }

        if (e.getSource() == botonSalir) {
            System.exit(0);
        }
    }
}
