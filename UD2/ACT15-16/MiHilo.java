import java.text.SimpleDateFormat;
import java.util.Date;

class MiHilo extends Thread {
    private String nombreHilo;

    public MiHilo(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // Obtener la hora actual
            String horaActual = new SimpleDateFormat("HH:mm:ss").format(new Date());
            // Imprimir el mensaje
            System.out.println(nombreHilo + " - " + horaActual);
            // Esperar 1 segundo
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
