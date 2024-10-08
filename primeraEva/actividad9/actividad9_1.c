#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    int fp;
    char buffer[256]; // Buffer para almacenar el mensaje

    // Intentar abrir el FIFO creado por el otro programa
    while (1) {
        fp = open("FIFO2", O_RDONLY); // Abrir FIFO en modo lectura
        if (fp == -1) {
            perror("Error al abrir FIFO");
            exit(1);
        }

        // Leer del FIFO
        printf("Obteniendo información...\n");
        ssize_t bytesleidos = read(fp, buffer, sizeof(buffer) - 1);
        if (bytesleidos > 0) {
            buffer[bytesleidos] = '\0'; // Asegurarse de que el buffer es una cadena
            printf("%s", buffer);
        }

        close(fp);
    }

    return 0;
}
/*Resolución de problemas:
Error al crear FIFO: Si ya existía un FIFO con el mismo nombre, el programa fallaría. Esto se resolvió utilizando mkfifo, que no genera error si el FIFO ya está creado.

Lectura incompleta: El programa actividad9fifocrealee podía leer byte a byte, pero para evitar complicaciones con mensajes grandes, el buffer se amplió para leer bloques más grandes, mejorando el rendimiento.

Permisos del FIFO: Se aseguraron los permisos correctos (0666) al crear el FIFO para que ambos programas puedan leer y escribir sin problemas.

Claridad del código: Se han añadido comentarios en las partes importantes del código para hacerlo más legible y fácil de entender.*/