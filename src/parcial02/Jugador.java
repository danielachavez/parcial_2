package parcial02;

import java.util.HashMap;
import java.util.Iterator;

public class Jugador {
   
    private String nombre;
    private int recurso1;
    private int recurso2;
    private int recurso3;
    
    private Edificacion centroDeMando;
    
    private Raza raza;
    private HashMap<String, Object[]> edificaciones = new HashMap<>();
    private HashMap<String, Object[]> vehiculos = new HashMap<>();
    
    public Jugador () {
        this.centroDeMando = new Edificacion("Centro de mando", 20000, true, 0, 10000, 5000, 3000); 
    }
    
    public Jugador (String nombre) {
        this.nombre = nombre;
    }
    
    public void setRaza (Raza raza) {
        this.raza = raza;
    }
    
    public Raza getRaza () {
        return this.raza;
    }
    
    public void putVehiculos (String key, Object[] data, Jugador jugador) {
        Iterator iterador = this.vehiculos.keySet().iterator();
        String ClaveActual = null;
        
        this.centroDeMando = jugador.getCentroDeMando();
        Vehiculos asociado = (Vehiculos) data[1]; 
        
        int costo_1 = asociado.getCosto1();
        int costo_2 = asociado.getCosto2();
        int costo_3 = asociado.getCosto3();
        
        if ((this.centroDeMando.getRecursotipo1() - costo_1) >= 0 && (this.centroDeMando.getRecursotipo1() - costo_2) >= 0 && (this.centroDeMando.getRecursotipo3()- costo_3) >= 0) {
            boolean bandera = false;
            
            while (iterador.hasNext()) {
                key = (String) iterador.next();
                if (ClaveActual.getNombre().equals(key)) {
                    bandera = true;
                    break;
                }
            }

            String clave = ClaveActual.getNombre();

            if (!bandera) {
                this.vehiculos.put(clave, data);
            } else {
                Object[] aux = this.vehiculos.get(clave);
                aux[0] = (int) aux[0] + 1;
                this.vehiculos.put(clave, aux);
            }

            this.centroDeMando.setRecursotipo1(this.centroDeMando.getRecursotipo1() - costo_1);
            this.centroDeMando.setRecursotipo2(this.centroDeMando.getRecursotipo2() - costo_2);
            this.centroDeMando.setRecursotipo3(this.centroDeMando.getRecursotipo3() - costo_3);
            
            this.listarVehiculos(jugador);
        } else {
            System.out.println("***********************************************");
            System.out.println("Has agotado todos tus recursos.");
            System.out.println("***********************************************");
        }

 }
    
    private void listarVehiculos (Jugador jugador) {
        Vehiculos vehiculos = null;
        String key = null;
         
        Iterator iterador = this.vehiculos.keySet().iterator();
        System.out.println("********************* Detalle ****************************");  
        while (iterador.hasNext()) {
           key = (String) iterador.next();   
           Object[] data = this.vehiculos.get(key); // [ Objecto edificacion, cantidad de edificaciones ]
           
           vehiculos = (Vehiculos) data[1];         
           System.out.println("Nombre de edificación: " + vehiculos.getNombre());
           System.out.println("Número de construcciones: " + (int) data[0]);
           System.out.println("");
           
        }
        
        System.out.println("Recursos disponibles (Jugador: " + jugador.getNombre() + "):");
        System.out.println("Recurso 1: " + this.centroDeMando.getRecursotipo1());
        System.out.println("Recurso 2: " + this.centroDeMando.getRecursotipo2());
        System.out.println("Recurso 3: " + this.centroDeMando.getRecursotipo3());
        System.out.println("**********************************************************");
    }
    

    public void putEdificacion (String key, Object[] data, Jugador jugador) {
        Iterator iterador = this.edificaciones.keySet().iterator();
        String ClaveActual = null;
        
        this.centroDeMando = jugador.getCentroDeMando();
        Edificacion auxi = (Edificacion) data[1]; 
        int costo_1 = auxi.getCosto_1();
        int costo_2 = auxi.getCosto_2();
        int costo_3 = auxi.getCosto_3();

        
        if ((this.centroDeMando.getRecursotipo1() - costo_1) >= 0 && (this.centroDeMando.getRecursotipo1() - costo_2) >= 0 && (this.centroDeMando.getRecursotipo3()- costo_3) >= 0) {
            boolean bandera = false;
            while (iterador.hasNext()) {
                key = (String) iterador.next();
                if (auxi.getEdificacion().equals(key)) {
                    bandera = true;
                    break;
                }
            }

            String clave = auxi.getEdificacion();

            if (!bandera) {
                this.edificaciones.put(clave, data);
            } else {
                Object[] aux = this.edificaciones.get(clave);
                aux[0] = (int) aux[0] + 1;
                this.edificaciones.put(clave, aux);
            }

            this.centroDeMando.setRecursotipo1(this.centroDeMando.getRecursotipo1() - costo_1);
            this.centroDeMando.setRecursotipo2(this.centroDeMando.getRecursotipo2() - costo_2);
            this.centroDeMando.setRecursotipo3(this.centroDeMando.getRecursotipo3() - costo_3);
            
            this.listarEdificaciones();
        } else {
            System.out.println("***********************************************");
            System.out.println("Has agotado todos tus recursos.");
            System.out.println("***********************************************");
        }
       
    }

    public HashMap<String, Object[]> getEdificaciones() {
        return edificaciones;
    }

    public void setEdificaciones(HashMap<String, Object[]> edificaciones) {
        this.edificaciones = edificaciones;
    }
    
    
    
    public void listarEdificaciones () {
        Edificacion edificacion = null;
        String key = null;
         
        Iterator iterador = this.edificaciones.keySet().iterator();
        System.out.println("********************* Detalle ****************************");  
        while (iterador.hasNext()) {
           key = (String) iterador.next();   
           Object[] data = this.edificaciones.get(key); // [ Objecto edificacion, cantidad de edificaciones ]
           
           edificacion = (Edificacion) data[1];         
           System.out.println("Nombre de edificación: " + edificacion.getEdificacion());
           System.out.println("Número de construcciones: " + (int) data[0]);
           System.out.println("");
        }
        
        System.out.println("Recursos disponibles (Jugador: " + this.getNombre() + "):");
        System.out.println("Recurso 1: " + this.centroDeMando.getRecursotipo1());
        System.out.println("Recurso 2: " + this.centroDeMando.getRecursotipo2());
        System.out.println("Recurso 3: " + this.centroDeMando.getRecursotipo3());
        System.out.println("**********************************************************");
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Edificacion getCentroDeMando() {
        return centroDeMando;
    }

    public void setCentroDeMando(Edificacion centroDeMando) {
        this.centroDeMando = centroDeMando;
    }
}

    


    
    

    






