package ejer11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {
    private Socket socket;

    public HiloServidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.println("Comunico con: " + socket);

            String mensaje;
            while ((mensaje = entrada.readLine()) != null) {
                if (mensaje.equals("*")) {
                    System.out.println("Fin de la conexión con: " + socket);
                    break;
                }
                // Convertir a mayúsculas y enviar de vuelta al cliente
                salida.println(mensaje.toUpperCase());
                System.out.println("Comunico con: " + socket);
            }
        } catch (IOException e) {
            System.err.println("Error con el cliente: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el socket: " + e.getMessage());
            }
        }
    }
}
