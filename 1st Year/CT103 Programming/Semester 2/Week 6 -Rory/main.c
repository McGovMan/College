// Semester 2 Week 18.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <stdio.h>
#include "string.h"
#include "stdlib.h"

struct contact
{
	char *UserName;
	char *firstName;
	char *lastName;
	char *displayName;
	char *jobTitle;
	char *department;
	char *officeNumber;
	char *officePhone;
	char *mobilePhone;
	char *fax;
	char *address;
	char *city;
	char *state;
	char *zip;
	char *country;
	struct contact *next;
};

struct contact *first = NULL;

int readFile(char *fileName);
void printContact(struct contact *theContact);

int main()
{
	char fileName[] = "//home//conor//Documents//Git//Programming-Labs//Semester 2//Week 6//contacts.txt";
	int i = 0;

	struct contact *current;

	if (!readFile(fileName))
	{
		printf("File could not be opened !!\n");
		return 0;
	}

	current = first;
	while (current != NULL)
	{
		printContact(current);
		current = current->next;
	}


	return 0;
}

void printContact(struct contact *theContact)
{

    printf("\nUser Name: %s\n", theContact->UserName);
    printf("First Name: %s\n", theContact->firstName);
    printf("Last Name: %s\n", theContact->lastName);
    printf("Display Name: %s\n", theContact->displayName);
    printf("Job Title: %s\n", theContact->jobTitle);
    printf("Department: %s\n", theContact->department);
    printf("Office Number: %s\n", theContact->officeNumber);
    printf("Office Phone: %s\n", theContact->officePhone);
    printf("Mobile Phone: %s\n", theContact->mobilePhone);
    printf("Fax: %s\n", theContact->fax);
    printf("Address: %s\n", theContact->address);
    printf("City: %s\n", theContact->city);
    printf("State: %s\n", theContact->state);
    printf("ZIP: %s\n", theContact->zip);
    printf("Country or Region: %s\n", theContact->country);
}


int readFile(char *fileName)
{
	char line[400];
	FILE *fptr = fopen(fileName, "r");
	char *token;
	char delim[6] = ",";

	struct contact *last = NULL;
	struct contact *current = NULL;

	if (fptr == NULL)
	{
		printf("Error opening file ! \n");
		return 0;
	}

	// use fgets to skip first line
	fgets(line, 200, fptr);

	while (!feof(fptr))
	{

		//next data line
		fgets(line, 200, fptr);

		// INSERT CODE HERE - make sure to keep pointer to first structure allocated!
		// remember you have to allocate the structure as well as the strings inside it



		current = (struct contact*)malloc(sizeof(struct contact));

		token = strtok(line, delim);

		current->UserName = (char*)malloc((sizeof(token)));
		strcpy(current->UserName, token);
		token = strtok(line, delim);
        current->UserName = (char*)(malloc(sizeof(token)));
        strcpy(current->UserName, token);
        token = strtok(NULL, delim);
        current->firstName = (char*)(malloc(sizeof(token)));
        strcpy(current->firstName, token);
        token = strtok(NULL, delim);
        current->lastName = (char*)(malloc(sizeof(token)));
        strcpy(current->lastName, token);
        token = strtok(NULL, delim);
        current->displayName = (char*)(malloc(sizeof(token)));
        strcpy(current->displayName, token);
        token = strtok(NULL, delim);
        current->jobTitle = (char*)(malloc(sizeof(token)));
        strcpy(current->jobTitle, token);
        token = strtok(NULL, delim);
        current->department = (char*)(malloc(sizeof(token)));
        strcpy(current->department, token);
        token = strtok(NULL, delim);
        current->officeNumber = (char*)(malloc(sizeof(token)));
        strcpy(current->officeNumber, token);
        token = strtok(NULL, delim);
        current->officePhone = (char*)(malloc(sizeof(token)));
        strcpy(current->officePhone, token);
        token = strtok(NULL, delim);
        current->mobilePhone = (char*)(malloc(sizeof(token)));
        strcpy(current->mobilePhone, token);
        token = strtok(NULL, delim);
        current->fax = (char*)(malloc(sizeof(token)));
        strcpy(current->fax, token);
        token = strtok(NULL, delim);
        current->address = (char*)(malloc(sizeof(token)));
        strcpy(current->address, token);
        token = strtok(NULL, delim);
        current->city = (char*)(malloc(sizeof(token)));
        strcpy(current->city, token);
        token = strtok(NULL, delim);
        current->state = (char*)(malloc(sizeof(token)));
        strcpy(current->state, token);
        token = strtok(NULL, delim);
        current->zip = (char*)(malloc(sizeof(token)));
        strcpy(current->zip, token);
        token = strtok(NULL, delim);
        current->country = (char*)(malloc(sizeof(token)));
        strcpy(current->country, token);


		if (first == NULL) {
			/*first = (struct contact *)malloc(sizeof(contact));
			first->next = NULL;
			current = first;*/
			first = current;
			last = current;
		}
		else {
			/*last = (struct contact *)malloc(sizeof(contact));
			current->next = last;
			current = last;
			current->next = NULL;*/
			last->next = current;
			last = current;
		}

	}

	fclose(fptr);

	return 1;
}