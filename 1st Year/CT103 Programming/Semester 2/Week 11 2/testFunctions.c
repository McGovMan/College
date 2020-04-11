#include "testFunctions.h"
#include "solutionToTest.h"
#include "test.h"
#include <stdbool.h>
#include <stdio.h>
#include <stdarg.h>
#include "string.h"

int functions() {
    testGetLines();
    //getSize();
    //testGetChars();
}

long testGetLines() {
    long expectedResult1 = 6;
    long expectedResult2 = 100;

    long actualResult1 = getLines("contact.txt");
    long actualResult2 = getLines("users.txt");

    TEST(actualResult1 == expectedResult1);
    TEST(actualResult2 == expectedResult2);
}

/*long getSize() {

}

long testGetChars() {

}*/