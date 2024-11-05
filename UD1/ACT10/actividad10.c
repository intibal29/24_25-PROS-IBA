#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <sys/wait.h>

void manejador(int senal) {
    printf("Padre recibe señal....%d\n", senal);
}

int main() {
    pid_t pid = fork();

    if (pid < 0) {
        perror("Error al crear el proceso hijo");
        return 1;
    } else if (pid == 0) {
        // Proceso hijo
        pid_t ppid = getppid(); // Obtenemos el PID del padre

        // Enviamos tres señales SIGUSR1 al padre
        for (int i = 0; i < 3; i++) {
            kill(ppid, SIGUSR1);
            sleep(1); // Espera un segundo entre señales para que se puedan ver en pantalla
        }

        // Enviamos SIGKILL al padre para terminarlo
        kill(ppid, SIGKILL);
        exit(0);
    } else {
        // Proceso padre
        // Configuramos el manejador para la señal SIGUSR1
        signal(SIGUSR1, manejador);

        // Esperamos indefinidamente a que el padre reciba señales
        while (1) {
            pause(); // El proceso se detiene aquí hasta recibir una señal
        }
    }

    return 0;
}
