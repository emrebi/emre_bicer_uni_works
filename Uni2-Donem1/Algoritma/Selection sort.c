#include <stdio.h>

// Diziyi ekrana yazd�ran fonksiyon
void printArray(int array[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", array[i]);
    }
    printf("\n");
}

// Selection sort algoritmas�
void selectionSort(int array[], int size) {
    for (int i = 0; i < size - 1; i++) {
        int minIndex = i;

        // Dizinin geri kalan�nda en k���k eleman� bul
        for (int j = i + 1; j < size; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }

        // Mevcut elemanla en k���k olan� yer de�i�tir
        if (minIndex != i) {
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}

int main() {
    int data[] = {29, 10, 14, 37, 13};
    int size = sizeof(data) / sizeof(data[0]);

    printf("Original array:\n");
    printArray(data, size);

    selectionSort(data, size);

    printf("Sorted array in ascending order:\n");
    printArray(data, size);

    return 0;
}

