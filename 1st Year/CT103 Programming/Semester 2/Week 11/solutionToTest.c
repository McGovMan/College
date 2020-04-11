#include "stdafx.h"
#include <stdio.h>
#include <stdarg.h>
#include "string.h"

long getLines(char *fileName);
long getSize(char *fileName);
long getChars(char *fileName);


int main( int argc, char *argv[] )
{
    FILE *inFile;
    char *inPath;
    long nlines = 0, nsize = 0, nchars = 0;
    bool lines = false, size = false, chars = false;
    int i;


    inPath = argv[1];

    inFile = fopen(inPath, "r");

    if (inFile == NULL)
    {
        puts("Error opening file - exiting !\n");
        return 1;
    }

    if (inFile != NULL) fclose(inFile);

    for (i=0;i<argc; i++)
    {
        if (!strcmp("/l", argv[i]))
        {
            lines = true;
            nlines = getLines(inPath);
            continue;
        }

        if (!strcmp("/s", argv[i]))
        {
            size = true;
            nsize = getSize(inPath);
            continue;
        }

        if (!strcmp("/c", argv[i]))
        {
            chars = true;
            nchars = getChars(inPath);
            continue;
        }
    }


    if (lines) printf ("#lines = %ld\n", nlines);
    if (size) printf ("size = %ld bytes\n", nsize);
    if (chars) printf ("#chars = %ld\n", nchars);

    return 0;

}

long getLines(char *fileName)
{
    long nLines = 0;
    char temp[200];
    FILE *fptr;

    fptr = fopen(fileName, "r");

    if (fptr == NULL)
    {
        printf ("Error in readResults opening data file: %s \n", fileName);
        return 0;
    }

    fgets(temp,200, fptr);
    nLines++;

    while (!feof(fptr))
    {
        nLines++;
        fgets(temp,200, fptr);
    }

    fclose(fptr);

    return nLines;
}


long getSize(char *fileName)
{
    long size;
    FILE *fptr;

    fptr = fopen(fileName, "r");

    if (fptr == NULL)
    {
        printf ("Error in readResults opening data file: %s \n", fileName);
        return 0;
    }

    fseek(fptr, 0, SEEK_END);

    size = ftell(fptr);

    fclose(fptr);

    return size;
}


long getChars(char *fileName)
{
    long chars = 0;
    char temp[200];
    FILE *fptr;

    fptr = fopen(fileName, "r");

    if (fptr == NULL)
    {
        printf ("Error in readResults opening data file: %s \n", fileName);
        return 0;
    }

    fgets(temp,200, fptr);
    chars = strlen(temp);

    while (!feof(fptr))
    {
        fgets(temp,200, fptr);
        chars = chars + strlen(temp);
    }

    fclose(fptr);

    return chars;
}