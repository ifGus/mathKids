package ordenamiento;

import complementos.Campeon;
import complementos.*;
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
public class VentanaOrdenarNumeros extends JFrame implements ActionListener {

    //Icono
    private Image icono;
    private Toolkit pantalla;

    private JButton botonHome, botonYa, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9, boton11, boton12, boton13, boton14, boton15, boton16, boton17, boton18, boton19;
    private JLabel labelTitulo, labelPuntos, labelLetraPuntos, labelGanaste, labelNivel, labelNivelNumeros, labelVidas, labelVidasNumeros, labelTipoDeOrden, labelMoneda;
    //private int x, y, uCx, uCy, uCxA, uCyA;
    private int ubiXfield, ubiYfield, tamXField, tamYfield; // Incluye la posicion de los botones
    private int tamNum;
    private DimensionesPantalla dimPan;

    private int numeroDeNumerosAleatorios;
    private numerosAleatorios numerosAleatorios;
    //private nivelYVidas nivelVidas;
    //private puntosJugador sumaPuntos;
    private int nivel, puntos, intentos;
    private byte vidas;
    private boolean bienHecho;

    private JLabel labelFondo, labelMono;
    private ImageIcon fondo, propiedadesFondo;

    private int[] arregloResuelto;
    
    String copiaCadena; 

