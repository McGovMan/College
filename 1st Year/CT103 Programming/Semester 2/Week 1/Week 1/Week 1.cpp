


#include "pch.h"
#include <stdio.h>
#include "string.h"

FILE *openFile(char *fileName, char *mode);
void closeFile(FILE *fptr);
float readData(FILE *fptr, char* item);
void addData(FILE *fptr);

void main(void)
{
	FILE *fptr;
	char fileName[] = "C:\\data.txt";
	char item[10];

	printf("Enter Product Name <or quit to quit>: ");
	scanf("%s", item);
	
	while (!(strcmp(item, "quit") == 0)) {
		fptr = fopen(fileName, "r");
		float total = readData(fptr, item);
		printf("Total Sales for %s = %.2f\n", item, total);
		closeFile(fptr);
		printf("Enter Product Name <or quit to quit>: ");
		scanf("%s", item);
	}

}
float readData(FILE *fptr, char item[])
{
	char date[10], region[20], rep[10], fline[80], object[10];
	float units, unit, unitCost, total = 0;

	fgets(fline, 80, fptr);

	while (!feof(fptr))
	{
			fscanf(fptr, "%s\t%s\t%s\t%s\t%f\t%f\t%f\t%f\n", date, region, rep, object, &units, &unit, &unitCost);

			if ((strcmp(item, object)) == 0) {
				total = total + unitCost;
			}
	}
	return total;
}

void closeFile(FILE *fptr) {
	fclose(fptr);
}


