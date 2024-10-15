
// Clase Hilo que implementa la lógica tanto de Primero como de Segundo
class Hilo extends Thread {
    private String nombre;

    // Constructor que recibe el nombre del hilo
    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    // Método run que ejecuta la lógica del hilo
    @Override
    public void run() {
        // Se imprime el nombre del hilo 20 veces
        for (int i = 1; i <= 20; i++) {
            System.out.println(nombre + " " + i);
        }
    }
}
//