#include "pch.h"
#include <iostream>

int main()
{
	int mathsGrade, engGrade, irishGrade, phyGrade, enginGrade;

	printf("\n Enter your Maths Mark: ");
	scanf_s("%d", &mathsGrade);

	printf("\n Enter your English Mark: ");
	scanf_s("%d", &engGrade);

	printf("\n Enter your Irish Mark: ");
	scanf_s("%d", &irishGrade);

	printf("\n Enter your Physics Mark: ");
	scanf_s("%d", &phyGrade);

	printf("\n Enter your Engineering Mark: ");
	scanf_s("%d", &enginGrade);

	float average = (mathsGrade + engGrade + irishGrade + phyGrade + enginGrade) / 5;
	printf("Average Mark = %.2f", average);

	printf("\nPassed: ");

	if (mathsGrade >= 40) { printf("Maths, "); }
	if (engGrade >= 40) { printf("English, "); }
	if (irishGrade >= 40) { printf("Irish, "); }
	if (phyGrade >= 40) { printf("Physics, "); }
	if (enginGrade >= 40) { printf("Engineering"); }
	
	printf("\nFailed: ");

	if (mathsGrade < 40) { printf("Maths, "); }
	if (engGrade < 40) { printf("English, "); }
	if (irishGrade < 40) { printf("Irish, "); }
	if (phyGrade < 40) { printf("Physics, "); }
	if (enginGrade < 40) { printf("Engineering"); }

	float highest = 0;
	float mark[5] = { mathsGrade, engGrade, irishGrade, phyGrade, enginGrade };

	int i;
	 for (i = 0; i < 5; i++) 
		{ 
			if (mark[i] > highest) 
			highest = mark[i];       
		}
	 printf("Highest Mark = %f", highest);
}
