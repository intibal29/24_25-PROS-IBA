
import java.io.*;
import java.net.*;

public class Cliente_7 {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream entrada = null;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("PROGRAMA CLIENTE INICIANDO");

            // Se conecta al servidor en localhost y puerto 6013
            socket = new Socket("localhost", 6013);

            // Crea el flujo de entrada para recibir el saludo del servidor
            entrada = new DataInputStream(socket.getInputStream());

            // Recibe y muestra el mensaje del servidor
            String mensaje = entrada.readUTF();
            System.out.println("Recibiendo mensaje del servidor: ");
            System.out.println("\t" + mensaje);

            // Cierra los flujos y el socket
            entrada.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
