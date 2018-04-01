package ordenamiento;

import complementos.Puntaje;
import ventanaPrincipal.*;
import dimensionesEscala.DimensionesPantalla;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Gustavo
 */
public class JuegoOrdenarNumeros extends JFrame implements ActionListener {

    //Icono
    private Image icono;
    private Toolkit pantalla;

    private JTextField field1, field2, field3, field4, field5, field6, field7, field8, field9;//, field11, field12, field13, field14, field15, field16, field17, field18, field19;
    private JButton botonHome, botonEmpezar, botonYa, pausar, reanudar, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    private JLabel labelTitulo, labelPuntos, labelLetraPuntos, labelGanaste, labelNivel, labelNivelNumeros, labelVidas, labelVidasNumeros, labelTipoDeOrden;
    private int x, y, uCx, uCy, uCxA, uCyA;
    private int ubiXfield, ubiYfield, tamXField, tamYfield; // Incluye la posicion de los botones
    private int tamNum;
    private DimensionesPantalla dimPan;

    private int numeroDeNumerosAleatorios, probNegativo;
    private numerosAleatorios numerosAleatorios;
    private Puntaje puntaje;
    private int nivel, vidas, puntos;

    private String manejaValor;
    private Object manejaBoton;

    private JLabel labelFondo, labelGif1;
    private ImageIcon fondo, propiedadesFondo;
    private int []arregloResuelto;
    public JuegoOrdenarNumeros() {
        
        setUndecorated(true);
        nivel = 0;
        puntos = 0;
        vidas = 3;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        dimPan = new DimensionesPantalla();
        setTitle("REY PIDE: ordena los números según te lo pidan");

        //cambio de icono
        pantalla = Toolkit.getDefaultToolkit();
        icono = pantalla.getImage("src/ordenamiento/images/disney.png");
        setIconImage(icono);

        //Cambio de fondo de pantalla
        labelFondo = new JLabel();
        labelFondo.setSize(dimPan.horizontal(), dimPan.vertical());
        
        fondo = new ImageIcon(getClass().getResource("images/238.jpg"));
        propiedadesFondo = new ImageIcon(fondo.getImage().getScaledInstance(labelFondo.getWidth(), labelFondo.getHeight(), Image.SCALE_DEFAULT));
        labelFondo.setIcon(propiedadesFondo);
        setBounds(-10, 0, new DimensionesPantalla().PenX(100F), new DimensionesPantalla().PenY(100F));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        add(labelFondo);

        dimPan = new DimensionesPantalla();
        ubiXfield = dimPan.PenX(2F);
        ubiYfield = dimPan.PenY(20F);
        tamXField = dimPan.PenX(10F);
        tamYfield = dimPan.PenY(10F);

        tamNum = 70;
        
 
        numeroDeNumerosAleatorios = 2;
        probNegativo = 10;
        puntaje = new Puntaje(); //falta completar

        labelNivel = new JLabel("NIVEL:");
        labelNivel.setForeground(new Color(131, 85, 12));
        labelNivel.setFont(new Font("Arial", 1, 30));
        labelNivel.setBounds(dimPan.PenX(30F), dimPan.PenY(0F), dimPan.PenX(10F), dimPan.PenY(5F));
        labelFondo.add(labelNivel);
        
        labelNivelNumeros = new JLabel(""+nivel);
        labelNivelNumeros.setForeground(new Color(28, 203, 240));
        labelNivelNumeros.setFont(new Font("Andale Mono", 1, 40));
        labelNivelNumeros.setBounds(dimPan.PenX(36F), dimPan.PenY(0F), dimPan.PenX(10F), dimPan.PenY(5F));
        labelFondo.add(labelNivelNumeros);

        labelVidas = new JLabel("VIDAS:");
        labelVidas.setForeground(new Color(131, 85, 12));
        labelVidas.setFont(new Font("Arial", 1, 30));
        labelVidas.setBounds(dimPan.PenX(60F), dimPan.PenY(0F), dimPan.PenX(10F), dimPan.PenY(5F));
        labelFondo.add(labelVidas);
        
        labelVidasNumeros = new JLabel(""+vidas);
        labelVidasNumeros.setForeground(new Color(28, 203, 240));
        labelVidasNumeros.setFont(new Font("Arial", 1, 40));
        labelVidasNumeros.setBounds(dimPan.PenX(66F), dimPan.PenY(0F), dimPan.PenX(10F), dimPan.PenY(5F));
        labelFondo.add(labelVidasNumeros);

        labelTitulo = new JLabel("VELOCIDAD DE ORDENAMIENTO Y CONCENTRACIÓN");
        labelTitulo.setBounds(dimPan.PenX(5F), dimPan.PenY(7F), 10000, 80);
        labelTitulo.setFont(new Font("Arial", 1, 65));
        labelTitulo.setForeground(Color.MAGENTA);
        labelFondo.add(labelTitulo);

        labelPuntos = new JLabel("0");
        labelPuntos.setBounds(dimPan.PenX(90F), dimPan.PenY(40F), dimPan.PenX(10F), dimPan.PenY(10F));
        labelPuntos.setFont(new Font("Andale Mono", 1, 70));
        labelPuntos.setForeground(Color.ORANGE);
        labelFondo.add(labelPuntos);

        labelLetraPuntos = new JLabel("PUNTUACIÓN:");
        labelLetraPuntos.setBounds(dimPan.PenX(78F), dimPan.PenY(40F), dimPan.PenX(15F), dimPan.PenY(10F));
        labelLetraPuntos.setFont(new Font("Andale Mono", 1, 30));
        labelLetraPuntos.setForeground(Color.WHITE);
        labelFondo.add(labelLetraPuntos);

        labelGanaste = new JLabel("");
        labelGanaste.setForeground(Color.YELLOW);
        labelGanaste.setFont(new Font("Andale Mono", 1, 80));
        labelGanaste.setBounds(dimPan.PenX(38F), dimPan.PenY(40F), dimPan.PenX(50F), dimPan.PenY(20F));
        labelFondo.add(labelGanaste);

        field1 = new JTextField();
        field1.setBounds(ubiXfield, ubiYfield, tamXField, tamYfield);
        field1.setFont(new Font("Andale Mono", 1, tamNum));
        field1.setForeground(Color.MAGENTA);
        field1.setHorizontalAlignment(NORMAL); //field1.setHorizontalAlignment(SwingConstants.CENTER); Es otra forma de centrar el texto
        field1.setHorizontalAlignment(SwingConstants.CENTER);
        labelFondo.add(field1);

        field2 = new JTextField();
        field2.setBounds(ubiXfield + dimPan.PenX(10.4F), ubiYfield, tamXField, tamYfield);
        field2.setFont(new Font("Andale Mono", 1, tamNum));
        field2.setForeground(Color.GREEN);
        field2.setHorizontalAlignment(NORMAL);
        labelFondo.add(field2);

        field3 = new JTextField();
        field3.setBounds(ubiXfield + dimPan.PenX(20.9F), ubiYfield, tamXField, tamYfield);
        field3.setFont(new Font("Andale Mono", 1, tamNum));
        field3.setForeground(Color.MAGENTA);
        field3.setHorizontalAlignment(NORMAL);
        labelFondo.add(field3);

        field4 = new JTextField();
        field4.setBounds(ubiXfield + dimPan.PenX(31.4F), ubiYfield, tamXField, tamYfield);
        field4.setFont(new Font("Andale Mono", 1, tamNum));
        field4.setForeground(Color.GREEN);
        field4.setHorizontalAlignment(NORMAL);
        labelFondo.add(field4);

        field5 = new JTextField();
        field5.setBounds(ubiXfield + dimPan.PenX(41.9F), ubiYfield, tamXField, tamYfield);
        field5.setFont(new Font("Andale Mono", 1, tamNum));
        field5.setForeground(Color.MAGENTA);
        field5.setHorizontalAlignment(NORMAL);
        labelFondo.add(field5);

        field6 = new JTextField();
        field6.setBounds(ubiXfield + dimPan.PenX(52.4F), ubiYfield, tamXField, tamYfield);
        field6.setFont(new Font("Andale Mono", 1, tamNum));
        field6.setForeground(Color.GREEN);
        field6.setHorizontalAlignment(NORMAL);
        labelFondo.add(field6);

        field7 = new JTextField();
        field7.setBounds(ubiXfield + dimPan.PenX(62.9F), ubiYfield, tamXField, tamYfield);
        field7.setFont(new Font("Andale Mono", 1, tamNum));
        field7.setForeground(Color.MAGENTA);
        field7.setHorizontalAlignment(NORMAL);
        labelFondo.add(field7);

        field8 = new JTextField();
        field8.setBounds(ubiXfield + dimPan.PenX(73.4F), ubiYfield, tamXField, tamYfield);
        field8.setFont(new Font("Andale Mono", 1, tamNum));
        field8.setForeground(Color.GREEN);
        field8.setHorizontalAlignment(NORMAL);
        labelFondo.add(field8);

        field9 = new JTextField();
        field9.setBounds(ubiXfield + dimPan.PenX(83.9F), ubiYfield, tamXField, tamYfield);
        field9.setFont(new Font("Andale Mono", 1, tamNum));
        field9.setForeground(Color.MAGENTA);
        field9.setEditable(false);
        field9.setHorizontalAlignment(NORMAL);
        labelFondo.add(field9);

        //ARREGLO DADO
        boton1 = new JButton();
        boton1.setBounds(ubiXfield, ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton1.setFont(new Font("Andale Mono", 1, tamNum));
        boton1.setForeground(Color.GREEN);
        boton1.addActionListener(this);
        labelFondo.add(boton1);

        boton2 = new JButton();
        boton2.setBounds(ubiXfield + dimPan.PenX(10.4F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton2.setFont(new Font("Andale Mono", 1, tamNum));
        boton2.setForeground(Color.MAGENTA);
        boton2.setBackground(null);
        labelFondo.add(boton2);

        boton3 = new JButton();
        boton3.setBounds(ubiXfield + dimPan.PenX(20.9F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton3.setFont(new Font("Andale Mono", 1, tamNum));
        boton3.setForeground(Color.GREEN);
        boton3.setBackground(null);
        labelFondo.add(boton3);

        boton4 = new JButton();
        boton4.setBounds(ubiXfield + dimPan.PenX(31.4F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton4.setFont(new Font("Andale Mono", 1, tamNum));
        boton4.setForeground(Color.MAGENTA);
        boton4.setBackground(null);
        labelFondo.add(boton4);

        boton5 = new JButton();
        boton5.setBounds(ubiXfield + dimPan.PenX(41.9F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton5.setFont(new Font("Andale Mono", 1, tamNum));
        boton5.setForeground(Color.GREEN);
        boton5.setBackground(null);
        labelFondo.add(boton5);

        boton6 = new JButton();
        boton6.setBounds(ubiXfield + dimPan.PenX(52.4F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton6.setFont(new Font("Andale Mono", 1, tamNum));
        boton6.setForeground(Color.MAGENTA);
        boton6.setBackground(null);
        labelFondo.add(boton6);

        boton7 = new JButton();
        boton7.setBounds(ubiXfield + dimPan.PenX(62.9F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton7.setFont(new Font("Andale Mono", 1, tamNum));
        boton7.setForeground(Color.GREEN);
        boton7.setBackground(null);
        labelFondo.add(boton7);

        boton8 = new JButton();
        boton8.setBounds(ubiXfield + dimPan.PenX(73.4F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton8.setFont(new Font("Andale Mono", 1, tamNum));
        boton8.setForeground(Color.MAGENTA);
        boton8.setBackground(null);
        labelFondo.add(boton8);

        boton9 = new JButton();
        boton9.setBounds(ubiXfield + dimPan.PenX(83.9F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton9.setFont(new Font("Andale Mono", 1, tamNum));
        boton9.setForeground(Color.GREEN);
        boton9.setBackground(null);
        labelFondo.add(boton9);

        //numerosAleatorios.numerosOrdenados();
        botonHome = new JButton("HOME");
        botonHome.setForeground(new Color(241, 196, 15));
        botonHome.setFont(new Font("Arial", 4, 50));
        botonHome.setBounds(dimPan.PenX(10F), dimPan.PenY(85F), dimPan.PenX(10F), dimPan.PenY(10F));
        botonHome.setBackground(new Color(148, 49, 38));
        botonHome.addActionListener(this);
        labelFondo.add(botonHome);

        botonYa = new JButton("YA!");
        botonYa.addActionListener(this);
        botonYa.setFont(new Font("Andale Mono", 4, 50));
        botonYa.setForeground(new Color(241, 196, 15));
        botonYa.setBackground(new Color(131, 85, 12));
        botonYa.setBounds(dimPan.PenX(80F), dimPan.PenY(85F), dimPan.PenX(10F), dimPan.PenY(10F));
        labelFondo.add(botonYa);

        copiaDatos();

        labelTipoDeOrden = new JLabel(numerosAleatorios.TipoDeOrden());
        labelTipoDeOrden.setBounds(dimPan.PenX(30F), dimPan.PenY(50F), dimPan.PenX(50F), dimPan.PenY(20F));
        labelTipoDeOrden.setForeground(Color.WHITE);
        labelTipoDeOrden.setFont(new Font("Arial", 4, 35));
        labelFondo.add(labelTipoDeOrden);

    }

    private void copiaDatos() {  // ESTE MÉTODO SIRVE PARA COPIAR LOS DATOS  EN LA INTERFAZ GRÁFICA
        //ASIGNACION A LOS NUMEROS ALEATORIOS A LOS BOTONES
        int indice = 0;
        numerosAleatorios = new numerosAleatorios(numeroDeNumerosAleatorios, probNegativo); // le pasamos los parametros de numero de numeros aleatorios y prob de que sea negativo

        int[] arregloConAleatorios = numerosAleatorios.numerosAleatorios(); //Copia los datos del arreglo recibido en una arreglo interno
        while (indice < numeroDeNumerosAleatorios) {
            if (indice == 0) {
                boton1.setText("" + arregloConAleatorios[indice]);
            }

            if (indice == 1) {
                boton2.setText("" + arregloConAleatorios[indice]);
            }
            if (indice == 2) {
                boton3.setText("" + arregloConAleatorios[indice]);
            }
            if (indice == 3) {
                boton4.setText("" + arregloConAleatorios[indice]);
            }
            if (indice == 4) {
                boton5.setText("" + arregloConAleatorios[indice]);
            }
            if (indice == 5) {
                boton6.setText("" + arregloConAleatorios[indice]);
            }
            if (indice == 6) {
                boton7.setText("" + arregloConAleatorios[indice]);
            }
            if (indice == 7) {
                boton8.setText("" + arregloConAleatorios[indice]);
            }
            if (indice == 8) {
                boton9.setText("" + arregloConAleatorios[indice]);

            }

            indice++;
        }
           // arregloResuelto = new int [numeroDeNumerosAleatorios];
            //labelNivelNumeros.setText(puntaje.puntos(numerosAleatorios.esCorrectoElOrden(arregloResuelto))); // ARREGLAR
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonYa) {
            int indice = 0;
            arregloResuelto = new int[numeroDeNumerosAleatorios];//int[]arregloResuelto = new int[numeroDeNumerosAleatorios];
            while (indice < numeroDeNumerosAleatorios) {
                if (indice == 0) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field1.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 1) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field2.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 2) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field3.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 3) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field4.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 4) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field5.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 5) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field6.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 6) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field7.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 7) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field8.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 8) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(field9.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }

                indice++;

            }

            if (numerosAleatorios.esCorrectoElOrden(arregloResuelto)) {
                labelGanaste.setText("BIEN HECHO...   :)");
                //PUNTOS (+)
                labelGanaste.setForeground(Color.YELLOW);
                labelPuntos.setText(puntaje.puntos(numerosAleatorios.esCorrectoElOrden(arregloResuelto)));

            } else {
                labelGanaste.setForeground(Color.RED);
                labelGanaste.setText("MAL...  :(");
                //(Interfaz Gráfica) PUNTOS (-) 
                labelPuntos.setText(puntaje.puntos(numerosAleatorios.esCorrectoElOrden(arregloResuelto)));

            }

            copiaDatos();
            labelTipoDeOrden.setText(numerosAleatorios.TipoDeOrden());
            

        }

        if (e.getSource() == boton1) {
            manejaValor = boton1.getText();
            manejaBoton = boton1;
            boton1.setEnabled(false);

        }
        
        if(e.getSource()==botonHome){
            new VentanaMenu().setVisible(true);
            setVisible(false);
        }

        if (e.getSource() == field1) {
            botonHome.setEnabled(false);
        }
    }
 
}
