package ejer10;
import java.io.*;
import java.net.*;

public class Servidor {
 public static void main(String[] args) {
     try {
         // Crear socket
         DatagramSocket socket = new DatagramSocket(12348);
         System.out.println("Esperando datagrama...");

         // Recibir datagrama del cliente
         byte[] buffer = new byte[1024];
         DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
         socket.receive(packet);

         // Obtener dirección y puerto del cliente
         InetAddress clientAddress = packet.getAddress();
         int clientPort = packet.getPort();

         // Deserializar objeto recibido
         ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
         ObjectInputStream ois = new ObjectInputStream(bais);
         Tenista tenista = (Tenista) ois.readObject();
         System.out.println("Recibo el objeto: " + tenista);
         System.out.println("IP de origen: " + clientAddress);
         System.out.println("Puerto de origen: " + clientPort);

         // Modificar objeto
         tenista.setApellido("Karlovic");
         tenista.setAltura(208);

         // Serializar objeto modificado
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(tenista);
         oos.flush();
         byte[] data = baos.toByteArray();

         // Enviar objeto modificado al cliente
         DatagramPacket response = new DatagramPacket(data, data.length, clientAddress, clientPort);
         System.out.println("Envío el objeto: " + tenista);
         socket.send(response);

         // Cerrar socket
         System.out.println("Fin del servidor");
         socket.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}
