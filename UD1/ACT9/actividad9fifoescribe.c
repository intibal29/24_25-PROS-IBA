#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>

int main(void) {
    const char *fifoPath = "FIFO2";

    // Crear el FIFO con permisos de lectura y escritura
    if (mkfifo(fifoPath, 0666) == -1) {
        perror("Error al crear el FIFO (puede que ya exista)");
        // Puedes decidir salir o continuar, dependiendo de la lógica deseada
    }

    int fp;
    char saludo[] = "Un saludo !!!!!\n";

    // Abrir el FIFO en modo escritura
    fp = open(fifoPath, O_WRONLY);
    if (fp == -1) {
        perror("Error al abrir el FIFO");
        exit(1);
    }

    printf("Mandando información al FIFO...\n");
    write(fp, saludo, strlen(saludo));  // Escribir el saludo en el FIFO
    close(fp);  // Cerrar el FIFO tras la escritura

    return 0;
}
