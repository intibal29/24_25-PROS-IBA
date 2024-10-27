// Resolución de problemas: se asegura la impresión correcta del mensaje de cada hilo.
// Se verifica que el hilo ejecute su mensaje de ejecución correctamente en run().

class Hilo extends Thread {
    private String mensaje;

    // Constructor que recibe el mensaje del hilo
    public Hilo(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método que ejecuta la lógica del hilo
    @Override
    public void run() {
        System.out.println("Ejecutando " + mensaje);
    }
}
