#include <stdio.h>
#include "string.h"
#include "stdlib.h"

typedef struct
{
	int day, month, year;
} date;

typedef struct 
{
	char firstName[50];
	char lastName[50];
	char email[50];
	date dob;
} person;

char months[12][12] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
int numContacts = 0;
person people[10];
  
int readFile(char *fileName);
date getDate(char *dateString);
int getAge(date dob);
char *getMonth(int month);
void printPerson(person p1);

int  main()
{
	char fileName[] = "//home//conor//Documents//College//Programming-College//Projects//Assesment//Semester 2//Week 2//people.txt";
	int i=0;

	if (!readFile(fileName)) 
	{
		printf( "File could not be opened !!\n" );
		return 0;
	} 
	
	
}

void printPerson(person p1)
{
	// INSERT YOUR CODE TO PRINT OUT PERSON AS PER SAMPLE OUTPUT 
    printf("First Name: %s\n", p1.firstName);
    printf("Last Name: %s\n", p1.lastName);
    printf("Email: %s\n", p1.email);
    printf("DOB: %s %d, %d\n", getMonth(p1.dob.month), p1.dob.day, p1.dob.year);
    printf("Age: %d\n\n", getAge(p1.dob));
}

int readFile(char *fileName)
{
	char line[400];
	FILE *fptr = fopen(fileName, "r");
	char *token;
	char delim[6]=",";  
	int n=0,i=0;
	person p1;
	date d1;

	if (fptr == NULL)
	{
		printf("Error opening file ! \n");
		return 0;
	}

	// use fgets to skip first line
	fgets (line, 400, fptr);

	//first data line
	fgets (line,400,fptr);
	while (!feof(fptr))
	{ 
		// INSERT YOUR CODE TO POPULATE p1 FROM THE LINE JUST READ
        if ((token = strtok(line, delim)) != NULL) strcpy(p1.firstName, token);
        if ((token = strtok(NULL, delim)) != NULL) strcpy(p1.lastName, token);
        if ((token = strtok(NULL, delim)) != NULL) strcpy(p1.email, token);
        if ((token = strtok(NULL, delim)) != NULL) d1 = getDate(token);

        p1.dob = d1;

		//next data line
		fgets(line, 200, fptr);
		n++;
		printPerson(p1);
		people[n] = p1;
	} 
	numContacts = n;

	fclose (fptr);

	return 1;
}

date getDate(char *dateString)
{
	date d1;
	char delim[2] = "/";
	char *token;
	int day, month, year;

	// INSERT YOUR CODE HERE TO USE STRTOK TO CONVERT THE DATE STRING INTO A DATE STRUCTURE
    if ((token = strtok(dateString, delim)) != NULL) day = atoi(token);
    if ((token = strtok(NULL, delim)) != NULL) month = atoi(token);
    if ((token = strtok(NULL, delim)) != NULL) year = atoi(token);

    d1.day = day;
    d1.month = month;
    d1.year = year;

	return d1;
}


int getAge(date dob)
{
	int age;

	age = 2019 - dob.year;

	return age;

}

char *getMonth(int month)
{
	return months[month-1];

}


