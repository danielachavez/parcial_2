
package parcial02;

/**
 *
 * @author Daniela Chavez
 */
public class Edificacion {

    private int vida;
    private int tipo;

    /*
        * 0 --> (Todos los recursos) ---> Sólo centro de mando, cuya principal función es alvergar  recursos (Valores iniciales: 10000, 5000, 3000)
        * 1 --> (Almacenamiento de recursos tipo 1)
        * 2 --> (Alacenamiento de recursos tipo 2)
        * 3 --> (Alacenamiento de recursos tipo 3)
        * 4 --> (Entrenamiento de razas o milicias) 
        * 5 --> (Construccion de vehículos)
     */
    private boolean flag; // Es centro de mando ?
    private String edificacion;

    private int nivel;

    private int recurso1; // Almacenamiento tipo 1
    private int recurso2; // Almacenamiento tipo 2
    private int recurso3; // Almacenamiento tipo 3

    private int recursotipo1; // Almacenamiento tipo 1
    private int recursotipo2; // Almacenamiento tipo 2
    private int recursotipo3; // Almacenamiento tipo 3

    private int costo_1; // costo tipo 1
    private int costo_2; // costo tipo 2
    private int costo_3; // costo tipo 3

    public Edificacion(String edificacion, int vida, boolean flag, int tipo, int costo1, int costo2, int costo3) {
        this.vida = vida;
        this.flag = flag;
        this.edificacion = edificacion;
        this.nivel = 1;

        switch (tipo) {
            case 0:
                this.costo_1 = 0;
                this.costo_2 = 0;
                this.costo_3 = 0;
                this.recursotipo1 = costo_1;
                this.recursotipo2 = costo_2;
                this.recursotipo3 = costo_3;
                this.recurso1 = costo_1;
                this.recurso2 = costo_2;
                this.recurso3 = costo_3;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                this.costo_1 = costo_1;
                this.costo_2 = costo_2;
                this.costo_3 = costo_3;
                break;
        }

    }

