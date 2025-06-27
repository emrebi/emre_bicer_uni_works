#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

#define ARRAY_SIZE 10

int main() {
    int array[ARRAY_SIZE];

    // Dizi elemanlarını sıfırla
    for (int i = 0; i < ARRAY_SIZE; i++) {
        array[i] = 0;
    }

    // Fork kullanarak 10 tane child process oluştur
    for (int i = 0; i < ARRAY_SIZE; i++) {
        pid_t pid = fork();

        // Fork hatası kontrolü
        if (pid < 0) {
            perror("Fork error");
            return 1;
        }

        // Child process
        if (pid == 0) {
            // Dizi elemanlarını artır
            for (int j = i; j < ARRAY_SIZE; j++) {
                array[j]++;
            }
            printf("The array of %d. child process :", i);
            for (int j = 0; j < ARRAY_SIZE; j++) {
                printf("%d ",array[j]);
            }
            printf("\n");
            // Child process işini bitir
            return 0;
        }
    }

    // Parent process, tüm child process'lerin bitmesini bekle
    for (int i = 0; i < ARRAY_SIZE; i++) {
        wait(NULL);
    }

    // Diziyi yazdır
    printf("Dizi: ");
    for (int i = 0; i < ARRAY_SIZE; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");

    return 0;
}