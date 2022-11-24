#include "comparator.h"
#include <string.h>

// Comparator for int values
int comparator_int(void *i1, void *i2)
{
  int *val1 = (int *)i1;
  int *val2 = (int *)i2;

  if (*val1 < *val2)
    return -1;
  else if (*val1 > *val2)
    return 1;
  else
    return 0;
}

// Comparator for char values
int comparator_char(void *c1, void *c2)
{
  char *val1 = (char *)c1;
  char *val2 = (char *)c2;
  return strncmp(val1, val2, 1);
}

// Comparator for float values
int comparator_float(void *f1, void *f2)
{
  float *val1 = (float *)f1;
  float *val2 = (float *)f2;

  if (*val1 < *val2)
    return -1;
  else if (*val1 > *val2)
    return 1;
  else
    return 0;
}