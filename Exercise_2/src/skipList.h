#ifndef SKIPLIST_H
#define SKIPLIST_H

#define MAX_HEIGHT 12

typedef struct _SkipList SkipList;
typedef struct _Node Node;

// Creating and initializing skiplist
SkipList *create_skip_list(int (*compare)(void *, void *));

// Creating and initializing node
Node *create_node(void *I, int size);

// determining the number of pointers to include in the new node
int random_level();

// Inserti I in skiplist list
void insert_skip_list(SkipList *list, void *I);

// return item of list at specified index 
void *get_value_at_index(SkipList *list, int index);

// Check if I is present in the skiplist list
void *search_skip_list(SkipList *list, void *I);

// deallocates dynamic memory
void delete_skip_list(SkipList *list);

#endif
