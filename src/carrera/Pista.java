/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


public class Pista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        
        
        System.out.println("....Comienza la carrera....");
        
        CountDownLatch unlatchL = new CountDownLatch(2);
        CountDownLatch unlatchF = new CountDownLatch(2);
        
        
        Liebre liebre =new Liebre("Liebre 1");
        Tortuga tortuga = new Tortuga("Manuelita");
        
         List<Carril> lista=new ArrayList<Carril>();
        List<Carril> listaSyn=Collections.synchronizedList(lista);
        
        Carril c1 = new Carril(100,liebre,unlatchL,unlatchF,lista);
        Carril c2 = new Carril(100,tortuga,unlatchL,unlatchF,lista);
        
        
        c1.start();
        c2.start();
        unlatchL.countDown();
        unlatchL.countDown();
        
        unlatchF.await();
        System.out.println("....Carrera Terminada....");
        
        
        //lista de carriles 
         Iterator it = lista.iterator();
            
         while(it.hasNext()){
            Carril unCarril = (Carril)it.next();
            System.out.println("Competidor: "+unCarril.competidor.nombre);
            System.out.println("Tiempo de largada: "+unCarril.horaini);
            System.out.println("Tiempo de llegada: "+unCarril.horafin);
           
         }
         
          /*   o accediendo a los objetos carriles
            System.out.println("Competidor: "+c1.getName());
            System.out.println("Tiempo de largada: "+c1.horaini);
            System.out.println("Tiempo de llegada: "+c1.horafin);
            
            System.out.println("Competidor: "+c2.getName());
            System.out.println("Tiempo de largada: "+c2.horaini);
            System.out.println("Tiempo de llegada: "+c2.horafin);
          */
         
         if (c1.horafin == c2.horafin) {
             System.out.println("..........Empate..........");
             
         } 
          
         
    }
    
}
