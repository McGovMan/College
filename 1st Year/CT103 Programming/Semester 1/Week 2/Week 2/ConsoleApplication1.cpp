#include "pch.h"
#include "stdio.h"

int main()
{

	int english_mark = 0;
	int french_mark = 0;
	int maths_mark = 0;
	int irish_mark = 0;
	int science_mark = 0;

	float average = 0.00;



	printf("Enter English Mark: ");
	scanf_s("%d", &english_mark);

	printf("Enter French Mark: ");
	scanf_s("%d", &french_mark);

	printf("Enter Maths Mark: ");
	scanf_s("%d", &maths_mark);

	printf("Enter Irish Mark: ");
	scanf_s("%d", &irish_mark);

	printf("Enter Science Mark: ");
	scanf_s("%d", &science_mark);

	average = (english_mark + french_mark + maths_mark + irish_mark + science_mark) / 5;

	printf("Average Mark = %.2f \n", average);
	printf("Fails: ");

	if (english_mark < 40) {
		printf("English");
	}
	if (french_mark < 40) {
		printf("French");

	}
	if (maths_mark < 40) {
		printf("Maths");

	}
	if (irish_mark < 40) {
		printf("Irish");
	}
	if (science_mark < 40) {
		printf("Science");
	}


	printf("Passed: ");
	if (english_mark >= 40) {
		printf("English");
	}
	if (french_mark >= 40) {
		printf("French");

	}
	if (maths_mark >= 40) {
		printf("Maths");

	}
	if (irish_mark >= 40) {
		printf("Irish");
	}
	if (science_mark >= 40) {
		printf("Science");
	}
}