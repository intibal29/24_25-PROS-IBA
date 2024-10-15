public class Actividad1 {
    public static void main(String[] args) {
        // Crear dos instancias de la clase Hilo con nombres diferentes
        Hilo primero = new Hilo("Primero");
        Hilo segundo = new Hilo("Segundo");

        // Iniciar ambos hilos
        primero.start();
        segundo.start();

        // Mensaje final después de que ambos hilos se hayan iniciado
        System.out.println("Fin programa");
    }
}

//
