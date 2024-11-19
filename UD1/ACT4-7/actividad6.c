#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid1, pid2, pid3;

    // Crear el primer hijo (hijo1)
    pid1 = fork();

    if (pid1 < 0) {
        perror("Error al crear el hijo 1");
        exit(EXIT_FAILURE);
    }
    
    // Código para el primer hijo (hijo1)
    if (pid1 == 0) {
        // Crear el segundo hijo (hijo2)
        pid2 = fork();
        
        if (pid2 < 0) {
            perror("Error al crear el hijo 2");
            exit(EXIT_FAILURE);
        }

        if (pid2 == 0) {
            // Este es el hijo 2
            printf("Yo soy el hijo 2, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        } else {
            // Código para el primer hijo (hijo1) que espera al hijo 2
            wait(NULL);
            printf("Yo soy el hijo 1, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        }
    } else {
        // Código para el proceso padre
        pid3 = fork();
        
        if (pid3 < 0) {
            perror("Error al crear el hijo 3");
            exit(EXIT_FAILURE);
        }

        if (pid3 == 0) {
            // Este es el hijo 3
            printf("Yo soy el hijo 3, mi padre es PID= %d, yo soy PID= %d\n", getppid(), getpid());
        } else {
            // Código para el proceso padre
            wait(NULL); // Esperar a que los hijos terminen
            wait(NULL);
        }
    }

    return 0;
}