import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {
            // Número a enviar (dentro del rango -128 a 127)
            int numberToSend = 4;

            // Crear el socket en el puerto 34568
            socket = new DatagramSocket(34568);

            // Convertir el número a bytes para enviarlo
            byte[] buffer = String.valueOf(numberToSend).getBytes();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Crear el datagrama para enviar al servidor
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 12346);
            socket.send(packet);
            System.out.println("Esperando respuesta...");

            // Preparar el buffer para recibir la respuesta
            byte[] responseBuffer = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

            // Recibir el datagrama de respuesta
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Esperando respuesta...: el cubo de " + numberToSend + " es " + response);

            System.out.println("Adios...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
