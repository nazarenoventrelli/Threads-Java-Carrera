/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;


public enum Suceso {
    
RAPIDO(3), RESBALO(-6), LENTO(1), DUERME(0), GRAN_SALTO(9), RESBALON_GRANDE(-12), PEQUENO_SALTO(1), RESBALON_PEQUENO(-2); 

    int avance;
    
    
    
    private Suceso(int avance) {
        this.avance = avance;
    }
 
    
    
}