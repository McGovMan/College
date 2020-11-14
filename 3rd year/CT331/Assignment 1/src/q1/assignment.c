#include <stdio.h>

int main(int arg, char* argc[]){
    int intNormal;
    int *intPointer;
    long *longPointer;
    double *doublePointer;
    char **charPointerToPointer;

    printf("Printing out all value sizes.\n\n");

    printf("Integer size: %zu bytes\n", sizeof(intNormal));
    printf("Integer pointer size: %zu bytes\n",sizeof(intPointer));
    printf("Long pointer size: %zu bytes\n", sizeof(longPointer));
    printf("Double pointer size: %zu bytes\n", sizeof(doublePointer));
    printf("Char pointer to pointer size: %zu bytes\n",  sizeof(charPointerToPointer));

    /*
     * Output:
     * Integer size: 4 bytes
     * Integer pointer size: 8 bytes
     * Long pointer size: 8 bytes
     * Double pointer size: 8 bytes
     * Char pointer to pointer size: 8 bytes
     *
     * intNormal is the only variable that is not pointer, it is also the only variable that is
     * 4 bytes instead of 8 bytes. This is because the int data takes up 4 bytes of memory to
     * hold it's value (range: -2^15, 2^15). The rest take up 8 bytes as they are all pointers.
     * Pointers take up 8 bytes as they are the address of the memory space where the value can
     * be saved.
     */

    return 0;
}
