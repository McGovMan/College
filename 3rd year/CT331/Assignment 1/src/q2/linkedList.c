#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "linkedList.h"

typedef struct listElementStruct{
  char* data;
  size_t size;
  struct listElementStruct* next;
} listElement;

//Creates a new linked list element with given content of size
//Returns a pointer to the element
listElement* createEl(char* data, size_t size){
  listElement* e = malloc(sizeof(listElement));
  if(e == NULL){
    //malloc has had an error
    return NULL; //return NULL to indicate an error.
  }
  char* dataPointer = malloc(sizeof(char)*size);
  if(dataPointer == NULL){
    //malloc has had an error
    free(e); //release the previously allocated memory
    return NULL; //return NULL to indicate an error.
  }
  strcpy(dataPointer, data);
  e->data = dataPointer;
  e->size = size;
  e->next = NULL;
  return e;
}

//Prints out each element in the list
void traverse(listElement* start){
  listElement* current = start;
  while(current != NULL){
    printf("%s\n", current->data);
    current = current->next;
  }
}

//Inserts a new element after the given el
//Returns the pointer to the new element
listElement* insertAfter(listElement* el, char* data, size_t size){
  listElement* newEl = createEl(data, size);
  listElement* next = el->next;
  newEl->next = next;
  el->next = newEl;
  return newEl;
}


//Delete the element after the given el
void deleteAfter(listElement* after){
  listElement* delete = after->next;
  listElement* newNext = delete->next;
  after->next = newNext;
  //need to free the memory because we used malloc
  free(delete->data);
  free(delete);
}

// Returns the number of elements in a linked list.
// Cannot call the function length as there must be a built-in function called that.
int lengthOfList(listElement* list) {
    /*
     * 1) Initialize count as 0
     * 2) Initialize a node pointer, current = head.
     * 3) Do following while current is not NULL
        a) current = current -> next
        b) count++;
     * 4) Return count
     */

    int count = 1;
    listElement* current = list;

    while (current->next != NULL) {
        current = current->next;
        count++;
    }

    return count;
}

// Push a new element onto the head of a list
// Update the list reference using side effects
void push(listElement** list, char* data, size_t size) {
    /*
     * 1. Make new node with createEl
     * 2. Make next of new node as head
     * 3. Move the list head to point to the new node
     */

    listElement* newHead = createEl(data, size);
    newHead->next = *list;
    *list = newHead;
}

// Pop an element from the head of a list
// Update the list reference using side effects
listElement* pop(listElement** list) {
    /*
     * 1. Set head->next to list head
     * 2. Return old head
     */

    listElement* tempHead = *list;
    *list = tempHead->next;
    tempHead->next = NULL;

    return (listElement*) tempHead;
}

// Enqueue a new element onto the head of the list
// Update the list reference using side effects
void enqueue(listElement** list, char* data, size_t size) {
    // I want to mention that I think enqueue should append to the tail of the list, not the beginning, so I will be commenting out the below to include my solution
    /*listElement* newElement = createEl(data, size);
    listElement* current = *list;

    while (current->next != NULL) {
        current = current->next;
    }

    // current is now last in list
    current->next = newElement;*/

    listElement* newElement = createEl(data, size);

    newElement->next = *list;
    *list = newElement;
}

// Dequeue an element from the tail of the list
listElement* dequeue(listElement* list) {
    listElement* current = list;

    if (current->next == NULL) {
        free(current);
        return NULL;
    }

    while (current->next->next != NULL) {
        //prev = current;
        current = current->next;
    }

    listElement* lastElement = current->next;
    current->next = NULL;

    return lastElement;
}

