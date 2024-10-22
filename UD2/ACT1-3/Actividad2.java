public class Actividad2 {
    public static void main(String[] args) {

 
        // Recibe n como argumento (convertido a entero)
        int n = Integer.parseInt(args[0]);

        // Crear e iniciar n hilos
        for (int i = 1; i <= n; i++) {
            Hilo hilo = new Hilo(i);
            hilo.start();
        }

        // Mensaje final después de crear los hilos
        System.out.println("Final Programa");
    }
}

class Hilo extends Thread {
    private int numeroHilo;

    public Hilo(int numeroHilo) {
        this.numeroHilo = numeroHilo;
    }

    @Override
    public void run() {
        // Imprimir "Hilo n" 20 veces
        for (int i = 1; i <= 20; i++) {
            System.out.println("Hilo " + numeroHilo + " - iteración " + i);
        }
>>>>>>> 12c1d03374feae1ecb4dabee7b7bfe6c90f60156
    }
}
