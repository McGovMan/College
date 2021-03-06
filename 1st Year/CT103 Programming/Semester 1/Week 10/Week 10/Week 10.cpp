#include "pch.h"
#include "string.h"
#include "stdlib.h"
#include <stdio.h>
#include "math.h"

struct date
{
	int day, month, year;
};

struct customer
{
	char name[50];
	int accountNumber;
	double balance;
	struct date lastTrans;
};

int getDay(int month);
int getMonth();
int getYear();
double getBalance();

void printCustomers(struct customer customers[], int nCustomers);
void populateCustomers(struct customer customers[], int nCustomers);
int transaction(struct customer customers[], int accountNumber, double amount, int nCustomers);

int main()
{
	int i;

	struct customer customers[10];

	printf("%25s\t%13s\t%12s\t%s\n\n", "Name", "Account Number", "Balance", "Date of Last Transaction");

	populateCustomers(customers, 10);

	printCustomers(customers, 10);

	printf("\n\n");

	if (!(transaction(customers, 10001, -967.89, 10)))
	{
		printf("account number %d not found - transaction cancelled", 10001);
	}
	else
	{
		printf("account number %d - transaction processed", 10001);
	}
	printf("\n\n");

	if (!(transaction(customers, 33, -967.89, 10)))
	{
		printf("account number %d not found - transaction cancelled", 33);
	}
	else
	{
		printf("account number %d  - transaction processed", 33);
	}
	printf("\n\n");

	printf("%25s\t%13s\t%12s\t%s\n\n", "Name", "Account Number", "Balance", "Date of Last Transaction");

	printCustomers(customers, 10);

	printf("\n\n");

	return 0;
}

int getDay(int month)
{
	int day, max = 31;
	// this function should return a random day number, with the maximum varying depending on the month
	if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
		day = (rand() % 31) + 1;
	}
	else if (month == 4 || month == 6 || month == 9 || month == 11) {
		day = (rand() % 30) + 1;
	}
	else {
		day = (rand() % 28) + 1;
	}
	
	return day;
}

int getMonth()
{
	// this function should return a random number between 1 and 12
	int month = (rand() % 12) + 1;
	return month;
}

int getYear()
{
	// this function should return a random year
	int year = (rand() % 4) + 1;
	switch (year) {
	case 1:
		year = 2013;
		break;
	case 2:
		year = 2014;
		break;
	case 3:
		year = 2015;
		break;
	case 4:
		year = 2016;
		break;
	default:
		printf("getYear() did not generate an appropriate year. It generated the number: %d", year);
	}
	return year;
}

double getBalance()
{
	// this function should return a random balance, for example between -5000 and +5000
	double balance = ((rand() % 10000) + 1);
	if (balance > 5000 && balance < 10000) balance = (balance - 5000) * -1;
	return balance;
}

void printCustomers(struct customer customers[], int nCustomers)
{
	int i;
	// simply print out the array of customers, as neatly formatted as possible

	for (i = 0; i < nCustomers; i++) {
		printf("%25s\t%14d\t%12.2lf\t%d/%d/%d\n\n", customers[i].name, customers[i].accountNumber, customers[i].balance, customers[i].lastTrans.day, customers[i].lastTrans.month, customers[i].lastTrans.year);
	}
	return;
}

void populateCustomers(struct customer customers[], int nCustomers)
{
	int i;
	char names[10][50] = { "Haiden Soto","Oscar Hernandez","Heath Hickman","Reagan Mcknight","Noah Bartlett","Ross Day","Maribel Livingston","Jewel Phillips","Blake Gardner","Fernanda Ponce" };

	for (i = 0; i < nCustomers; i++)
	{
		strcpy_s(customers[i].name, names[i]);
		customers[i].accountNumber = 10000 + i;
		customers[i].lastTrans.month = getMonth();
		customers[i].lastTrans.day = getDay(customers[i].lastTrans.month);
		customers[i].lastTrans.year = getYear();

		// use the functions above to get values for the rest of the data structure
		customers[i].balance = getBalance();
		//customers[i].lastTrans = getDay(getMonth()) "/" getMonth() "/" getYear();
	}

	return;

}

int transaction(struct customer customers[], int accountNumber, double amount, int nCustomers)
{
	int i;

	// find the customer structure based on the account number, process the transaction (change the balance)
	// and return 1
	// if customer account number not found, return 0

	for (i = 0; i < nCustomers; i++)
	{
		if (customers[i].accountNumber == accountNumber) {
			customers[i].balance += amount;
			return 1;
		}
	}
	return 0;
}
