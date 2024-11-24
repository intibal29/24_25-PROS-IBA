import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad1 {
    public static void main(String[] args) {
        try {
            // Obtenemos todas las direcciones IP asociadas al dominio
            InetAddress[] addresses = InetAddress.getAllByName("www.spotify.com");

            // Imprimimos las direcciones
            System.out.println("Direcciones asociadas a Spotify:");
            for (InetAddress address : addresses) {
                System.out.println(address);
            }
        } catch (UnknownHostException e) {
            // Manejo de error si no se puede resolver el dominio
            System.err.println("No se pudieron obtener las direcciones para www.spotify.com");
            e.printStackTrace();
        }
    }
}
