import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // Creación del socket en el puerto 12346
            socket = new DatagramSocket(12346);
            System.out.println("Esperando datagrama...");

            // Preparar un buffer para recibir el datagrama
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Recibir el datagrama del cliente
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            int number = Integer.parseInt(received);
            System.out.println("Vamos a calcular el cubo de: " + number);

            // Mostrar información del cliente
            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();
            System.out.println("IP de origen: " + clientAddress);
            System.out.println("Puerto de origen: " + clientPort);

            // Calcular el cubo del número
            int cube = number * number * number;

            // Preparar el mensaje de respuesta
            String response = String.valueOf(cube);
            byte[] responseBytes = response.getBytes();

            // Enviar el resultado al cliente
            DatagramPacket responsePacket = new DatagramPacket(
                responseBytes, responseBytes.length, clientAddress, clientPort
            );
            socket.send(responsePacket);
            System.out.println("Enviamos el resultado..." + cube);

            System.out.println("Adiósss");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
