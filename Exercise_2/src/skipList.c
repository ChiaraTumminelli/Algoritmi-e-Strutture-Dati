#include <stdio.h>
#include <stdlib.h>
#include "skipList.h"
#include "comparator.h"
#include <strings.h>

struct _SkipList
{
  Node *head;
  unsigned int max_level;
  int (*compare)(void *, void *);
};

struct _Node
{
  Node **next;
  unsigned int size;
  void *item;
};

// Creating and initializing skiplist
SkipList *create_skip_list(int (*compare)(void *, void *))
{
  Node *sentry = malloc(sizeof(Node));
  sentry->item = NULL;
  sentry->size = MAX_HEIGHT;
  sentry->next = calloc(MAX_HEIGHT, sizeof(Node *));

  SkipList *new = malloc(sizeof(SkipList));
  new->head = sentry;
  new->max_level = 0;
  new->compare = compare;
  return new;
}

// Creating and initializing node
Node *create_node(void *I, int size)
{
  Node *new = malloc(sizeof(Node));
  new->item = I;
  new->size = size;
  new->next = malloc(sizeof(Node *) * (size));
  for (int i = size - 1; i >= 0; i--)
  {
    new->next[i] = NULL;
  }
  return new;
}

// determining the number of pointers to include in the new node
int random_level()
{
  int lvl = 1;
  while (rand()%2 < 0.5 && lvl < MAX_HEIGHT)
  {
    lvl = lvl + 1;
  }
  return lvl;
}

// Inserti I in skiplist list
void insert_skip_list(SkipList *list, void *I)
{
  Node *new = create_node(I, random_level());
  if (new->size > list->max_level)
    list->max_level = new->size;
  Node *x = list->head;
  for (int k = list->max_level - 1; k >= 0; k--)
  {
    if (x->next[k] == NULL || list->compare(I, x->next[k]->item) == -1)
    {
      if (k < new->size)
      {
        new->next[k] = x->next[k];
        x->next[k] = new;
      }
    }
    else
    {
      x = x->next[k];
      k++;
    }
  }
}

// return item of list at specified index 
void *get_value_at_index(SkipList *list, int index)
{
  int i = 0;
  if (index < 0)
  {
    printf("ERROR: invalid negative value.\n");
    exit(EXIT_FAILURE);
  }
  Node *tmp = list->head->next[0];
  for (i = index; i > 0 && tmp->next[0] != NULL; i--)
  {
    tmp = tmp->next[0];
  }
  if (i == 0)
    return tmp->item;
  else
    return NULL;
}

// Check if I is present in the skiplist list
void *search_skip_list(SkipList *list, void *I)
{
  Node *x = list->head;
  for (int k = list->max_level - 1; k >= 0; k--)
  {
    while (list->compare(x->next[k]->item, I) == -1)
    {
      x = x->next[k];
    }
  }
  x = x->next[0];
  if (list->compare(x->item, I) == 0)
    return x->item;
  else
    return NULL;
}

// deallocates dynamic memory
void delete_skip_list(SkipList *list)
{
  Node *m = list->head;
  Node *tmp;
  while (m != NULL)
  {
    tmp = m;
    m = m->next[0];
    free(tmp);
  }
  free(list);
}