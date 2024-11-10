
public class Actividad15 {
    public static void main(String[] args) {
        // Crear tres hilos
        MiHilo hilo1 = new MiHilo("Hilo 1");
        MiHilo hilo2 = new MiHilo("Hilo 2");
        MiHilo hilo3 = new MiHilo("Hilo 3");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}