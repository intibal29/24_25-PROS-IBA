#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid;
    int i;

    // Imprimir PID del proceso padre
    pid_t parent_pid = getpid();
    printf("Proceso padre %d\n", parent_pid);

    for (i = 1; i <= 3; i++) {
        pid = fork();  // Crear un nuevo proceso hijo

        if (pid == -1) {
            perror("Error en fork");
            exit(1);
        } else if (pid == 0) {
            // Código del proceso hijo
            printf("Soy el hijo %d, Mi padre es %d y mi PID es %d\n", i, parent_pid, getpid());
            exit(0);
        }
        // El proceso padre solo ejecuta el bucle una vez
        if (pid > 0) {
            break; // Salir del bucle en el padre
        }
    }

    // Esperar a que todos los hijos terminen
    for (i = 0; i < 3; i++) {
        wait(NULL);
    }

    return 0;
}


/*
gcc -o actividad4 actividad4.c
./actividad4
*/     

/*Resolución de Problemas
Errores en fork(): Se maneja con perror().
Comportamiento Inesperado: Asegúrate de que el padre solo ejecuta el bucle una vez.
Esperar a Hijos: Usa wait(NULL) para evitar procesos huérfanos.
*/