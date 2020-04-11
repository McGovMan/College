#include <stdio.h>

#define MAX(x,y) ((x)>(y)?(x):(y))
#define OUT(x) printf("%d\n", x)
#define ODD(x) ((x) % 2 != 0)

int main() {
    int num1 = 7, num2 = 6, num3 = 3;
    printf ("Max of %d and %d is %d \n", num1, num2, MAX(num1,num2));
    OUT(4);
    if(ODD(num3)) puts ("Odd Number");
}
