#include <stdio.h>
#include "linkedList.h"

void runTests() {
    printf("Tests running...\n");

    printf("Creating new element\n");
    listElement* l = createEl("Testing string", 15);
    traverse(l);
    printf("\n");

    //Test insert after
    printf("Testing insert after\n");
    listElement* l2 = insertAfter(l, "another string (2)", 30);
    insertAfter(l2, "a final string (3)", 30);
    traverse(l);
    printf("\n");

    // Test delete after
    printf("Testing delete after\n");
    deleteAfter(l);
    traverse(l);
    printf("\n");

    // Test length
    printf("Testing length of linked list\n");
    int length = lengthOfList(l);
    printf("The length of this list is %d\n", length);
    printf("\n");

    // Test push
    printf("Pushing to top of linked list\n");
    push(&l, "a final final string (4)", 30);
    traverse(l);
    printf("\n");

    // Test pop
    printf("Popping from the stack and showing that item has been popped\n");
    pop(&l);
    traverse(l);
    printf("\n");

    // Test enqueue
    printf("Testing enqueue and showing results\n");
    enqueue(&l, "a final final final string (5)", 30);
    traverse(l);
    printf("\n");

    // Test dequeue
    printf("Testing dequeue and showing results\n");
    listElement* element = dequeue(l);
    traverse(l);

    printf("\nTests complete.\n");
}
