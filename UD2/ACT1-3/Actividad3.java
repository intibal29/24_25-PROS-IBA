public class Actividad3 {
    public static void main(String[] args) {
        // Crear el hilo
        Thread hilo = new Thread(() -> {
            // Código del hilo
        });

        // Mostrar nombre y prioridad iniciales
        System.out.println("El nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        // Cambiar el nombre y la prioridad del hilo
        hilo.setName("SUPER-HILO-DM2");
        hilo.setPriority(6);

        // Mostrar el nombre y prioridad modificados
        System.out.println("Ahora el nombre del hilo es " + hilo.getName() + " y tiene la prioridad " + hilo.getPriority());

        // Iniciar el hilo
        hilo.start();

        // Mensaje final
        System.out.println("Final programa");
    }
}
