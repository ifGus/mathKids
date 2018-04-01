package logica;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
/**
 * Write a description of class juegoDeLogica here.
 * 
 * @author Grissel 
 * @version 15-3-18
 */
public class JuegoDeLogica extends JFrame implements ActionListener{   
    private ActionEvent event;
    private boolean res = false;
    private int nVidas = 3;
    private JFrame g ;
    private int puntos=0;
    public Random gAzar;  
    private JuegoDeLogica jdl ;
    
    public JuegoDeLogica(){
    this.nVidas = 3;
    this.puntos = 0;
    makeFrame();
    }
  /*
    public static void main(String []args){

    JuegoDeLogica jdl = new JuegoDeLogica();
    }*/

    
    public String getSecuencia(){
        String s = "";
        int res1 = 0;
        int res2 = 0;
        boolean res = false;
        int a = getMay();
        int c = getMen();
        int e = getMay2();
        int g = getMen2();
        int sec = getSec();

        if(sec==1 || sec==2){
            res1=a+c;
            res2=e+g;
        }

        if(sec==3 || sec==4){
            res1 = a-c;
            res2 = e-g;
        }
        if(sec==5 || sec==6){
            res1 = a+c;
            res2 = e-g;
        }

        if(sec==7 || sec==8){
            res1 = a-c;
            res2 = e+g;
        }
        if(sec==1 || sec==3 || sec==5 || sec==7){
            if(res1 <res2){
                this.res=true ;
            }else{
                this.res=false;
            }}

        if(sec==2 || sec==4 || sec==6 || sec==8){
            if(res1>res2){
                this.res= true;
            }else{
                this.res=false;
            }
        }
        if(sec==1){
            s ="  "+ a +" + "+c+" Menor que "+e+" + "+g;          
        }

        if(sec==2){
            s ="  "+ a+" + "+c+" Mayor que "+e+" + "+g;
        }

        if(sec==3){
            s ="  "+ a+" - "+c+" Menor que "+e+" - "+g;
        }

        if(sec==4){
            s ="  "+ a+" - "+c+" Mayor que "+e+" - "+g;
        }

        if(sec==5){
            s ="  "+ a+" + "+c+" Menor que "+e+" - "+g;               
        }

        if(sec==6){
            s ="  "+ a+" + "+c+" Mayor que "+e+" - "+g;               
        }

        if(sec==7){
            s ="  "+ a+" - "+c+" Menor que "+e+" + "+g;
        }

        if(sec==8){
            s ="  "+ a+" - "+c+" Mayor que "+e+" + "+g;      
        }

        return s;
    }
    
    public boolean getRes(){
        return res;
    }

    public int getSec(){
        int sec = 0;
        gAzar = new Random();
        int indice = gAzar.nextInt(9);
        if(indice > 0 && indice < 9){
            sec = indice;
        }else{
            getSec();
        }
        return sec;
    }

    public int getMay(){
        int mayor = 5;
        gAzar = new Random();
        int indice = gAzar.nextInt(10);
        if(indice > 5 && indice < 10){
            mayor = indice;
        }else{
            getMay();
        }
        return mayor;
    }

    public int getMen(){
        int menor = 1;
        gAzar = new Random();
        int indice = gAzar.nextInt(6);
        if(indice > 0 && indice < 6){
            menor = indice;
        }else{
            getMen();
        }
        return menor;
    }

    public int getMay2(){
        int mayor2 = 5;
        gAzar = new Random();
        int indice = gAzar.nextInt(10);
        if(indice > 5 && indice < 10){
            mayor2 = indice;
        }else{
            getMay2();
        }
        return mayor2;
    }

    public int getMen2(){
        int menor2 = 1;
        gAzar = new Random();
        int indice = gAzar.nextInt(6);
        if(indice > 0 && indice < 6){
            menor2 = indice;
        }else{
            getMen2();
        }
        return menor2;
    }

    public int setVida(int resta){
    
        if(nVidas>0){
        this.nVidas = nVidas + resta;
        this.puntos = puntos + 1;
    } else{
    
    }
        return nVidas;
    }
    
    public int getPuntos(){
    return puntos;
    }
    
    public void makeFrame(){
        
        JFrame g = new JFrame ("LOGICA");

        JButton a = new JButton (new ImageIcon("a.jpg"));
        JButton b = new JButton (new ImageIcon("b.jpg"));
        JLabel display = new JLabel();
        JLabel vidas = new JLabel();
        vidas.setBounds(70,230,70,30);
        display.setBounds(30,30,200,30);
        b.setBounds(70,120,70,30);
        a.setBounds(70,190,70,30);
        g.add(display);
        g.add(a);
        g.add(b);
        g.setResizable(true);
        g.add(vidas);
        g.setSize(220,300);
        g.setLayout(null);
        int vid = setVida(0);
        String w = "  "+vid+" VIDAS";
        vidas.setText(w);
        String v = getSecuencia();        
        display.setText(v);
        g.setVisible(true);

        String t = "NO";
        a.setText(t);

        String u = "SI";
        b.setText(u);
        a.addActionListener(this);
        b.addActionListener(this);

        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }          

    public void actionPerformed(ActionEvent event)
    {
        boolean res = false;        
        int  vida = setVida(0);
        if(event.getActionCommand()=="SI"){
            res = getRes();
            if(res==true){
                setVida(0);
            }else{
                setVida(-1);
            }

        }
        if(event.getActionCommand()=="NO"){
            res = getRes();
            if(res==false){
                setVida(0);
            }else{
                setVida(-1);
            }
        }   

        if(vida>0){
            makeFrame();
        }
        if(vida == 0){
            JFrame g = new JFrame ("LOGICA1");
            this.puntos = getPuntos();
            JButton a = new JButton (new ImageIcon("a.jpg"));
            JButton b = new JButton (new ImageIcon("b.jpg"));
            JLabel display = new JLabel();
            JLabel vidas = new JLabel();
            vidas.setBounds(70,230,70,30);
            display.setBounds(70,30,100,30);
            b.setBounds(70,120,70,30);
            a.setBounds(70,190,70,30);
            g.add(display);

            g.setResizable(false);
            g.add(vidas);
            g.setSize(220,300);
            g.setLayout(null);

            String w = "PERDISTE!!!!";
            vidas.setText(w);
            String v =puntos +" PUNTOS ";        
            display.setText(v);
            g.setVisible(true);
        }
    }
}
