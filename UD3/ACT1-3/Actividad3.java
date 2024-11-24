import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad3 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                // Si no hay parámetros, obtener las direcciones locales
                System.out.println("Direcciones IP locales:");
                InetAddress localHost = InetAddress.getLocalHost();
                System.out.println("Dirección IP: " + localHost.getHostAddress());
                System.out.println("Nombre: " + localHost.getHostName());

                // Obtener todas las interfaces de red locales
                InetAddress[] localAddresses = InetAddress.getAllByName(localHost.getHostName());
                for (InetAddress address : localAddresses) {
                    System.out.println(address);
                }
            } else {
                // Obtener la dirección IP del dominio pasado como argumento
                String dominio = args[0];
                InetAddress[] addresses = InetAddress.getAllByName(dominio);

                for (InetAddress address : addresses) {
                    System.out.println("Dirección IP: " + address.getHostAddress());
                    System.out.println("Nombre: " + address.getHostName());
                    System.out.println(address);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No se pudieron resolver las direcciones.");
            e.printStackTrace();
        }
    }
}
