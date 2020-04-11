#include <stdio.h>
#include <string.h>

int readFile(char fileName[]);

void main(int argc, char *argv[]) {

	char *fileName = argv[1];
	char *firstArg = argv[2];
	char *secondArg = argv[3];
	char *thirdArg = argv[4];

	FILE *fptr = fopen (fileName, "r");

	if (fptr == NULL) {
		printf ("\nCannot open file.");
	}

	if ((strcmp(firstArg, "/l") == 0) || (strcmp(secondArg, "/l") == 0) || (strcmp(thirdArg, "/l") == 0)) {
		int count = 1;
		char line[400];
		fseek(fptr, 0, SEEK_SET);
		fgets (line,200,fptr);
		while (!feof(fptr)) {
			fgets (line,400,fptr);
			count++;
		}
		printf("Lines in text Doc: %d\n", count);
	}

	if ((strcmp(firstArg, "/s") == 0) || (strcmp(secondArg, "/s") == 0) || (strcmp(thirdArg, "/s") == 0)) {
		fseek(fptr, 0, SEEK_SET);
		int bytes = 0;

		for (bytes = 0; getc(fptr) != EOF; ++bytes);
		printf("Size of text Doc: %d bytes\n", bytes);
	}

	if ((strcmp(firstArg, "/c") == 0) || (strcmp(secondArg, "/c") == 0) || (strcmp(thirdArg, "/c") == 0)) {
		int count = 0;
		int i = 0;
		char line[200];
		fseek(fptr, 0, SEEK_SET);
		fgets (line,200,fptr);
		while (!feof(fptr)) {
			for (i = 0; i < sizeof(line); i++) {
				if (line[i] == 10) break;
			}
			fgets (line,400,fptr);
			count += i;
		}
		printf("Characters in text Doc: %d\n", count);
	}

	fclose (fptr);
}
