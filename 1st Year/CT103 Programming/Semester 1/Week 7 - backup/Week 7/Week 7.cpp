#include <stdio.h>
#include "pch.h"
#include "string.h"
#include "ctype.h"

void printLongestWord();

int findWord(char word[]);

int findWordWithMostVowels();

int isVowel(char c);

// generated using http://listofrandomnames.com/

char words[][20] = { "deicide", "geldesprung", "internuncio", "carver", "mulligrubs", "unsaveable", "oca"," balloting", "overmerciful", "unfrozen" };
int nwords = 10;



void main()
{
	char word[20];
	int i = 0;
	//printf("Word with aaaaaaaaaaaaaaaaaaaa");
	printLongestWord();

	i = findWordWithMostVowels();
	printf("Word with most vowels is: %s \n", words[i]);

	puts("enter word");
	gets_s(word);

	if (findWord(word))
	{
		printf("%s is in our list of words\n", word);
	}
	else
	{
		printf("%s is not in our list of words\n", word);
	}
}

void printLongestWord()
{
	int i = 0;
	int len = 0;
	int longestWord = 0;
	int printLongestWord = 0;
	if (i == 0) {
		longestWord = strlen(words[i]);
		printLongestWord = i;
	}
	//i++;
	while (i < 10) {
		len = strlen(words[i]);
		if (len > longestWord) {
			longestWord = strlen(words[i]);
			printLongestWord = i;
			i++;
		}
	}
	printf("%s", words[printLongestWord]);
}


int findWord(char word[])
{
	int i = 0;
	while (i < 20) {
		if (strcmp(word, words[i])) {
			return i;
		}
		else {
			i++;
		}
	}
}

int findWordWithMostVowels()
{
	int wordWithMostVowels;
	int i = 0; int j = 0; int counter = 0;
	while (i < 20) {
		if (i == 0) i = wordWithMostVowels;
		if (words[i][j] != '\0') {
			if (isVowel(words[i][j])) counter++;
		}
		if (wordWithMostVowels < counter) wordWithMostVowels = i;
	}
	return wordWithMostVowels;
}

int isVowel(char c)
{
	char word[20];
	c = toupper(c);
	if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
		return 1;
	}
	else {
		return 0;
	}
}

