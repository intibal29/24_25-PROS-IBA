import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Actividad5 {

    public static void main(String[] args) {
        // Llamar al método VisualizarConexión para realizar la solicitud
        VisualizarConexión();
    }

    // Método privado para manejar la conexión y la respuesta
    private static void VisualizarConexión() {
        try {
            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.vitoria-gasteiz.com"))
                .GET() // Método GET
                .build();

            // Enviar solicitud y recibir respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir detalles de la respuesta
            System.out.println("Conexión con www.vitoria-gasteiz.com");
            System.out.println("==========================");
            System.out.println("\tMétodo toString():" + response.toString());
            System.out.println("\tMétodo getStatusCode():" + response.statusCode());
            System.out.println("\tMétodo getContentType():" + response.headers().firstValue("Content-Type").orElse("N/A"));

        } catch (Exception e) {
            System.out.println("Error durante la conexión: " + e.getMessage());
        }
    }
}
