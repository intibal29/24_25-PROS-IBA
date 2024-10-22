public class Actividad4 {
    public static void main(String[] args) {
        // Crear hilos para "Primero" y "Segundo" usando la clase Posicion
        Thread primero = new Thread(new Posicion("Primero"));
        Thread segundo = new Thread(new Posicion("Segundo"));

        // Iniciar los hilos
        primero.start();
        segundo.start();

        // Mensaje final
        System.out.println("Fin programa");
    }
}

// Clase Posicion que implementa Runnable
class Posicion implements Runnable {
    private String texto;

    // Constructor que recibe el texto ("Primero" o "Segundo")
    public Posicion(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {
        // Imprimir el texto 15 veces
        for (int i = 1; i <= 15; i++) {
            System.out.println(texto + " " + i);
        }
    }
}
