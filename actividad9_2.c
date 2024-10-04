#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/stat.h>

int main(void) {
    const char *fifoPath = "FIFO2";
    mkfifo(fifoPath, 0666); // Crear el FIFO con permisos de lectura y escritura

    int fp;
    char saludo[] = "Un saludo !!!!!\n";

    // Abrir el FIFO en modo escritura
    fp = open(fifoPath, O_WRONLY);
    if (fp == -1) {
        perror("Error al abrir el FIFO");
        exit(1);
    }

    printf("Mandando información al FIFO...\n");
    write(fp, saludo, strlen(saludo)); // Escribir el saludo en el FIFO
    close(fp);

    return 0;
}