    public VentanaOrdenarNumeros() {

        setUndecorated(true);//Elimina la barra de título
        
        //ESTADO INICIAL DEL JUEGO
        nivel = 1;
        puntos = 0;
        intentos = 0;// si es un juego guardado debe ser mayor a 0
        vidas = 3;
        numeroDeNumerosAleatorios = 2;
        //Nota, para guardar tambien se reguiere del tamaño del arreglo
        bienHecho = false;
        //nivelVidas = new nivelYVidas(puntos, vidas, bienHecho, intentos);
        //sumaPuntos = new puntosJugador(puntos);

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        dimPan = new DimensionesPantalla();
        setTitle("ORDENAR NUMEROS");

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
        setBounds(0, 0, dimPan.PenX(100F), dimPan.PenY(100F));
        setExtendedState(Frame.MAXIMIZED_BOTH);
        add(labelFondo);
        
        //mono
        labelMono = new JLabel();
        labelMono.setBounds(dimPan.PenX(77.5F), dimPan.PenY(72.5F), dimPan.PenX(15F), dimPan.PenY(15F));
        fondo = new ImageIcon(getClass().getResource("images/mono.gif"));
        propiedadesFondo = new ImageIcon(fondo.getImage().getScaledInstance(labelMono.getWidth(), labelMono.getHeight(), Image.SCALE_DEFAULT));
        labelMono.setIcon(propiedadesFondo);
        labelFondo.add(labelMono);
        
        //moneda
        /*
        labelMoneda = new JLabel();
        labelMoneda.setBounds(dimPan.PenX(73F), dimPan.PenY(41.5F), dimPan.PenX(5F), dimPan.PenY(7F));
        fondo = new ImageIcon(getClass().getResource("images/giphy.gif"));
        propiedadesFondo = new ImageIcon(fondo.getImage().getScaledInstance(labelMoneda.getWidth(), labelMoneda.getHeight(), Image.SCALE_DEFAULT));
        labelMoneda.setIcon(propiedadesFondo);
        labelFondo.add(labelMoneda);
        */
        

        dimPan = new DimensionesPantalla();
        ubiXfield = dimPan.PenX(2F);
        ubiYfield = dimPan.PenY(20F);
        tamXField = dimPan.PenX(10F);
        tamYfield = dimPan.PenY(10F);

        tamNum = 70;

       // probNegativo = 0;

        labelNivel = new JLabel("NIVEL:");
        labelNivel.setForeground(new Color(131, 85, 12));
        labelNivel.setFont(new Font("Arial", 1, 30));
        labelNivel.setBounds(dimPan.PenX(30F), dimPan.PenY(0F), dimPan.PenX(10F), dimPan.PenY(5F));
        labelFondo.add(labelNivel);

        labelNivelNumeros = new JLabel("" + new nivelYVidas(puntos, vidas, bienHecho, intentos).nivel());
        labelNivelNumeros.setForeground(Color.ORANGE);
        labelNivelNumeros.setFont(new Font("Andale Mono", 1, 40));
        labelNivelNumeros.setBounds(dimPan.PenX(36F), dimPan.PenY(0F), dimPan.PenX(10F), dimPan.PenY(5F));
        labelFondo.add(labelNivelNumeros);

        labelVidas = new JLabel("VIDAS:");
        labelVidas.setForeground(new Color(131, 85, 12));
        labelVidas.setFont(new Font("Arial", 1, 30));
        labelVidas.setBounds(dimPan.PenX(60F), dimPan.PenY(0F), dimPan.PenX(10F), dimPan.PenY(5F));
        labelFondo.add(labelVidas);
        
        labelVidasNumeros = new JLabel("" +vidas);
        labelVidasNumeros.setForeground(Color.ORANGE);
        labelVidasNumeros.setFont(new Font("Arial", 1, 40));
        labelVidasNumeros.setBounds(dimPan.PenX(66F), dimPan.PenY(0F), dimPan.PenX(10F), dimPan.PenY(5F));
        labelFondo.add(labelVidasNumeros);

        labelTitulo = new JLabel("VELOCIDAD DE ORDENAMIENTO Y CONCENTRACIÓN");
        labelTitulo.setBounds(dimPan.PenX(5F), dimPan.PenY(7F), 10000, 80);
        labelTitulo.setFont(new Font("Arial", 1, 65));
        labelTitulo.setForeground(Color.ORANGE);
        labelFondo.add(labelTitulo);

        labelPuntos = new JLabel("" + puntos);
        labelPuntos.setBounds(dimPan.PenX(90F), dimPan.PenY(40F), dimPan.PenX(10F), dimPan.PenY(10F));
        labelPuntos.setFont(new Font("Andale Mono", 1, 70));
        labelPuntos.setForeground(Color.ORANGE);
        labelFondo.add(labelPuntos);

        labelLetraPuntos = new JLabel("PUNTAJE:");
        labelLetraPuntos.setBounds(dimPan.PenX(78F), dimPan.PenY(40F), dimPan.PenX(15F), dimPan.PenY(10F));
        labelLetraPuntos.setFont(new Font("Andale Mono", 1, 30));
        labelLetraPuntos.setForeground(Color.WHITE);
        labelFondo.add(labelLetraPuntos);

        labelGanaste = new JLabel(";)");
        labelGanaste.setForeground(Color.YELLOW);
        labelGanaste.setFont(new Font("Andale Mono", 1, 80));
        labelGanaste.setBounds(dimPan.PenX(38F), dimPan.PenY(40F), dimPan.PenX(50F), dimPan.PenY(20F));
        labelFondo.add(labelGanaste);
        
        boton11 = new JButton();
        boton11.setBounds(ubiXfield, ubiYfield, tamXField, tamYfield);
        boton11.setFont(new Font("Andale Mono", 1, tamNum));
        boton11.setForeground(Color.MAGENTA);
        boton11.addActionListener(this);
        boton11.setBackground(new Color(212, 244, 191));
        boton11.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton11);

