package ejer11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PUERTO = 6000;

        System.out.println("PROGRAMA CLIENTE INICIANDO");

        try (
            Socket socket = new Socket(HOST, PUERTO);
            BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String mensaje;

            while (true) {
                System.out.print("Introduce una cadena:");
                mensaje = entradaUsuario.readLine();
                salida.println(mensaje);

                String respuesta = entradaServidor.readLine();
                System.out.println("=>Respuesta:" + respuesta);

                if (mensaje.equals("*")) {
                    System.out.println("Fin del envío....");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
