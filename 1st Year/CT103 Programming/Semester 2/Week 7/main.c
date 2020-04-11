#include <stdio.h>
#include "string.h"
#include "stdlib.h"

int readFile();
int writeFile(FILE *file);

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

char rFileName[] = "//home//conor//Documents//Git//Programming-Labs//Semester 2//Week 7//users.txt";
char wFileName[] = "//home//conor//Documents//Git//Programming-Labs//Semester 2//Week 7//binary.bin";

int main() {

    FILE *fptr1 = fopen(wFileName, "wb+");

    if (!readFile())
    {
        printf( "File could not be opened !!\n" );
        return 0;
    }

    current = first;
    while (current != NULL)
    {
        writeFile(fptr1);
        current = current->next;
    }

    return 0;
}

int readFile() {
    char line[400];
    FILE *fptr = fopen(rFileName, "r");
    char *token;
    char delim[6] = ",";

    if (fptr == NULL) {
        printf("Error opening file ! \n");
        return 0;
    }

    // use fgets to skip first line
    fgets(line, 200, fptr);

    while (!feof(fptr)) {
        //next data line
        fgets(line, 200, fptr);

        current = (struct result*)malloc(sizeof(struct result));

        token = strtok(line, delim);
        strcpy(current->last, token);
        token = strtok(NULL, delim);
        strcpy(current->first, token);
        token = strtok(NULL, delim);
        current->age = atoi(token);
        token = strtok(NULL, delim);
        strcpy(current->email, token);

        printf("%d\n", current->age);
        if (first == NULL) {
            first = current;
            last = current;
        } else {
            last->next = current;
            last = current;
        }
    }
    fclose (fptr);

    return 1;
}

int writeFile(FILE *file) {
    fwrite(current, sizeof(struct result), 1, file);

    return 0;
}
