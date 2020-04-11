#include <stdio.h>
#include "string.h"
#include "stdlib.h"

int readFile(FILE *file);

struct result {
    char last[40];
    char first[40];
    int age;
    char email[40];
    struct result *next; // you only need this in the second program
};

struct result *first = NULL;
struct result *current = NULL;
struct result *last = NULL;

char rFileName[] = "//home//conor//Documents//Git//Programming-Labs//Semester 2//Week 7//binary.bin";

int main() {
    FILE *fptr = fopen(rFileName, "rb+");

    current = first;

    readFile(fptr);

    current = first;

    int tempAge, i= 0, input = 1;

    while (input != 0) {
        printf("Enter which age you want to search for: ");
        scanf("%d", &tempAge);

        while (current != NULL) {
            if (tempAge == current->age) {
                printf("%s %s\n", current->first, current->last);
            }
            current = current->next;
        }
        printf("To quit press 0, to continue press any number: ");
        scanf("%d", &input);
    }

    return 0;
}

int readFile(FILE *file) {

    while(!feof(file))
    {
        if (first == NULL)
        {
            first = (struct result *)malloc(sizeof(struct result));
            first->next = NULL;
            current = first;
        }
        else
        {
            last = (struct result *)malloc(sizeof(struct result));
            current->next = last;
            current = last;
            last->next = NULL;
        }

        fread(current, sizeof(struct result), 1, file);
    }
}
