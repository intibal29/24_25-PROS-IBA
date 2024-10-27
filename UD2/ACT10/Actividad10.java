// Resolución de problemas: se ha manejado la configuración de prioridades y la ejecución en el orden correcto.
// Se emplean métodos de la clase Thread para obtener los nombres y prioridades de los hilos.

public class Actividad10 {
    public static void main(String[] args) {
        // Imprime la prioridad del hilo principal
        System.out.println(Thread.currentThread().getName() + " tiene la prioridad " + Thread.currentThread().getPriority());

        // Crear hilos con prioridades especificadas
        Hilo hilo1 = new Hilo("Hilo-prioridad 3");
        Hilo hilo2 = new Hilo("Hilo-prioridad 7");

        // Asignar prioridades
        hilo1.setPriority(3); // Prioridad 3
        hilo2.setPriority(7); // Prioridad 7

        // Imprimir información de los hilos
        System.out.println(hilo1.getName() + " tiene la prioridad " + hilo1.getPriority());
        System.out.println(hilo2.getName() + " tiene la prioridad " + hilo2.getPriority());

        // Iniciar hilos en el orden especificado
        hilo1.start(); // Primero el hilo con prioridad 3
        hilo2.start(); // Luego el hilo con prioridad 7

        // Mensaje final
        System.out.println("Final programa");
    }
}
