#include "stdio.h"
#include "pch.h"
#include <iostream>
#include <stdio.h>

void main()
{
	int i = 0;
	int y = 0;
	int len;

	int array[] = { 65,116,32,50,48,32,68,101,103,114,101,101,115,44,32,84,104,101,32,87,101,97,116,104,101,114,32,73,115,32,71,114,101,97,116,46 };

	// First Sentence
	do
	{
		printf("%c", array[i]);
		i++;
	} while (array[i] != 46);
	printf("\n\n");
	i = 0;
	
	// Second Sentence
	do
	{
		if (array[i] <= 122 && array[i] >= 97) {
			y = array[i] - 32;
			printf("%c", y);
		}
		else if (array[i] <= 57 && array[i] >= 48 || array[i] <= 90 && array[i] >= 65 || array[i] == 32 || array[i] == 44) {
			y = array[i];
			printf("%c", y);
		}
		i++;
	} while (array[i] != 46);
	printf("\n\n");
	i = 0;

	// Third Sentence
	do
	{
		if (array[i] <= 90 && array[i] >= 65) {
			y = array[i] + 32;
			printf("%c", y);
		}
		else if (array[i] <= 0 && array[i] >= 64 || array[i] <= 127 || array[i] >= 66) {
			y = array[i];
			printf("%c", y);
		}
		i++;
	} while (array[i] != 46);
	printf("\n\n");

}
