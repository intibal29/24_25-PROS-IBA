import java.security.*;
import java.util.*;

public class Actividad1 {
    public static void main(String[] args) {
        // Obtener todos los proveedores de seguridad disponibles
        Provider[] providers = Security.getProviders();

        // Buscar el proveedor SUN
        for (Provider provider : providers) {
            if (provider.getName().equalsIgnoreCase("SUN")) {
                System.out.println("** Proveedor " + provider.getName() + ", versión " + provider.getVersion() + " **");
                
                // Obtener los algoritmos de MessageDigest soportados por SUN
                Set<Provider.Service> services = provider.getServices();
                for (Provider.Service service : services) {
                    if ("MessageDigest".equalsIgnoreCase(service.getType())) {
                        System.out.println("Nombre del algoritmo: \"" + service.getAlgorithm() + "\"");
                    }
                }
                break;
            }
        }
    }
}