    public String getEdificacion() {
        return edificacion;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setEdificacion(String edificacion) {
        this.edificacion = edificacion;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCosto_1() {
        return this.costo_1;
    }

    public void setCosto_1(int costo_1) {
        this.costo_1 = costo_1;
    }

    public int getCosto_2() {
        return this.costo_2;
    }

    public void setCosto_2(int costo_2) {
        this.costo_2 = costo_2;
    }

    public int getCosto_3() {
        return this.costo_3;
    }

    public void setCosto_3(int costo_3) {
        this.costo_3 = costo_3;
    }

    public int getRecursotipo1() {
        return recursotipo1;
    }

    public void setRecursotipo1(int recursotipo1) {
        this.recursotipo1 = recursotipo1;
    }

    public int getRecursotipo2() {
        return recursotipo2;
    }

    public void setRecursotipo2(int recursotipo2) {
        this.recursotipo2 = recursotipo2;
    }

    public int getRecursotipo3() {
        return recursotipo3;
    }

    public void setRecursotipo3(int recursotipo3) {
        this.recursotipo3 = recursotipo3;
    }

    public void generarRecursos() {
        switch (tipo) {
            case 0:
                this.recursotipo1 = 10000;
                this.recursotipo2 = 5000;
                this.recursotipo3 = 3000; // Almacenamiento máximo
                break;
            case 1:
                if (this.recursotipo1 <= this.recurso1) {
                    this.recursotipo1 = (int) Math.floor((0.10 * this.recursotipo1) + this.recursotipo1); // Almacenamiento máximo
                }
                break;
            case 2:
                if (this.recursotipo2 <= this.recurso2) {
                    this.recursotipo2 = (int) Math.floor((0.30 * this.recursotipo2) + this.recursotipo2); // Almacenamiento máximo
                }
                break;
            case 3:
                if (this.recursotipo3 <= this.recurso3) {
                    this.recursotipo3 = (int) Math.floor((0.30 * this.recursotipo3) + this.recursotipo3); // Almacenamiento máximo
                }
                break;
            case 4:

                break;
            case 5:
                
                break;
        }
    }

    public void mejorarEdificacion() {
        int costoMejora = 0;
        
        switch (this.nivel) {
            case 1:
                this.recurso1 = (int) Math.floor((this.recurso1 * 0.10) + this.recurso1);
                this.recurso2 = (int) Math.floor((this.recurso2 * 0.10) + this.recurso2);
                this.recurso3 = (int) Math.floor((this.recurso3 * 0.10) + this.recurso3);
                
                costoMejora = (int) Math.floor(0.25 * (this.recurso1 + this.recurso2 + this.recurso3));
                costoMejora = costoMejora / 3;
                
                if ((this.recursotipo1 - costoMejora) >= 0 && (this.recursotipo2 - costoMejora) >= 0 && (this.recursotipo2 - costoMejora) >= 0) {
                    this.recursotipo1 = this.recursotipo1 - costoMejora;
                    this.recursotipo2 = this.recursotipo2 - costoMejora;
                    this.recursotipo3 = this.recursotipo3 - costoMejora;
                } else {
                    System.out.println("Ya no posees suficientes recusos.");
                }
                
                this.nivel ++;
                break;
            case 2:
                this.recurso1 = (int) Math.floor((this.recurso1 * 0.30) + this.recurso1);
                this.recurso2 = (int) Math.floor((this.recurso2 * 0.30) + this.recurso2);
                this.recurso3 = (int) Math.floor((this.recurso3 * 0.30) + this.recurso3);
                
                costoMejora = (int) Math.floor(0.25 * (this.recurso1 + this.recurso2 + this.recurso3));
                costoMejora = costoMejora / 3;
                
                if ((this.recursotipo1 - costoMejora) >= 0 && (this.recursotipo2 - costoMejora) >= 0 && (this.recursotipo2 - costoMejora) >= 0) {
                    this.recursotipo1 = this.recursotipo1 - costoMejora;
                    this.recursotipo2 = this.recursotipo2 - costoMejora;
                    this.recursotipo3 = this.recursotipo3 - costoMejora;
                } else {
                    System.out.println("Ya no posees suficientes recusos.");
                }
                
                this.nivel ++;
                break;
            case 3:
                this.recurso1 = (int) Math.floor((this.recurso1 * 0.50) + this.recurso1);
                this.recurso2 = (int) Math.floor((this.recurso2 * 0.50) + this.recurso2);
                this.recurso3 = (int) Math.floor((this.recurso3 * 0.50) + this.recurso3);
                
                costoMejora = (int) Math.floor(0.25 * (this.recurso1 + this.recurso2 + this.recurso3));
                costoMejora = costoMejora / 3;
                
                if ((this.recursotipo1 - costoMejora) >= 0 && (this.recursotipo2 - costoMejora) >= 0 && (this.recursotipo2 - costoMejora) >= 0) {
                    this.recursotipo1 = this.recursotipo1 - costoMejora;
                    this.recursotipo2 = this.recursotipo2 - costoMejora;
                    this.recursotipo3 = this.recursotipo3 - costoMejora;
                } else {
                    System.out.println("Ya no posees suficientes recusos.");
                }
                break;
        }
        
        System.out.println("***************************************************");
        System.out.println("El centro de mando ha sido mejorado. (Nivel " + this.nivel + ")");
        System.out.println("Almacenamiento 1: " + this.recurso1);
        System.out.println("Almacenamiento 2: " + this.recurso2);
        System.out.println("Almacenamiento 3: " + this.recurso3);
        System.out.println("Recursos disponibles: ");
        System.out.println("Recurso 1: " + this.recursotipo1);
        System.out.println("Recurso 2: " + this.recursotipo2);
        System.out.println("Recurso 3: " + this.recursotipo3);
        System.out.println("***************************************************");
    }


}

    