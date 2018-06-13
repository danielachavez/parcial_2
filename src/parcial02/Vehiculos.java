/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial02;

/**
 *
 * @author Daniela Chavez
 */
public class Vehiculos {
   private int traslado; // Aereo y terrestre
   private int vida; 
   
   private final int costo_1;
   private final int costo_2;
   private final int costo_3;
   private final int ataque; // puntos de ataque
   
   private Edificacion edificacion;
   
   private String nombre;
   
   public Vehiculos (String nombre, int vida, int costo_1, int costo_2, int costo_3, int ataque, Edificacion edificacion) {
       this.vida = vida;
       this.nombre = nombre;
       
       this.costo_1 = costo_1;
       this.costo_2 = costo_2;
       this.costo_3 = costo_3;
       
       this.ataque = ataque;
       this.edificacion = edificacion;
   }

    public Edificacion getEdificacion() {
        return edificacion;
    }

    public void setEdificacion(Edificacion edificacion) {
        this.edificacion = edificacion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getTraslado() {
        return traslado;
    }

    public void setTraslado(int traslado) {
        this.traslado = traslado;
    }

    public int getCosto_1() {
        return costo_1;
    }

    public int getCosto_2() {
        return costo_2;
    }

    public int getCosto_3() {
        return costo_3;
    }

    public int getAtaque() {
        return ataque;
    }
    
    
}


