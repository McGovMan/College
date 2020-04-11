#include <stdio.h>
#include "string.h"
#include "stdlib.h"

int getOption();
int checkSpelling();
int findWord();
void readFile(char *fileName);

char dictionary[80000][20];

int main()
{
    char fileName[] = "/home/conor/Documents/Git/Programming-Labs/Semester 2/Week 3/dict.txt";

    if (fileName == NULL)
    {
        printf("Error opening file ! \n");
        return 0;
    } else {
        printf("Working here");
        readFile(fileName);
        return 0;
    }
}

void readFile(char *fileName) {
    FILE *fptr = fopen(fileName, "r");
    int i = 0;

    while (!feof(fptr))
    {
        //fgets(dictionary[i], 200, fptr);
        fscanf(fptr, "%s", dictionary[i]);
        //printf("Word: %s \n", dictionary[i]);
        i++;
    }

    fclose(fptr);
    getOption();
}

int getOption() {
    int option;
    printf(" This is Conor McGovern's Dictionary! \n");
    printf(" Options: \t Check spelling (1) \t or \t Find words (2) \t or \t or quit (0)");
    printf("\n Enter an option: ");
    scanf("%d", &option);
    printf("\n");

    if (option == 0) exit;

    if (option == 1) {
        if(checkSpelling()) {
            printf(" Your spelling is correct \n");
        } else {
            printf(" Your spelling is incorrect \n");
        }
    }

    if (option == 2) {
        findWord();
    }
}

int checkSpelling() {
    char word[10] = "";
    char dictWord[10] = "";
    int i;

    printf("\n Enter a word and we'll see if you spelled it right: ");
    scanf("%s", &word);

    strcpy(&word[strlen(word)], "\n");

    for (i = 0; i < 79340; i++) {
        strcpy(dictWord, dictionary[i]);
        if (strcmp(dictionary[i], word) == 0) {
            return 1;
        } else if (i == 79339 && (strcmp(dictionary[i], word) != 0)) {
            return 0;
        }
    }
}

int findWord() {
    char letters[10] = "";
    char tempLetters[10] = "";
    char curUsrLetter = "";
    char curDictLetter = "";
    char curStr[16] = "";

    int count[85000], dictWordCount, dictLetterCount, usrLetterCount, mostSuitedCount = 0, mostSuitedPos = 0;

    printf("Enter the letters in the word you know: ");
    scanf("%s", letters);

    for (dictWordCount = 0; dictWordCount < 79340; dictWordCount++) {
        strcpy(tempLetters, letters);
        strcpy(curStr, dictionary[dictWordCount]);
        //printf("\n %s", curStr[dictLetterCount]);
        for (dictLetterCount = 0; dictLetterCount < 15; dictLetterCount++) {
            if (strcmp(&curStr[dictLetterCount], "\0") != 0) {
                //printf(" %c", dcurStr[dictLetterCount][dictLetterCount]);
                for (usrLetterCount = 0; usrLetterCount < 10; usrLetterCount++) {
                    curUsrLetter = tempLetters[usrLetterCount];
                    curDictLetter = curStr[dictLetterCount];

                    if (strcmp(&tempLetters[usrLetterCount], "\0") != 0) {
                        if (tempLetters[usrLetterCount] == curStr[dictLetterCount]) {
                            count[dictWordCount]++;
                            curStr[dictLetterCount] = 2;
                            tempLetters[usrLetterCount] = 3;
                        }
                    }
                }
            }
        }
        if(count[dictWordCount] > mostSuitedCount || strcmp(letters, dictionary[dictWordCount]) == 0) {
            mostSuitedPos = dictWordCount;
            mostSuitedCount = count[dictWordCount];
        }
    }
    printf(" Most suited Word is: %s \n Line: %d in the dictionary \n Has a matching score of: %d", dictionary[mostSuitedPos], mostSuitedPos + 1, mostSuitedCount);
}

