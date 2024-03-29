
package parcial02;

import java.util.Scanner;


/**
 *
 * @author Daniela Chavez
 */
public class Parcial02 {
     //  Declaramos objeto Razas
    private static Raza[] razas;
    // Creación de objeto Jugador
    private static Jugador[] jugadores;
    // Creación de objeto edificación 
    private static Edificacion[] edificaciones;
    // Creación de objeto Vehiculo
    private static Vehiculos[] vehiculos;
    // Llevar el control de turnos
    private boolean flag = false;
    
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       jugadores = new Jugador[2];
       
       edificaciones = new Edificacion[3];
       edificaciones[0] = new Edificacion("Alcatara", 10000, false, 1, 5000, 2500, 1500);
       edificaciones[1] = new Edificacion("Kalifa", 10000, false, 2, 5000, 2500, 1500);
       edificaciones[2] = new Edificacion("State", 10000, false, 3, 5000, 2500, 1500);
       
       razas = new Raza[3];
       razas[0] = new Raza("Gigantes", 0, 0);
       razas[1] = new Raza("Arqueras", 4, 1);
       razas[2] = new Raza("Moqueteras", 5, 2);
       
       vehiculos = new Vehiculos[3];
       vehiculos[0] = new Vehiculos("Armata", 5000, 5000, 2500, 1500, 1500, edificaciones[1]);
       vehiculos[1] = new Vehiculos("Catapulta", 5000, 5000, 2500, 1500, 2500, edificaciones[1]);
       vehiculos[2] = new Vehiculos("Merkava", 5000, 5000, 2500, 1500, 1500, edificaciones[1]);
       
       for (int i = 0; i < jugadores.length; i++) {
           jugadores[i] = new Jugador();
           System.out.print("Ingresa el nombre del jugador " + (i + 1) + ": ");
           jugadores[i].setNombre(scanner.nextLine());
           setRaza(i);
       }
       
       int aleatorio = (int) (Math.random() * 2) + 1;
       init(aleatorio);
    }
    
    private static void init (int jugadores) {
        System.out.println("\nIniciando partida...");
        boolean turno = (jugadores % 2 == 0); int opcion = 0, count = 0;
        boolean flag = true;
        
        while (flag) {
            if (turno) {
                System.out.println("Turno del Jugador: " + Parcial02.jugadores[jugadores % 2].getNombre() + ".\n");
                opcion = showMenu();
            } else {
                System.out.println("Turno del Jugaddor "+ Parcial02.jugadores[jugadores % 2].getNombre() +".\n");
                opcion = showMenu();
            }
            
            switch (opcion) {
                case 1:
                    Parcial02.edificar(jugadores % 2);
                    break;
                case 2: 
                    Parcial02.crearVihuculo(jugadores % 2);
                    break;
                case 3:
                    Parcial02.jugadores[jugadores % 2].getCentroDeMando().mejorarEdificacion();
                    break;
                case 4:
                    Parcial02.jugadores[jugadores % 2].listarEdificaciones();
                    break;
                case 5:
                    turno = !turno;
                    jugadores ++;
                    count ++;
                    break;
            }
            
            if (count >= 2) {
                flag = false;
            }
        }
    }
    
    private static void edificar (int jugador) {
        System.out.println("Escoge una opción: ");
        System.out.println("1) Construir Alcatara.");
        System.out.println("2) Construir Kalifa");
        System.out.println("3) Construir State");
        System.out.println("4) Terminar.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una opcion:");
        int opcion = scanner.nextInt();

        Object[] data = new Object[2];
        
        switch (opcion) {
            case 1:
                data[0] = 1;
                data[1] = edificaciones[0];
                Parcial02.jugadores[jugador].putEdificacion(edificaciones[0].getEdificacion(), data, Parcial02.jugadores[jugador]);
                break;
            case 2:
                data[0] = 1;
                data[1] = edificaciones[1];
                Parcial02.jugadores[jugador].putEdificacion(edificaciones[1].getEdificacion(), data, Parcial02.jugadores[jugador]);
                break;
            case 3:
                data[0] = 1;
                data[1] = edificaciones[2];
                Parcial02.jugadores [jugador].putEdificacion(edificaciones[2].getEdificacion(), data, Parcial02.jugadores[jugador]);
                break;
            case 4:
                
                break;
        }
    }
    
    private static void setRaza (int jugador) {
        System.out.println("Escoge una raza: ");
        System.out.println("1) Entrenar Gigantes.");
        System.out.println("2) Entrenar Arqueras.");
        System.out.println("3) Entrenar Mosqueteras.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una opcion:");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                Parcial02.jugadores[jugador].setRaza(razas[0]);
                System.out.println("****************************************");
                System.out.println("Nombre de raza: " + razas[0].getNombre());
                System.out.println("****************************************");
                break;
            case 2:
                Parcial02.jugadores[jugador].setRaza(razas[1]);
                System.out.println("****************************************");
                System.out.println("Nombre de raza: " + razas[1].getNombre());
                System.out.println("****************************************");
                break;
            case 3:
                Parcial02.jugadores[jugador].setRaza(razas[2]);
                System.out.println("****************************************");
                System.out.println("Nombre de raza: " + razas[2].getNombre());
                System.out.println("****************************************");
                break;
        }
    }
    
    private static void crearVihuculo (int jugador) {
        System.out.println("Escoge una opción: ");
        System.out.println("1) Construir Armata.");
        System.out.println("2) Construir Catapulta.");
        System.out.println("3) Construir Merkava.");
        System.out.println("4) Terminar.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una opcion:");
        int opcion = scanner.nextInt();

        Object[] data = new Object[2];
        
        switch (opcion) {
            case 1:
                data[0] = 1;
                data[1] = vehiculos[0];
                Parcial02.jugadores[jugador].putVehiculos(vehiculos[0].getNombre(), data, Parcial02.jugadores[jugador]);
                break;
            case 2:
                data[0] = 1;
                data[1] = vehiculos[1];
                Parcial02.jugadores[jugador].putVehiculos(vehiculos[1].getNombre(), data, Parcial02.jugadores[jugador]);
                break;
            case 3:
                data[0] = 1;
                data[1] = vehiculos[2];
                Parcial02.jugadores[jugador].putVehiculos(vehiculos[2].getNombre(), data, Parcial02.jugadores[jugador]);
                break;    
            case 4:
                break;
        }
    }
    
    private static int showMenu () {
       int menu = 0;
        
       System.out.println("Seleccione una opción:");
       System.out.println("1) Crear una edificación.");
       System.out.println("2) Crear un vehiculo.");
       System.out.println("3) Generar recursos.");
       System.out.println("4) Mejorar nivel de centro de mando.");
       System.out.println("5) Salir.");
        
       Scanner scanner = new Scanner(System.in);
       System.out.print("Ingrese opcion: ");
       menu = scanner.nextInt();
       
       System.out.println("");
       return menu;
    }
}

