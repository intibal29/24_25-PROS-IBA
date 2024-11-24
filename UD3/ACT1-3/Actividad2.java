import java.net.InetAddress;
import java.net.UnknownHostException;

public class Actividad2 {
    public static void main(String[] args) {
        // Verificamos si se pasó un parámetro en la ejecución
        if (args.length == 0) {
            // Si no hay parámetros, mostramos un mensaje de error
            System.out.println("Se necesita una URL para obtener su dirección");
        } else {
            try {
                // Obtenemos el dominio desde el primer parámetro
                String dominio = args[0];
                // Obtenemos todas las direcciones asociadas al dominio
                InetAddress[] addresses = InetAddress.getAllByName(dominio);

                // Mostramos las direcciones obtenidas
                System.out.println("Las direcciones asociadas a " + dominio + " son:");
                for (InetAddress address : addresses) {
                    System.out.println(address);
                }
            } catch (UnknownHostException e) {
                // Manejo de error si no se puede resolver el dominio
                System.err.println("No se pudieron obtener las direcciones para " + args[0]);
                e.printStackTrace();
            }
        }
    }
}
