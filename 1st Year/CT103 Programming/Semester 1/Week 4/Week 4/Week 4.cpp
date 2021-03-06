#include "stdio.h"
#include "pch.h"
#include <iostream>

int main()
{
	
	int running = 1;
	while (running == 1) {
		int i = 1;
		int choiceSelector = 0;
		while (i == 1) {
			printf("\n Area Calulator \n");
			printf("What area do you want to calculate? \n");
			printf(" 1 <Triangle> \n 2 <Square> \n 3 <Rectangle> \n 4 <Parallelogram> \n 5 <Trapezoid> \n 6 <Circle> \n 7 <Ellipse> \n 8 <Sector> \n 9 <Semicircle> \n 10 <Diamond> \n");
			printf("Enter your choice here: ");
			scanf_s("%d", &choiceSelector);

			if (choiceSelector <= 10 && choiceSelector >= 1) {
				/* printf("You choose %d", choiceSelector); */
				i = 0;
			}
			else {
				printf("You choose and invalid option, please try again.");
			}
		}
		float verticalHeight;
		float baseLength;
		float radius;
		float area;
		float topLength;
		float pie = 3.1415;
		float degrees;
		float radians;
		float circumference;

		switch (choiceSelector) {
		case 1:
			/* Triangle */
			/* printf("you chose number 1"); */
			printf("Enter width: ");
			scanf_s("%f", &baseLength);
			printf("Enter vertical height: ");
			scanf_s("%f", &verticalHeight);
			area = 0.5 * baseLength * verticalHeight;
			printf("Area = %.2f", area);
			break;

		case 2:
			/* Square */
			/* printf("you chose number 2"); */
			printf("Enter width: ");
			scanf_s("%f", &baseLength);
			area = baseLength * baseLength;
			printf("Area = %.2f", area);
			break;

		case 3:
			/* Rectangle */
			/* printf("you chose number 3"); */
			printf("Enter width: ");
			scanf_s("%f", &baseLength);
			printf("Enter vertical height: ");
			scanf_s("%f", &verticalHeight);
			area = baseLength * verticalHeight;
			printf("Area = %.2f", area);
			break;

		case 4:
			/* Parallelogram */
			/* printf("you chose number 4"); */
			printf("Enter width: ");
			scanf_s("%f", &baseLength);
			printf("Enter vertical height: ");
			scanf_s("%f", &verticalHeight);
			area = baseLength * verticalHeight;
			printf("Area = %.2f", area);
			break;

		case 5:
			/* Trapezoid */
			/* printf("you chose number 5"); */
			printf("Enter top length: ");
			scanf_s("%f", &topLength);
			printf("Enter base length: ");
			scanf_s("%f", &baseLength);
			printf("Enter vertical height: ");
			scanf_s("%f", &verticalHeight);
			area = 0.5 * (topLength + baseLength) * verticalHeight;
			printf("Area = %.2f", area);
			break;

		case 6:
			/* Circle */
			/* printf("you chose number 6"); */
			printf("Enter radius: ");
			scanf_s("%f", &radius);
			area = pie * radius * radius;
			circumference = 2 * pie * radius;
			printf("Area = %.2f", area);
			printf("Circumference = %.2f", circumference);
			break;

		case 7:
			/* Ellipse */
			/* printf("you chose number 7"); */
			printf("Enter major axis length: ");
			scanf_s("%f", &baseLength);
			printf("Enter minor axis length: ");
			scanf_s("%f", &verticalHeight);
			area = pie * verticalHeight * baseLength;
			printf("Area = %.2f", area);
			break;

		case 8:
			/* Sector */
			/* printf("you chose number 8"); */
			printf("Enter angle in degrees: ");
			scanf_s("%f", &degrees);
			printf("Enter radius: ");
			scanf_s("%.2f", &radius);

			if (degrees <= 360 && degrees > 0) {
				radians = degrees * (pie / 180);
				area = 0.5 * radius * radius * radians;
				printf("Area = %f", area);
			}
			else {
				printf("Enter an angle between 0 and 360, please try again.");
			}
			break;

		case 9:
			/* Semicircle */
			/* printf("you chose number 6"); */
			printf("Enter radius: ");
			scanf_s("%f", &radius);
			area = (pie * radius * radius) / 2;
			printf("Area = %.2f", area);
			break;

		case 10:
			/* Diamond */
			/* printf("you chose number 10"); */
			printf("Enter width: ");
			scanf_s("%f", &baseLength);
			printf("Enter vertical height: ");
			scanf_s("%f", &verticalHeight);
			area = baseLength * verticalHeight;
			printf("Area = %.2f", area);
			break;

		default:
			printf("Error, please try again.");
		}

		int check;
		printf("\nDo you want to do another calculation? 1/0 (1 for yes, 0 for no) ");
		scanf_s("%d", &check);

		if (check == 1) {
			running = 1;
		}
		else {
			running = 0;
		}
	}
}