        boton12 = new JButton();
        boton12.setBounds(ubiXfield + dimPan.PenX(10.4F), ubiYfield, tamXField, tamYfield);
        boton12.setFont(new Font("Andale Mono", 1, tamNum));
        boton12.setForeground(Color.GREEN);
        boton12.addActionListener(this);
        boton12.setBackground(new Color(212, 244, 191));
        boton12.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton12);

        boton13 = new JButton();
        boton13.setBounds(ubiXfield + dimPan.PenX(20.9F), ubiYfield, tamXField, tamYfield);
        boton13.setFont(new Font("Andale Mono", 1, tamNum));
        boton13.setForeground(Color.MAGENTA);
        boton13.addActionListener(this);
        boton13.setBackground(new Color(212, 244, 191));
        boton13.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton13);

        boton14 = new JButton();
        boton14.setBounds(ubiXfield + dimPan.PenX(31.4F), ubiYfield, tamXField, tamYfield);
        boton14.setFont(new Font("Andale Mono", 1, tamNum));
        boton14.setForeground(Color.GREEN);
        boton14.addActionListener(this);
        boton14.setBackground(new Color(212, 244, 191));
        boton14.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton14);

        boton15 = new JButton();
        boton15.setBounds(ubiXfield + dimPan.PenX(41.9F), ubiYfield, tamXField, tamYfield);
        boton15.setFont(new Font("Andale Mono", 1, tamNum));
        boton15.setForeground(Color.MAGENTA);
        boton15.addActionListener(this);
        boton15.setBackground(new Color(212, 244, 191));
        boton15.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton15);

        boton16 = new JButton();
        boton16.setBounds(ubiXfield + dimPan.PenX(52.4F), ubiYfield, tamXField, tamYfield);
        boton16.setFont(new Font("Andale Mono", 1, tamNum));
        boton16.setForeground(Color.GREEN);
        boton16.addActionListener(this);
        boton16.setBackground(new Color(212, 244, 191));
        boton16.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton16);

        boton17 = new JButton();
        boton17.setBounds(ubiXfield + dimPan.PenX(62.9F), ubiYfield, tamXField, tamYfield);
        boton17.setFont(new Font("Andale Mono", 1, tamNum));
        boton17.setForeground(Color.MAGENTA);
        boton17.addActionListener(this);
        boton17.setBackground(new Color(212, 244, 191));
        boton17.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton17);

        boton18 = new JButton();
        boton18.setBounds(ubiXfield + dimPan.PenX(73.4F), ubiYfield, tamXField, tamYfield);
        boton18.setFont(new Font("Andale Mono", 1, tamNum));
        boton18.setForeground(Color.GREEN);
        boton18.addActionListener(this);
        boton18.setBackground(new Color(212, 244, 191));
        boton18.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton18);

        boton19 = new JButton();
        boton19.setBounds(ubiXfield + dimPan.PenX(83.9F), ubiYfield, tamXField, tamYfield);
        boton19.setFont(new Font("Andale Mono", 1, tamNum));
        boton19.setForeground(Color.MAGENTA);
        boton19.addActionListener(this);
        boton19.setBackground(new Color(212, 244, 191));
        boton19.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton19);

        //ARREGLO DADO
        boton1 = new JButton();
        boton1.setBounds(ubiXfield, ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton1.setFont(new Font("Andale Mono", 1, tamNum));
        boton1.setForeground(Color.GREEN);
        boton1.addActionListener(this);
        boton1.setBackground(new Color(128, 98, 12));
        boton1.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton1);

        boton2 = new JButton();
        boton2.setBounds(ubiXfield + dimPan.PenX(10.4F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton2.setFont(new Font("Andale Mono", 1, tamNum));
        boton2.setForeground(Color.MAGENTA);
        boton2.setBackground(null);
        boton2.addActionListener(this);
        boton2.setBackground(new Color(128, 98, 12));
        boton2.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton2);

        boton3 = new JButton();
        boton3.setBounds(ubiXfield + dimPan.PenX(20.9F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton3.setFont(new Font("Andale Mono", 1, tamNum));
        boton3.setForeground(Color.GREEN);
        boton3.setBackground(null);
        boton3.addActionListener(this);
        boton3.setBackground(new Color(128, 98, 12));
        boton3.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton3);

        boton4 = new JButton();
        boton4.setBounds(ubiXfield + dimPan.PenX(31.4F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton4.setFont(new Font("Andale Mono", 1, tamNum));
        boton4.setForeground(Color.MAGENTA);
        boton4.setBackground(null);
        boton4.addActionListener(this);
        boton4.setBackground(new Color(128, 98, 12));
        boton4.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton4);

        boton5 = new JButton();
        boton5.setBounds(ubiXfield + dimPan.PenX(41.9F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton5.setFont(new Font("Andale Mono", 1, tamNum));
        boton5.setForeground(Color.GREEN);
        boton5.setBackground(null);
        boton5.addActionListener(this);
        boton5.setBackground(new Color(128, 98, 12));
        boton5.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton5);

        boton6 = new JButton();
        boton6.setBounds(ubiXfield + dimPan.PenX(52.4F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton6.setFont(new Font("Andale Mono", 1, tamNum));
        boton6.setForeground(Color.MAGENTA);
        boton6.setBackground(null);
        boton6.addActionListener(this);
        boton6.setBackground(new Color(128, 98, 12));
        boton6.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton6);

        boton7 = new JButton();
        boton7.setBounds(ubiXfield + dimPan.PenX(62.9F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton7.setFont(new Font("Andale Mono", 1, tamNum));
        boton7.setForeground(Color.GREEN);
        boton7.setBackground(null);
        boton7.addActionListener(this);
        boton7.setBackground(new Color(128, 98, 12));
        boton7.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton7);

        boton8 = new JButton();
        boton8.setBounds(ubiXfield + dimPan.PenX(73.4F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton8.setFont(new Font("Andale Mono", 1, tamNum));
        boton8.setForeground(Color.MAGENTA);
        boton8.setBackground(null);
        boton8.addActionListener(this);
        boton8.setBackground(new Color(128, 98, 12));
        boton8.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton8);

        boton9 = new JButton();
        boton9.setBounds(ubiXfield + dimPan.PenX(83.9F), ubiYfield + dimPan.PenY(46F), tamXField, tamYfield);
        boton9.setFont(new Font("Andale Mono", 1, tamNum));
        boton9.setForeground(Color.GREEN);
        boton9.setBackground(null);
        boton9.addActionListener(this);
        boton9.setBackground(new Color(128, 98, 12));
        boton9.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(boton9);

        botonHome = new JButton("HOME");
        botonHome.setForeground(new Color(241, 196, 15));
        botonHome.setFont(new Font("Arial", 4, 50));
        botonHome.setBounds(dimPan.PenX(10F), dimPan.PenY(85F), dimPan.PenX(10F), dimPan.PenY(10F));
        botonHome.setBackground(new Color(148, 49, 38));
        botonHome.addActionListener(this);
        botonHome.setCursor(new Cursor(HAND_CURSOR));
        labelFondo.add(botonHome);

        botonYa = new JButton("YA!");
        botonYa.addActionListener(this);
        botonYa.setFont(new Font("Andale Mono", 4, 50));
        botonYa.setForeground(new Color(241, 196, 15));
        botonYa.setBackground(new Color(131, 85, 12));
        botonYa.setBounds(dimPan.PenX(80F), dimPan.PenY(85F), dimPan.PenX(10F), dimPan.PenY(10F));
        botonYa.setCursor(new Cursor(HAND_CURSOR));
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
        numerosAleatorios = new numerosAleatorios(numeroDeNumerosAleatorios, nivel); // le pasamos los parametros de numero de numeros aleatorios y prob de que sea negativo

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonYa) {
            
            int indice = 0;
            boolean bienHecho;
            arregloResuelto = new int[numeroDeNumerosAleatorios];//int[]arregloResuelto = new int[numeroDeNumerosAleatorios];
            while (indice < numeroDeNumerosAleatorios) {
                if (indice == 0) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton11.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 1) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton12.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 2) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton13.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 3) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton14.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 4) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton15.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 5) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton16.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 6) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton17.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 7) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton18.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }
                if (indice == 8) {
                    try {
                        arregloResuelto[indice] = Integer.parseInt(boton19.getText());
                    } catch (Exception ex) {
                        arregloResuelto[indice] = -10000000;
                    }
                }

                indice++;

            }
            intentos++;
            bienHecho = numerosAleatorios.esCorrectoElOrden(arregloResuelto);
            puntos = new puntosJugador(puntos).puntos(bienHecho);
            nivel = new nivelYVidas(puntos, vidas, bienHecho, intentos).nivel();
            vidas = new nivelYVidas(puntos, vidas, bienHecho, intentos).vidas();
            
            if (bienHecho) {
                labelGanaste.setText("BIEN HECHO...   :)");
                //PUNTOS (+)
                labelGanaste.setForeground(Color.YELLOW);
                labelPuntos.setText("" + puntos);
                labelNivelNumeros.setText("" + nivel);

                if (numeroDeNumerosAleatorios == 9) { // CONTROLA LAS CASILLAS O ELL TAMAÑO DEL ARREGLO
                    numeroDeNumerosAleatorios = 2;
                } else {
                    numeroDeNumerosAleatorios++;
                }
                
                if(nivel == 6){//Campeon
                    Campeon cam = new Campeon("juego1");
                    cam.setVisible(true);
                    setVisible(false);     
                }

            } else {
                labelGanaste.setForeground(Color.RED);
                labelGanaste.setText("MAL...  :(");
                labelVidasNumeros.setText("" + vidas);

            }
            if (vidas <= 0) {
                labelTipoDeOrden.setText("PERDISTE");
                botonYa.setEnabled(false);
                //Primero limpia
            boton1.setText("");
            boton2.setText("");
            boton3.setText("");
            boton4.setText("");
            boton5.setText("");
            boton6.setText("");
            boton7.setText("");
            boton8.setText("");
            boton9.setText("");
            } else {
                //Primero limpia
            boton1.setText("");
            boton2.setText("");
            boton3.setText("");
            boton4.setText("");
            boton5.setText("");
            boton6.setText("");
            boton7.setText("");
            boton8.setText("");
            boton9.setText("");
                copiaDatos();
                labelTipoDeOrden.setText(numerosAleatorios.TipoDeOrden());
            }
            //LIMPIA LOS CAMPOS
            boton11.setText("");
            boton12.setText("");
            boton13.setText("");
            boton14.setText("");
            boton15.setText("");
            boton16.setText("");
            boton17.setText("");
            boton18.setText("");
            boton19.setText("");   
            
            if(vidas == 0){
                new Perdedor("juego1").setVisible(true);
                setVisible(false);
            }
            
        } //FIN DEL BOTONYA

        if (e.getSource() == botonHome) {
            new VentanaMenu().setVisible(true);
            setVisible(false);
        }
        
        //copia de informacion de los botones a la cadena copiaCadena
        if(e.getSource()==boton1){   
            copiaCadena = boton1.getText();
        }
        if(e.getSource()==boton2){   
            copiaCadena = boton2.getText();
        }
        if(e.getSource()==boton3){   
            copiaCadena = boton3.getText();
        }
        if(e.getSource()==boton4){   
            copiaCadena = boton4.getText();
        }
        if(e.getSource()==boton5){   
            copiaCadena = boton5.getText();
        }
        if(e.getSource()==boton6){   
            copiaCadena = boton6.getText();
        }
        if(e.getSource()==boton7){   
            copiaCadena = boton7.getText();
        }
        if(e.getSource()==boton8){   
            copiaCadena = boton8.getText();
        }
        if(e.getSource()==boton9){   
            copiaCadena = boton9.getText();
        }
        
        //Peda de informacion en los votones correspondientes
        if(e.getSource()==boton11){
            boton11.setText(copiaCadena);
            copiaCadena="";
        }
        if(e.getSource()==boton12){
            boton12.setText(copiaCadena);
            copiaCadena="";
        }
        if(e.getSource()==boton13){
            boton13.setText(copiaCadena);
            copiaCadena="";
        }
        if(e.getSource()==boton14){
            boton14.setText(copiaCadena);
            copiaCadena="";
        }
        if(e.getSource()==boton15){
            boton15.setText(copiaCadena);
            copiaCadena="";
        }
        if(e.getSource()==boton16){
            boton16.setText(copiaCadena);
            copiaCadena="";
        }
        if(e.getSource()==boton17){
            boton17.setText(copiaCadena);
            copiaCadena="";
        }
        if(e.getSource()==boton18){
            boton18.setText(copiaCadena);
            copiaCadena="";
        }
        if(e.getSource()==boton19){
            boton19.setText(copiaCadena);
            copiaCadena="";
        }

    }
}
