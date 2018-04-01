/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacionesmk;

/**
 *
 * @author user1
 */
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class operaciones extends JFrame {
    private  JLabel  labelTitulo,labelVidas,labelNvidas,labelPuntos,labelNpuntos,labelIgual,labelRes;
    private JButton buttonX,buttonY,buttonOP,buttonOK,buttonArr1,buttonArr2,buttonArr3,buttonArr4,buttonArr5,buttonArr6,buttonArr7,buttonArr8,buttonArr9,buttonYa,buttonOpSuma,buttonOpResta;
    private op generar;
    private int A[];
    public operaciones(){
         A=new int [9];
         generarVector();
           generar=new op(A);
        setLayout(null);
        setTitle("Operaciones =)");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.green);
        labelTitulo=new JLabel();
        labelTitulo.setBounds(10,50,500,100);
        labelTitulo.setFont(new Font("Arial",30,30));
        labelTitulo.setText("Selecciona los numeros");
        labelTitulo.setForeground(Color.red);
        add(labelTitulo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        labelVidas=new JLabel();
        labelVidas.setBounds(1500, 30, 300, 50);
        labelVidas.setFont(new Font("",20,20));
        labelVidas.setText("Vidas:");
        add(labelVidas);
        labelNvidas=new JLabel();
        labelNvidas.setBounds(1570, 30, 300, 50);
        labelNvidas.setFont(new Font("",20,20));
        labelNvidas.setText("3");
        add(labelNvidas);
        labelPuntos=new JLabel();
        labelPuntos.setBounds(1500,60, 300, 50);
        labelPuntos.setFont(new Font("",20,20));
        labelPuntos.setText("Puntos:");
        add(labelPuntos);
            labelNpuntos=new JLabel();
        labelNpuntos.setBounds(1580,60, 300, 50);
        labelNpuntos.setFont(new Font("",20,20));
        labelNpuntos.setText("0");
        add(labelNpuntos);
             labelIgual=new JLabel();
        labelIgual.setBounds(730,200, 100, 100);
        labelIgual.setFont(new Font("",50,50));
        labelIgual.setText("=");
        add(labelIgual);
       
        buttonX=new JButton();
        buttonX.setBounds(200, 200, 100, 100);
        buttonX.setFont(new Font("",40,40));
        buttonX.setText(generar.getX()+"");
        add(buttonX);
           buttonY=new JButton();
        buttonY.setBounds(600, 200, 100, 100);
        buttonY.setFont(new Font("",40,40));
        buttonY.setText(generar.getY()+"");
        add(buttonY);
              buttonOP=new JButton();
        buttonOP.setBounds(400, 200, 100, 100);
        buttonOP.setFont(new Font("",40,40));
        buttonOP.setText(generar.getOp()+"");
        add(buttonOP);
             labelRes=new JLabel();
        labelRes.setBounds(800,200,100,100);
        labelRes.setFont(new Font("Arial",50,50));
        labelRes.setText(generar.getRes()+"");
        add(labelRes);
        //EMPEZANDO A CREAR LOS BOTONES DEL ARREGLO
         buttonArr1=new JButton();
        buttonArr1.setBounds(1200, 150, 100, 100);
        buttonArr1.setFont(new Font("",40,40));
        buttonArr1.setText(A[0]+"");
        add(buttonArr1);
        //
        buttonArr2=new JButton();
        buttonArr2.setBounds(1340, 150, 100, 100);
        buttonArr2.setFont(new Font("",40,40));
        buttonArr2.setText(A[1]+"");
        add(buttonArr2);
        //
        buttonArr3=new JButton();
        buttonArr3.setBounds(1480, 150, 100, 100);
        buttonArr3.setFont(new Font("",40,40));
        buttonArr3.setText(A[2]+"");
        add(buttonArr3);
        //
        buttonArr4=new JButton();
        buttonArr4.setBounds(1200, 290, 100, 100);
        buttonArr4.setFont(new Font("",40,40));
        buttonArr4.setText(A[3]+"");
        add(buttonArr4);
        //
        buttonArr5=new JButton();
        buttonArr5.setBounds(1340, 290, 100, 100);
        buttonArr5.setFont(new Font("",40,40));
        buttonArr5.setText(A[4]+"");
        add(buttonArr5);
        //
        buttonArr6=new JButton();
        buttonArr6.setBounds(1480, 290, 100, 100);
        buttonArr6.setFont(new Font("",40,40));
        buttonArr6.setText(A[5]+"");
        add(buttonArr6);
        //
        buttonArr7=new JButton();
        buttonArr7.setBounds(1200, 430, 100, 100);
        buttonArr7.setFont(new Font("",40,40));
        buttonArr7.setText(A[6]+"");
        add(buttonArr7);
        //
        buttonArr8=new JButton();
        buttonArr8.setBounds(1340, 430, 100, 100);
        buttonArr8.setFont(new Font("",40,40));
        buttonArr8.setText(A[7]+"");
        add(buttonArr8);
        //
        buttonArr9=new JButton();
        buttonArr9.setBounds(1480, 430, 100, 100);
        buttonArr9.setFont(new Font("",40,40));
        buttonArr9.setText(A[8]+"");
        add(buttonArr9);
        /////
        buttonYa=new JButton();
        buttonYa.setBounds(1480, 800, 150, 150);
        buttonYa.setFont(new Font("",30,30));
        buttonYa.setText("LISTO!");
        buttonYa.setForeground(Color.blue);
        buttonYa.setBackground(Color.BLACK);
        add(buttonYa);
        //
         buttonOpSuma=new JButton();
        buttonOpSuma.setBounds(1280, 600, 100, 100);
        buttonOpSuma.setFont(new Font("",40,40));
        buttonOpSuma.setText("+");
        add(buttonOpSuma);
        //
        buttonOpResta=new JButton();
        buttonOpResta.setBounds(1400, 600, 100, 100);
        buttonOpResta.setFont(new Font("",40,40));
        buttonOpResta.setText("-");
        add(buttonOpResta);
       }
    public void generarVector(){
        generarVector(0);
      }
    private void generarVector(int act){
        int random=(int)(Math.random()*20)+1;
        if(A.length>act){
             if(existe(random,act,0))
                generarVector(act);
            else{
                A[act]=random;
                generarVector(act+1);
            }
        }
    }
    private boolean existe(int random,int act,int i){
        boolean res=false;
        if(i<act){
            if(A[i]==random)
                res=true;
            else res=true && existe(random,act,i+1);
        }
        return res;
    }
    
        
    }

    