public class Actividad5 {
    public static void main(String[] args) {
        Primero p = new Primero();
        Segundo s = new Segundo();
        p.start();
        s.start();
        System.out.println("Fin programa");
    }
}

class Primero extends Thread {
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Primero " + i);
            try {
                // Detener el hilo durante 100 milisegundos
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Segundo extends Thread {
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Segundo " + i);
            try {
                // Detener el hilo durante 200 milisegundos (0.2 segundos)
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
