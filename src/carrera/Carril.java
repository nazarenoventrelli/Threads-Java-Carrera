/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Carril extends Thread {
    
    static int RETARDO = 500;
    public int distanciaTotal;
    public Competidor competidor;
    private int distanciaRecorrida;
    private CountDownLatch latchL;
    private CountDownLatch latchF;
    public int horaini = 0;
    public int horafin = 0;
    private List<Carril> lista;
//    
    
    public Carril(int distanciaTotal, Competidor competidor, CountDownLatch unlatchL,CountDownLatch unlatchF,List<Carril> lista) {
        this.lista = lista;
        this.distanciaTotal = 50;
        this.competidor = competidor;
        this.latchL = unlatchL;
        this.latchF = unlatchF;
    }
    
    
    @Override
    public void run(){
        try {
                //horafin = System.currentTimeMillis();
                latchL.await();
                this.horaini =(int) (System.currentTimeMillis()/1000);
                
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carril.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        while(distanciaRecorrida <=distanciaTotal){
            
            try {
                sleep(RETARDO);
            } catch (InterruptedException e) {
                
            }
            competidor.calcularSuceso();
            
            distanciaRecorrida = distanciaRecorrida + competidor.suceso.avance;
            
            System.out.println("Suceso: "+competidor.suceso);
            System.out.println(competidor.nombre+" : "+distanciaRecorrida +" metros:");
            
        }
             System.out.println("-----"+competidor.nombre + " llego a la meta!-----");
             this.horafin =(int) (System.currentTimeMillis()/1000);
             lista.add(this);
             latchF.countDown();
            
        }
    
     
       
    }
    
    
    
    

