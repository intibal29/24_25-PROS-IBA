import java.io.*;
import java.net.*;

public class Cliente_6 {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream entrada = null;
        DataOutputStream salida = null;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("PROGRAMA CLIENTE INICIANDO");

            // Se conecta al servidor en localhost y puerto 6010
            socket = new Socket("localhost", 6010);

            // Se crean los flujos de entrada y salida
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());

            // Solicita y captura el número al usuario
            System.out.println("Introduce un número");
            int numero = Integer.parseInt(teclado.readLine());

            // Envía el número al servidor
            salida.writeInt(numero);

            // Recibe la respuesta del servidor
            String mensaje = entrada.readUTF();
            System.out.println("Recibiendo mensaje del servidor: ");
            System.out.println("\t" + mensaje);

            // Cierra los flujos y el socket
            entrada.close();
            salida.close();
            socket.close();
            
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
