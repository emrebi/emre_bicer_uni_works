#include <stdio.h>
#include <stdlib.h>

typedef unsigned short int UINT16;

UINT16 sbox_table[16] = {0xE, 0x4, 0xD, 0x1, 0x2, 0xF, 0xB, 0x8, 0x3, 0xA, 0x6, 0xC, 0x5, 0x9, 0x0, 0x7};

int lin_appr_table[16][16];

void construct_lin_appr_table() {
    UINT16 i, j, k;
    UINT16 input_mask, output_mask;
    UINT16 input, output;
    int counter;

    for (i = 0; i < 16; i++) {
        for (j = 0; j < 16; j++) {
            input_mask = i;
            output_mask = j;
            counter = 0;

            for (k = 0; k < 16; k++) {
                input = k;
                output = sbox_table[input];

                UINT16 input_parity = __builtin_parity(input & input_mask);
                UINT16 output_parity = __builtin_parity(output & output_mask);

                if (input_parity == output_parity) {
                    counter++;
                }
            }

            lin_appr_table[i][j] = counter - 8;
        }
    }

    printf("Linear Approximation Table:\n");
    for (i = 0; i < 16; i++) {
        for (j = 0; j < 16; j++) {
            printf("%4d", lin_appr_table[i][j]);
        }
        printf("\n");
    }
}

int main() {
    construct_lin_appr_table();
    return 0;
}
