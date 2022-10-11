#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
  
// function for comparing two strings. This function
// is passed as a parameter to _quickSort() when we
// want to sort 
int cmpstr(void* v1, void* v2)
{
    // casting v1 to char** and then assigning it to
    // pointer to v1 as v1 is array of characters i.e
    // strings.
    char *a1 = *(char**)v1;
    char *a2 = *(char**)v2;
    return strcmp(a1, a2);
}
  
// function for comparing two strings
int cmpnum(void* s1, void* s2)
{
    // casting s1 to int* so it can be
    // copied in variable a.
    int *a = (int*)s1;
    int *b = (int*)s2;
    if ((*a) > (*b))
        return 1;
    else if ((*a) < (*b))
        return -1;
    else
        return 0;
}
  
/* you can also write compare function for floats,
    chars, double similarly as integer. */
// function for swap two elements
void swap(void* v1, void* v2, int size)
{
    // buffer is array of characters which will 
    // store element byte by byte
    char buffer[size];
  
    // memcpy will copy the contents from starting
    // address of v1 to length of size in buffer 
    // byte by byte.
    memcpy(buffer, v1, size);
    memcpy(v1, v2, size);
    memcpy(v2, buffer, size);
}
  
// v is an array of elements to sort.
// size is the number of elements in array
// left and right is start and end of array
//(*comp)(void*, void*) is a pointer to a function
// which accepts two void* as its parameter
void _qsort(void* v, int size, int left, int right,
                      int (*comp)(void*, void*))
{
    void *vt, *v3;
    int i, last, mid = (left + right) / 2;
    if (left >= right)
        return;
  
    // casting void* to char* so that operations 
    // can be done.
    void* vl = (char*)(v + (left * size));
    void* vr = (char*)(v + (mid * size));
    swap(vl, vr, size);
    last = left;
    for (i = left + 1; i <= right; i++) {
  
        // vl and vt will have the starting address 
        // of the elements which will be passed to 
        // comp function.
        vt = (char*)(v + (i * size));
        if ((*comp)(vl, vt) > 0) {
            ++last;
            v3 = (char*)(v + (last * size));
            swap(vt, v3, size);
        }
    }
    v3 = (char*)(v + (last * size));
    swap(vl, v3, size);
    _qsort(v, size, left, last - 1, comp);
    _qsort(v, size, last + 1, right, comp);
}

// A binary search based function to find the position
// where item should be inserted in a[low..high]
int binarySearch(int a[], int item, int low, int high)
{
    if (high <= low)
        return (item > a[low])?  (low + 1): low;
 
    int mid = (low + high)/2;
 
    if(item == a[mid])
        return mid+1;
 
    if(item > a[mid])
        return binarySearch(a, item, mid+1, high);
    return binarySearch(a, item, low, mid-1);
}
 
// Function to sort an array a[] of size \'n\'
void insertionSort(int a[], int n)
{
    int i, loc, j, selected;
 
    for (i = 1; i < n; ++i)
    {
        j = i - 1;
        selected = a[i];
 
        // find location where selected should be inserted
        loc = binarySearch(a, selected, 0, j);
 
        // Move all elements after location to create space
        while (j >= loc)
        {
            a[j+1] = a[j];
            j--;
        }
        a[j+1] = selected;
    }
}
  
int main()
{

    char* a[] = {"bbc", "xcd", "ede", "def", "afg", "hello", "hmmm", "okay", "how" };
  
    int b[] = { 45, 78, 89, 65, 70, 23, 44 };
    int* p = b;

    clock_t t_a;
    t_a = clock();
    _qsort(a, sizeof(char*), 0, 8, (int (*)(void*, void*))(cmpstr));
    t_a = clock();
    double time_taken_a = ((double)t_a)/CLOCKS_PER_SEC;

    printf("ATTENDED:\tafg bbc def ede hello hmmm how okay xcd");
    printf("\nOUTPUT IS:\t");
        for (int i = 0; i < 9; i++)
            printf("%s ", a[i]);
    printf("\n");
    printf("RUN TIME:\t%f", time_taken_a);

    clock_t t_p;
    t_p = clock();
    _qsort(p, sizeof(int), 0, 6, (int (*)(void*, void*))(cmpnum));
    t_p = clock();
    double time_taken_p = ((double)t_p)/CLOCKS_PER_SEC;

    printf("\n\nATTENDED:\t23 44 45 65 70 78 89");
    printf("\nOUTPUT IS:\t");
        for (int i = 0; i < 7; i++)
            printf("%d ", b[i]);
    printf("\n");
    printf("RUN TIME:\t%f", time_taken_p);    


    int m[] = {37, 23, 0, 17, 12, 72, 31,46, 100, 88, 54};
    int n = sizeof(m)/sizeof(m[0]), i;

    clock_t t_m;
    t_m = clock();
    insertionSort(m, n);
    t_m = clock();
    double time_taken_m = ((double)t_m)/CLOCKS_PER_SEC;

    printf("\n\nATTENDED:\t0 12 17 23 31 37 46 54 72 88 100");
    printf("\nOUTPUT IS:\t");
    for (i = 0; i < n; i++)
        printf("%d ",m[i]);
    printf("\n");
    printf("RUN TIME:\t%f\n", time_taken_m);
 

 
  
    return 0;
}
