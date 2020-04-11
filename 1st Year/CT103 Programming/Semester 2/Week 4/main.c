#include <stdio.h>
#include "string.h"
#include "stdlib.h"
#include "ctype.h"

typedef struct
{
    int age;
    int year;
    int gold;
    int silver;
    int bronze;
    int total;
} result;

typedef struct
{
    char name[30];
    char sport[20];
    char country[20];
    int nresults;
    result *results;
} athlete;

FILE *openFile(char *fileName, char *mode);
void closeFile(FILE *fptr);

// function to print out an athlete
void printAthlete(athlete athlete1);

// function to find if an athlete (assume combination of name / country / sport are unique) is already in the
// array of athlete structures. If it is, it returns the index of the athlete. If not it returns -1
long findAthlete (char *name, char *sport, char*country);

// add a new result (equivalent to a line in the data file) to an existing athlete record
// where 'i' is the index of the existing athlete in the array of athlete data structures
void addResult (long i, int age, int year, int gold, int silver, int bronze, int total);

// initialise all athletes in array of athlete data structures
void initialiseAthletes();

// find the athlete who has won the most medals in a sport and print it out using printAthlete
int findMostMedals(char *findSport);

// array of data structures to be allocated dynamically. Allocate as many as there are lines in file
athlete *athletes;

// total number of unique athletes found
long numAthletes = 0;

// used to keep track of current index of athlete as we are adding them
long currentIndex = 0;

void main()
{
    char nextLine[201];
    char *token;
    char tab[2] = "\t";
    FILE *fptr;
    char fileName[] = "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 4/athletes.txt";
    char name[50];
    char sport[40];
    char country[40];
    int age;
    int year;
    int gold, silver, bronze, total;
    long i = -1, j = 0;

    char findSport[20];

    fptr = openFile(fileName,"r");

    if ( fptr  == NULL )
    {
        printf( "File could not be opened !!\n" );
    }
    else
    {
        // find out how many athletes max there are (max is # lines in file)
        while (!feof(fptr))
        {
            fgets (nextLine,200, fptr);
            numAthletes++; // the number of records to allocate
        }

        // allocate an array of athlete structures
        athletes = (athlete *)malloc(numAthletes*(sizeof(athlete)));

        // make sure data is nice and tidy
        initialiseAthletes();

        // go back to start of file
        rewind(fptr);

        while ( !feof( fptr ) )
        {
            // read line (might be new athlete or existing one)
            fgets (nextLine,200, fptr);

            token = strtok (nextLine, tab);
            strcpy(name, token);

            token = strtok (NULL, tab);
            age = atoi(token);

            token = strtok (NULL, tab);
            strcpy(country, token);

            token = strtok (NULL, tab);
            year = atoi(token);

            token = strtok (NULL, tab);
            strcpy(sport, token);

            token = strtok (NULL, tab);
            gold = atoi(token);

            token = strtok (NULL, tab);
            silver = atoi(token);

            token = strtok (NULL, tab);
            bronze = atoi(token);

            token = strtok (NULL, tab);
            total = atoi(token);

            // check if we already have this one
            i = findAthlete (name, sport, country);

            if (i >= 0)
            {
                // is is index of existing athlete, to which we need to add new record
                addResult (i,age, year, gold, silver, bronze, total);
            }
            else
            {
                // otherwise use a new athlete structure
                strcpy(athletes[currentIndex].name, name);
                strcpy(athletes[currentIndex].country, country);
                strcpy(athletes[currentIndex].sport, sport);
                athletes[currentIndex].nresults = 0;
                // add result to athlete
                addResult(currentIndex, age, year, gold, silver, bronze, total);
                // increment number of athletes
                currentIndex++;
            }

        }

        closeFile( fptr );
    }

    while (1)
    {
        printf ("Enter Sport you want to find most medals for (x to exit): ");
        scanf (" %s", findSport);
        if (toupper(findSport[0]) == 'X') return;
        if (!findMostMedals(findSport))
        {
            printf ("No results found for %s \n\n", findSport);
        }
    }
}


FILE * openFile(char *fileName, char *mode)
{

    FILE *fptr = fopen(fileName, mode);

    if (fptr == NULL)
    {
        printf("Error opening file ! \n");
    }
    return fptr;
}

void closeFile(FILE *fptr)
{
    fclose(fptr);
}

void initialiseAthletes()
{
    int n;
    for (n=0;n<numAthletes; n++)
    {
        (athletes + n)->country[0] = '\0';
        (athletes + n)->name[0] = '\0';
        (athletes + n)->sport[0] = '\0';
        (athletes + n)->nresults = 0;
        (athletes + n)->results = NULL;
    }
}

void addResult(long i, int age, int year, int gold, int silver, int bronze, int total)
{
    int nr = 1;
    athletes[i].nresults++;
    nr = athletes[i].nresults;

    // if no results have been created for this athlete yet
    if (athletes[i].results == NULL)
    {
        // ADD CODE HERE
        // use malloc to create the first result structure
        athletes[i].results = (result*)malloc(sizeof(result));
    }
    else
    {
        // use realloc to add a result to results
        // ADD CODE HERE
        athletes[i].results = (result*)realloc(athletes[i].results, nr * sizeof(result));

    }

    // set the variables (age, year, etc.) in the result structure
    // ADD CODE HERE

    athletes[i].results[nr -1].age = age;
    athletes[i].results[nr -1].year = year;
    athletes[i].results[nr -1].gold = gold;
    athletes[i].results[nr -1].silver = silver;
    athletes[i].results[nr -1].bronze = bronze;
    athletes[i].results[nr -1].total = total;
}

void printAthlete(athlete athlete1)
{
    int i;
    printf ("%s, %s from %s\n", athlete1.name, athlete1.sport, athlete1.country);
    printf("\nAge\tYear\tGold\tSilver\tBronze\tTotal\n");
    printf("------------------------------------------------------------\n");

    for (i=0;i<athlete1.nresults;i++)
    {
        // ADD CODE HERE
        // to print out the athlete's results
        printf("%d\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n\n", athlete1.results[i].age, athlete1.results[i].year, athlete1.results[i].gold, athlete1.results[i].silver, athlete1.results[i].bronze, athlete1.results[i].total);
    }
}

long findAthlete (char *name, char *sport, char *country)
{
    long i;
    for(i=0;i<numAthletes;i++)
    {
        // ADD CODE HERE
        // return index of the athlete if found
        if (strcmp(athletes[i].name, name) == 0 && strcmp(athletes[i].sport, sport) == 0 && strcmp(athletes[i].country, country) == 0) return i;
    }

    // otherwise return -1
    return -1;
}

// find athlete with the most medals in a sport (if 2 or more have same total, then just find one)
int findMostMedals(char *findSport)
{
    long i,j, most = 0;
    int highestTotal = 0;
    int athleteTotal;
    int sportFound = 0;

    for(i=0;i<numAthletes;i++)
    {
        // ADD CODE HERE
        // to find athlete with highest total in the sportFound
        // you will need to total all of each athlete's results

        athleteTotal = 0;
        //printf("Sport: %s", findSport);
        if (strcmp(athletes[i].sport, findSport) == 0) {

            for (j = 0; j < athletes[i].nresults; j++) {
                athleteTotal += athletes[i].results[j].total;
            }

            if (athleteTotal > highestTotal) {
                highestTotal = athleteTotal;
                most = i;
            }
        }
    }
    if (most != 0) sportFound = 1;

    // [most] is the index of the athlete with the highest total
    if (sportFound == 1)
    {
        printAthlete(athletes[most]);
        return 1;
    }
    return 0;
}