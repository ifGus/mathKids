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
public class op {
  private int x,y,pos1,pos2,A[],codOP,res;
  public op(int B[]){
    A=B;
    operar();
    
  }
  public void operar(){
    codOP=(int)(Math.random()*2+50);
    pos1=0;
    pos2=0;
    while(pos1==pos2){
    pos1=(int)(Math.random()*8);
    pos2=(int)(Math.random()*8);
    }
    x=A[pos1];
    y=A[pos2];
    if(codOP==50) res=x+y;
    else res=x-y;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
    
  }
  public int getRes(){
    return res;
  }
  public int getOp(){
    return codOP;
  }
 public int[] arreglo(){
   return A;
 }
 public int getPos1(){
   return pos1;
 }
 public int getPos2(){
   return pos2;
   
 }
}

    

