#include "pch.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void getName(char emp[]);
int getID(char emp[]);
double getHours(char emp[]);

char firstName[40];
char surname[40];
int ID;
double hours[5];

void main()
{
	char emp1[] = "Smith,Fred,2214,,5,7,8.5,10.0";
	char emp2[] = "Murphy,Sarah,1579,8.5,5,5,8,8";

//	getName(emp1);
//	getID(emp1);
//	getHours(emp1);
	printf("Employee %s %s, ID: %d, worked the following hours:\n", firstName, surname, ID);
	printf("Monday:%.2lf Tuesday:%.2lf Wednesday:%.2lf Thursday:%.2lf Friday:%.2lf \n", hours[0], hours[1], hours[2], hours[3], hours[4]);

	puts("");

	getName(emp2);
	getID(emp2);
	getHours(emp2);
	printf("Employee %s %s, ID: %d, worked the following hours:\n", firstName, surname, ID);
	printf("Monday:%.2lf Tuesday:%.2lf Wednesday:%.2lf Thursday:%.2lf Friday:%.2lf \n", hours[0], hours[1], hours[2], hours[3], hours[4]);

}


void getName(char emp[])
{
	int y = 1;
	int i = 0;
	while (emp[i] != '\0') {

	}


}

int getID(char emp[])
{
	// your code goes here

	return ID;
}

double getHours(char emp[])
{
	int totalHours = 0;
	// your code goes here

	return totalHours;
}
