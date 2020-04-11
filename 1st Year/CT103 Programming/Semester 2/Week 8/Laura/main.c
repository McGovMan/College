
#include <stdio.h>

int main(int argc, char *argv[])
{

	char *file = argv[1];
	char *options = argv[2];

	FILE *fptr;
	fptr = fopen(file, "r");
	char op = options[0];
	char line[400];
	int counter = 0;
	char charz[80000];
	int i = 0;

	if (fptr == NULL)
	{
		printf("File could not be opened !!\n");
		return 0;
	}

	while (!feof(fptr))
	{
		fgets(line, 200, fptr);
		counter++;
	}

	fseek(fptr, 0, SEEK_SET);

	while (!feof(fptr))
	{
		fscanf(fptr, "%s", charz[i]);
		i++;
	}
	int size = sizeof(charz);
	int charactersWithoutNewline = i - (counter - 1);
	fclose(fptr);

	switch (op)
	{
	case '/l': //Number of lines in file	
		printf("The number of lines in this file is %d \n", counter);
		break;

	case '/s': //size of file in bytes
		printf("The size of the file is", size);
		break;

	case '/c': //number of characters not including newline characters
		printf("The numbers of characters in this file (not including new line characters) is %d", charactersWithoutNewline);
		break;

	default:
		printf("Invalid argument  - Quitting \n");
	}
}
