
package parcial02;

/**
 *
 * @author Daniela Chavez
 */


public class Raza {
    private String nombre;
    /*
        * 0 ---> Construir edificios con mucha velocidad
        * 1 ---> Super milicia (Fuerza en puntos de ataque)
        * 2 ---> Construir vehiculos con mucha velocidad
    */
    private int fortaleza;
    /*
        * 0 --> Crear edificaciones
        * 1 --> Entrenar milicia
        * 2 --> Creacion de vehiculos
    */
    private int traslado;
   
  
    public Raza (String nombre, int traslado, int fortaleza) {
      this.nombre = nombre;
      this.traslado = traslado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(int fortaleza) {
        this.fortaleza = fortaleza;
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
}

