
public class Actividad16 {
    public static void main(String[] args) {
        Contador cont = new Contador(100);
        HiloA a = new HiloA("HiloA", cont);
        HiloB b = new HiloB("HiloB", cont);
        a.start();
        try {
            a.join(); // Esperar a que HiloA termine antes de iniciar HiloB
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
    }
}
