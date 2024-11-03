// Clase Hilo, responsable de adquirir los recursos en orden para evitar el deadlock
class Hilo extends Thread {
    Recurso a;
    Recurso b;

    public Hilo(Recurso a, Recurso b, String nombre) {
        super(nombre);
        this.a = a;
        this.b = b;
    }

    public void run() {
        System.out.println("Hilo " + this.getName() + " comienza");
        
        // Se sincroniza con 'a' primero y luego con 'b', evitando el deadlock
        synchronized (a) {
            try {
                Thread.sleep(100); // Simulación de trabajo en el recurso 'a'
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b) {
                System.out.println("Hilo " + this.getName() + " ha terminado");
            }
        }
    }
}