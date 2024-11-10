class HiloB extends Thread {
    private Contador contador;

    public HiloB(String n, Contador c) {
        setName(n);
        contador = c;
    }

    public void run() {
        for (int j = 0; j < 100; j++) { // Decrementar 100 veces
            contador.decrementa();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " contador vale " + contador.getValor());
    }
}