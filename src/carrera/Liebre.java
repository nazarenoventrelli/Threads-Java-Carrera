/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera;


public class Liebre extends Competidor {
    
    

    public Liebre(String nombre) {
        this.nombre = nombre;
    }

    
    public Suceso getSuceso() {
        return suceso;
    }


    
    @Override
    public void  calcularSuceso() {
        
        int r = (int) ((Math.random() * 10));
        
        suceso = Suceso.DUERME;
        
        if (r >= 0 && r <= 1) {
            suceso = Suceso.DUERME;
        }
        
        if (r >= 1 && r <= 2) {
            suceso = Suceso.RESBALON_GRANDE;
        }
        if (r>=2 && r<=4){
             suceso = Suceso.RESBALO;
         }  
        
        if (r >=4 && r <=9){
         suceso = Suceso.RAPIDO;
        }
        if (r>=7 && r<=9){
           suceso = Suceso.GRAN_SALTO;
           }
        if (r>=0 && r<=2){
          suceso = Suceso.LENTO;
          }   
        
    
    
    
    }
    
    public void setNombre(String nobmre){
        this.nombre = nobmre;
    }
    
    
}
