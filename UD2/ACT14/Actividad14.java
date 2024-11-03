public class Actividad14 extends Thread {
    public static void main(String args[]) {
        Recurso a = new Recurso();
        Recurso b = new Recurso();

        // Se crea h1 y h2 con el mismo orden de adquisición para evitar deadlock
        Hilo h1 = new Hilo(a, b, "uno");
        Hilo h2 = new Hilo(a, b, "dos");

        h1.start();
        h2.start();
    }
}