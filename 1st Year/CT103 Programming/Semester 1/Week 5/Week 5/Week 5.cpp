#include "stdio.h"
#include "pch.h"
#include <iostream>

int main() {
		int i;
		double number[10], max = 0, min = 0, average = 0, total = 0;
		printf("\n This is a program to calculate average, min and max of up to 10 floating point numbers.\n Enter up to 10 numbers <0.0 to end the input>\n _________________________\n\n");

		for (i = 0; i < 10; i++) {
			printf(" #%d: \t", i + 1); /* printing e.g. #1: */
			scanf_s("%lf", &number[i]);
			total = total + number[i]; /* updating total */

			/* Start of If Statements */
			if (number[i] == 0 && i == 0) { /* if user input 0 at first, quits without calculating. */
				printf("\n No numbers entered, Exiting.. \n");
				break;
			}
			if (number[i] == 0) { /* quits with calculating */
				break;
			}
			if (i == 0) { /* setting min and max */
				min = number[i];
				max = number[i];
			}
			if (number[i] > max) { /* checking max */
				max = number[i];
			}
			if (number[i] < min) { /* checking min */
				min = number[i];
			}
			/* End of If Statements*/
		}
		if (i > 0) { /* checking if it is okay to calculate, if i is = 0, it doesnt run */
			average = total / i;
			printf(" Average = %.2lf, Max = %.2lf, Min = %.2lf\n", average, max, min);
		}
	}
