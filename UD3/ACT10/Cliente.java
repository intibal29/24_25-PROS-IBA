package ejer10;
import java.io.*;
import java.net.*;

public class Cliente {
 public static void main(String[] args) {
     try {
         // Crear socket
         DatagramSocket socket = new DatagramSocket(34567);

         // Crear objeto Tenista
         Tenista tenista = new Tenista("del Potro", 198);

         // Serializar objeto
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(baos);
         oos.writeObject(tenista);
         oos.flush();
         byte[] data = baos.toByteArray();

         // Enviar objeto al servidor
         InetAddress address = InetAddress.getByName("localhost");
         DatagramPacket packet = new DatagramPacket(data, data.length, address, 12348);
         System.out.println("Envío el objeto: " + tenista);
         socket.send(packet);

         // Esperar respuesta del servidor
         System.out.println("Esperando datagrama.......");
         byte[] buffer = new byte[1024];
         DatagramPacket response = new DatagramPacket(buffer, buffer.length);
         socket.receive(response);

         // Deserializar objeto recibido
         ByteArrayInputStream bais = new ByteArrayInputStream(response.getData());
         ObjectInputStream ois = new ObjectInputStream(bais);
         Tenista tenistaModificado = (Tenista) ois.readObject();

         // Mostrar objeto recibido
         System.out.println("He recibido el objeto: " + tenistaModificado);

         // Cerrar socket
         System.out.println("Fin del cliente");
         socket.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}