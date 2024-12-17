package ejer11;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 6000;

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado. Esperando conexiones...");
            while (true) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente Conectado.....");

                // Crear y lanzar un hilo para manejar al cliente
                HiloServidor hilo = new HiloServidor(clienteSocket);
                hilo.start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}
