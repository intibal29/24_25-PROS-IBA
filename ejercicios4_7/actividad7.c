#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    // Definición de la variable inicial
    int valor = 6;
    
    // Imprimir el valor inicial
    printf("Valor inicial de la variable: %d\n", valor);

    // Crear el proceso hijo
    pid_t pid = fork();

    if (pid < 0) {
        // Si la creación del proceso falla
        perror("Error al crear el proceso");
        return 1;
    } else if (pid == 0) {
        // Proceso hijo
        valor -= 5; // Resta 5 en el proceso hijo
        printf("Variable en Proceso Hijo: %d\n", valor);
    } else {
        // Proceso padre
        wait(NULL); // Esperar a que el proceso hijo termine
        valor += 5; // Incrementa 5 en el proceso padre
        printf("Variable en Proceso Padre: %d\n", valor);
    }

    return 0;
}
