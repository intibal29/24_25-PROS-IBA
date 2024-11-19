#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    int n, i;
    
    printf("Introduce el número de procesos hijos a crear: ");
    scanf("%d", &n);
    
    pid_t pid;

    for(i = 0; i < n; i++) {
        pid = fork();  // Crear un proceso hijo

        if(pid < 0) {
            // Error en la creación del proceso hijo
            perror("fork error");
            exit(EXIT_FAILURE);
        }
        else if(pid == 0) {
            // Este es el proceso hijo
            printf("Soy el hijo %d, mi PID es %d y el PID de mi padre es %d\n", i+1, getpid(), getppid());
        }
        else {
            // Este es el proceso padre, espera a que el hijo termine
            wait(NULL);
            break;  // Solo el hijo debe continuar creando nuevos hijos
        }
    }

    return 0;
}
