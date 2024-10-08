
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

#define BUF_SIZE 50

int main() {
    int pipe1[2]; // Pipe de abuelo a hijo
    int pipe2[2]; // Pipe de hijo a nieto

    // Crear pipes
    if (pipe(pipe1) == -1 || pipe(pipe2) == -1) {
        perror("Error creando pipe");
        exit(EXIT_FAILURE);
    }

    pid_t pid_hijo = fork();

    if (pid_hijo < 0) {
        perror("Error creando el proceso hijo");
        exit(EXIT_FAILURE);
    }

    if (pid_hijo == 0) { // Proceso hijo
        close(pipe1[1]); // Cerrar la escritura del pipe1
        close(pipe2[0]); // Cerrar la lectura del pipe2

        char buf[BUF_SIZE];
        
        // Recibir mensaje del abuelo
        read(pipe1[0], buf, BUF_SIZE);
        printf("EL HIJO recibe mensaje de abuelo: %s\n", buf);

        // Enviar mensaje al nieto
        const char *msg_hijo_a_nieto = "saludo del padre..";
        write(pipe2[1], msg_hijo_a_nieto, strlen(msg_hijo_a_nieto) + 1);
        printf("EL HIJO envia un mensaje al NIETO...\n");

        // Recibir mensaje del nieto
        read(pipe1[0], buf, BUF_SIZE);
        printf("EL HIJO recibe mensaje de su hijo: %s\n", buf);

        // Enviar mensaje al abuelo
        const char *msg_hijo_a_abuelo = "saludo del hijo..";
        write(pipe1[1], msg_hijo_a_abuelo, strlen(msg_hijo_a_abuelo) + 1);
        close(pipe1[0]); // Cerrar lectura del pipe1
        close(pipe2[1]); // Cerrar escritura del pipe2
        exit(0);

    } else { // Proceso abuelo
        pid_t pid_nieto = fork();

        if (pid_nieto < 0) {
            perror("Error creando el proceso nieto");
            exit(EXIT_FAILURE);
        }

        if (pid_nieto == 0) { // Proceso nieto
            close(pipe2[1]); // Cerrar la escritura del pipe2
            char buf[BUF_SIZE];
            
            // Recibir mensaje del padre
            read(pipe2[0], buf, BUF_SIZE);
            printf("EL NIETO recibe mensaje del padre: %s\n", buf);
            
            // Enviar mensaje al hijo
            const char *msg_nieto_a_hijo = "saludo del nieto..";
            write(pipe1[1], msg_nieto_a_hijo, strlen(msg_nieto_a_hijo) + 1);
            close(pipe2[0]); // Cerrar lectura del pipe2
            exit(0);
        } else { // Proceso abuelo
            close(pipe1[0]); // Cerrar lectura del pipe1
            const char *msg_abuelo_a_hijo = "saludo del abuelo..";
            write(pipe1[1], msg_abuelo_a_hijo, strlen(msg_abuelo_a_hijo) + 1);
            printf("EL ABUELO ENVIA UN MENSAJE AL HIJO...\n");

            // Esperar a que el hijo termine
            wait(NULL);

            // Recibir mensaje del hijo
            char buf[BUF_SIZE];
            read(pipe1[0], buf, BUF_SIZE);
            printf("EL ABUELO recibe mensaje del HIJO: %s\n", buf);
            close(pipe1[1]); // Cerrar escritura del pipe1
        }
    }

    return 0;
}
/*Explicación del código
Creación de Pipes:

Se crean dos pipes: pipe1 para la comunicación entre el abuelo y el hijo, y pipe2 para la comunicación entre el hijo y el nieto.
Creación de Procesos:

Se utiliza fork() para crear el proceso hijo. Si fork() se llama nuevamente dentro del proceso hijo, se crea el proceso nieto.
Comunicación entre Procesos:

El abuelo envía un mensaje al hijo, que lo recibe y lo imprime. Luego, el hijo envía un mensaje al nieto.
El nieto recibe el mensaje del padre (hijo) y lo imprime, luego envía su propio mensaje al hijo.
Finalmente, el hijo envía un mensaje de vuelta al abuelo.
Cierre de Pipes:

Es importante cerrar los extremos de los pipes que no se utilizan en cada proceso para evitar fugas de recursos.*/