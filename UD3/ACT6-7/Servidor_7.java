
import java.io.*;
import java.net.*;

public class Servidor_7 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socketCliente = null;
        DataOutputStream salida = null;
        int clienteContador = 1;

        try {
            // Crea el servidor en el puerto 6013
            serverSocket = new ServerSocket(6013);
            System.out.println("Esperando a los clientes.....");

            // Atiende a 3 clientes
            while (clienteContador <= 3) {
                // Espera la conexión de un cliente
                socketCliente = serverSocket.accept();
                System.out.println("Cliente " + clienteContador + " conectado.");

                // Crea el flujo de salida
                salida = new DataOutputStream(socketCliente.getOutputStream());

                // Envía el mensaje de saludo al cliente
                salida.writeUTF("Hola cliente " + clienteContador);

                // Cierra los flujos y el socket para este cliente
                salida.close();
                socketCliente.close();

                // Incrementa el contador de clientes
                clienteContador++;
            }

            // Cierra el servidor
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
