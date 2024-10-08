// Archivo: Actividad10.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>

/* --------------------------------------------------*/
/* Gestión de señales en proceso PADRE               */
void gestion_padre (int signal) {
    printf("Padre recibe señal...%d\n", signal);
}

/* Gestión de señales en proceso HIJO                */
void gestion_hijo (int signal) {
    printf("Hijo recibe señal...%d\n", signal);
}

/*****************************************************/
int main () {
    int pid_padre, pid_hijo;
    
    pid_padre = getpid();  // Obtener el PID del proceso padre
    pid_hijo = fork();     // Crear el proceso hijo
    
    switch (pid_hijo) {
        case -1: // Error en la creación del proceso hijo
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
            break;
        
        case 0:   // Código del hijo
            signal(SIGUSR1, gestion_hijo);  // Asignar manejador de señal en el hijo

            for (int i = 0; i < 3; i++) {
                sleep(1);  // Pausa de 1 segundo entre señales
                kill(pid_padre, SIGUSR1);  // Enviar señal SIGUSR1 al padre
                pause();  // Esperar la señal de respuesta del padre
            }

            // Después de enviar 3 señales, terminar al padre con SIGKILL
            sleep(1);
            kill(pid_padre, SIGKILL);  // Termina el proceso padre

            break;
        
        default:  // Código del padre
            signal(SIGUSR1, gestion_padre);  // Asignar manejador de señal en el padre

            while (1) {
                pause();  // Esperar la señal del hijo
                sleep(1);  // Pausa de 1 segundo antes de enviar la respuesta
                kill(pid_hijo, SIGUSR1);  // Enviar señal SIGUSR1 al hijo
            }

            break;
    }

    return 0;
}
