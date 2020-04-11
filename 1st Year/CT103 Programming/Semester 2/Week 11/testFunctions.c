#include "testFunctions.h"

int runTestFunctions() {
    testGetLines();
    //getSize();
    //testGetChars();
}

long testGetLines() {
    int expectedResult1 = 6;
    int expectedResult2 = 100;
    int actualResult1;
    int actualResult2;

    double actualResult = getLines("contact.txt");
    double actualResult = getLines("users.txt");

    TEST(actualResult1 == expectedResult1);
    TEST(actualResult2 == expectedResult2);
}

/*long getSize() {

}

long testGetChars() {

}*/