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
/*Resolución de Problemas
Durante el desarrollo del programa, pueden surgir algunos problemas comunes:

Errores en la creación de procesos: Si fork() devuelve un valor negativo, indica que el sistema no pudo crear un nuevo proceso. Esto puede deberse a la falta de recursos del sistema. Para solucionarlo, asegúrate de que no se estén creando demasiados procesos o verifica la configuración de tu sistema.

Secuencia de ejecución: A veces, los mensajes pueden no aparecer en el orden esperado debido a la naturaleza concurrente de los procesos. Asegúrate de que cada proceso espera correctamente a los hijos usando wait(), de modo que la salida sea predecible.

Faltante #include <sys/wait.h>: Si olvidaste incluir esta biblioteca, el compilador no reconocerá la función wait(), resultando en errores de compilación. Siempre verifica que todas las funciones utilizadas están correctamente incluidas.*/