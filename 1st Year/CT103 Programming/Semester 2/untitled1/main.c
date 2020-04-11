#include <stdio.h>
#include "string.h"

int main() {
    char arr[] = {'h', 'e', 'l', 'l', 'o'};
    char arr1[] = {'h', 'e', 'l', 'l', 'o'};

    if (strcmp(arr, arr1) == 0) {
        printf("same");
    } else {
        printf("Not same");
    }
}