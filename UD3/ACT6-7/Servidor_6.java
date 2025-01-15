import java.io.*;
import java.net.*;

public class Servidor_6 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socketCliente = null;
        DataInputStream entrada = null;
        DataOutputStream salida = null;
        
        try {
            // Se crea el servidor en el puerto 6010
            serverSocket = new ServerSocket(6010);
            System.out.println("Esperando al cliente.....");

            // Espera a que el cliente se conecte
            socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado: " + socketCliente.getInetAddress().getHostName());

            // Se crean los flujos de entrada y salida
            entrada = new DataInputStream(socketCliente.getInputStream());
            salida = new DataOutputStream(socketCliente.getOutputStream());

            // Lee el número enviado por el cliente
            int numero = entrada.readInt();
            // Calcula el cuadrado del número
            int cuadrado = numero * numero;

            // Envía el resultado al cliente
            salida.writeUTF("El cuadrado del número " + numero + " es " + cuadrado);

            // Cierra los flujos y el socket
            entrada.close();
            salida.close();
            socketCliente.close();
            serverSocket.close();
            
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
