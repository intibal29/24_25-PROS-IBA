import java.net.URI;

public class Actividad4 {

    public static void main(String[] args) {
        // Creación de las URIs proporcionadas
        URI uri1 = URI.create("http://docs.oracle.com");
        URI uri2 = URI.create("http://docs.oracle.com/javase/7");
        URI uri3 = URI.create("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html");

        // Llamar al método Visualizar con cada URI
        Visualizar(uri1);
        Visualizar(uri2);
        Visualizar(uri3);
    }

    // Método privado para visualizar las propiedades de una URI
    private static void Visualizar(URI uri) {
        System.out.println("URI: " + uri.toString());
        System.out.println("\tHost: " + uri.getHost());
        System.out.println("\tPort: " + uri.getPort());
        System.out.println("\tPath: " + uri.getPath());
        System.out.println("\tScheme: " + uri.getScheme());
        System.out.println("\tAuthority: " + uri.getAuthority());
    }
}
