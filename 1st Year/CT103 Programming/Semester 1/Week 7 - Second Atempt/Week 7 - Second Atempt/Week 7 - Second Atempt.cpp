#include "pch.h"
#include <iostream>
#include <stdio.h>
#include "string.h"
#include "ctype.h"

void printLongestWord();

int findWord(char word[]);

int findWordWithMostVowels();

int isVowel(char c);

// generated using http://listofrandomnames.com/

char words[][20] = { "metalepsis","cellulating","caustical","inosculating","lerner","outchide","disproportionate","malang","ammonification","energise" };
int nwords = 10;



void main()
{
	char word[20];
	int i = 0;

	printLongestWord();
/*
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
	*/
}

void printLongestWord()
{
	// your code here


}

int findWord(char word[])
{
	// your code here
}


int findWordWithMostVowels()
{
	// your code here
}

int isVowel(char c)
{
	c = toupper(c);
	// your code here
	}