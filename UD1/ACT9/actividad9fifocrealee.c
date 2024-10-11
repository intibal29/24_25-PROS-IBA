#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(void) {
    int fp;
    char buffer[256];  // Buffer para almacenar el mensaje

    // Intentar abrir el FIFO creado por el programa de escritura
    while (1) {
        fp = open("FIFO2", O_RDONLY);  // Abrir FIFO en modo lectura
        if (fp == -1) {
            perror("Error al abrir FIFO");
            exit(1);
        }

        // Leer del FIFO
        printf("Obteniendo información...\n");
        ssize_t bytesleidos = read(fp, buffer, sizeof(buffer) - 1);
        if (bytesleidos > 0) {
            buffer[bytesleidos] = '\0';  // Asegurarse de que el buffer es una cadena
            printf("%s", buffer);        // Mostrar el mensaje
        }

        close(fp);  // Cerrar el archivo FIFO tras la lectura
    }

    return 0;
}
