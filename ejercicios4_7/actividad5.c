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
/*Resolución de Problemas del Ejercicio
Errores en fork():

Problema: fork() puede devolver un valor negativo si no puede crear un proceso.
Solución: Verifica los recursos del sistema y maneja el error usando perror().
Salida desordenada:

Problema: Los mensajes pueden no aparecer en el orden esperado debido a la ejecución concurrente.
Solución: Usa wait(NULL) en el proceso padre para asegurar que los hijos terminen antes de continuar.
Falta de #include <sys/wait.h>:

Problema: wait() no estará definida sin esta inclusión.
Solución: Asegúrate de incluir #include <sys/wait.h>.
Entradas no válidas:

Problema: Si el usuario ingresa un valor no válido, el programa puede fallar.
Solución: Valida la entrada usando un chequeo en scanf().
Procesos huérfanos o zombies:

Problema: Si los hijos no terminan correctamente, pueden quedarse huérfanos.
Solución: Usa wait(NULL) para recoger los estados de los hijos.
Permisos de ejecución:

Problema: Puede que no tengas permiso para ejecutar el archivo.
Solución: Asegúrate de dar permisos de ejecución con chmod +x actividad5.
Comportamiento de los hijos:

Problema: Los hijos deben terminar después de imprimir su mensaje.
Solución: Cada hijo debe completar su tarea y terminar correctamente.
*/