#include <stdio.h>
#include <unistd.h>

int main() {
    printf("PID = %d\n", (int)getpid());
    printf("PPID = %d\n", (int)getppid());
    return 0;
}
