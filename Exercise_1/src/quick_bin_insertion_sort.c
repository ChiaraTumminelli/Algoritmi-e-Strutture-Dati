#include <stdio.h>
#include <stdlib.h>
#include "../src/quick_bin_insertion_sort.h"

#define BLINK "\x1B[5m"
#define RESET "\x1B[0m"

// Ask which algorithm to run
void quick_bin_insertion_sort(void **A, int low, int high, int (*comparator)(void *, void *), int (*partition)(void **, int, int, int (*)(void *, void *)))
{
    int choice = 0;
    printf("\nWhich algorithm do you want to use?\n\n\tPress 1 for quickSort.\n\tPress 2 for binary insertion sort.\n\n\tYour choice: ");
    scanf("%d", &choice);

    switch (choice)
    {
    case 1:
        choosePivot(A, low, high, comparator, partition);
        break;

    case 2:
        printf(BLINK "\nSorting . . .\n" RESET);
        insertionSort(A, low, high, comparator);
        break;

    default:
        printf("No valid choice selected. Try again.\n");
    }
}

// --------------------------------------------------- QUICKSORT -------------------------------------------------------------------------------------

// Ask which pivot to use
void choosePivot(void **A, int low, int high, int (*comparator)(void *, void *), int (*partition)(void **, int, int, int (*)(void *, void *)))
{
    int choice = 0;
    printf("\n\nWhich pivot do you want to use?\n\n\tPress 1 for first element.\n\tPress 2 for last element.\n\tPress 3 for random element.\n\tPress 4 for median element.\n\n\tYour choice: ");
    scanf("%d", &choice);
    printf(BLINK "\nSorting . . .\n" RESET);

    switch (choice)
    {
    case 1:
        quickSort(A, low, high, comparator, partition_pivot_first);
        break;

    case 2:
        quickSort(A, low, high, comparator, partition_pivot_last);
        break;

    case 3:
        quickSort(A, low, high, comparator, partition_pivot_random);
        break;

    case 4:
        quickSort(A, low, high, comparator, partition_pivot_median);
        break;

    default:
        printf("No valid choice selected.");
    }
}

// quicksort implementation
void quickSort(void **A, int low, int high, int (*comparator)(void *, void *), int (*partition)(void **A, int low, int high, int (*comparator)(void *, void *)))
{
    if (low < high)
    {
        int p = partition(A, low, high, comparator);
        quickSort(A, low, p - 1, comparator, partition);
        quickSort(A, p + 1, high, comparator, partition);
    }
}

// Partition using first element as pivot
int partition_pivot_first(void **A, int low, int high, int (*comparator)(void *, void *))
{
    int pivot = low;
    int i = low + 1;
    int j = high;
    while (i <= j)
    {
        if (comparator(A[i], A[pivot]) < 0)
            i++;
        else
        {
            if (comparator(A[j], A[pivot]) > 0)
                j--;
            else
            {
                swap(&A[i], &A[j]);
                i++;
                j--;
            }
        }
    }
    swap(&A[pivot], &A[j]);
    return j;
}

// Partition using last element as pivot
int partition_pivot_last(void **A, int low, int high, int (*comparator)(void *, void *))
{
    int pivot = high;
    int i = low - 1;
    for (int j = low; j <= high - 1; j++)
    {
        if (comparator(A[j], A[pivot]) < 0)
        {
            i++;
            swap(&A[i], &A[j]);
        }
    }
    swap(&A[i + 1], &A[high]);
    return (i + 1);
}

// Partition using randomic element as pivot
int partition_pivot_random(void **A, int low, int high, int (*comparator)(void *, void *))
{
    int pivot = low + rand() % (high - low + 1);
    swap(&A[pivot], &A[low]);
    return partition_pivot_first(A, low, high, comparator);
}

// Partition using median element as pivot
int partition_pivot_median(void **A, int low, int high, int (*comparator)(void *, void *))
{
    int pivot = (low + high) / 2;
    if (comparator(A[pivot], A[low]) < 0)
        swap(&A[pivot], &A[low]);
    if (comparator(A[high], A[low]) < 0)
        swap(&A[high], &A[low]);
    if (comparator(A[high], A[pivot]) < 0)
        swap(&A[high], &A[pivot]);
    swap(&A[pivot], &A[high - 1]);

    pivot = high - 1;
    return partition_pivot_first(A, low, high, comparator);
}

// --------------------------------------------------- BINARY INSERTION SORT-------------------------------------------------------------------------------

// Implementing Insertion Sort
void insertionSort(void **A, int low, int high, int (*comparator)(void *, void *))
{
    int i, index, j;

    for (i = (low + 1); i <= high; ++i)
    {
        j = i - 1;

        void *key = A[i];

        index = binarySearch(A, key, low, j, comparator);

        while (j >= index)
        {
            A[j + 1] = A[j];
            j--;
        }
        A[j + 1] = key;
    }
}

// Implementing Binary Search
int binarySearch(void **A, void *key, int low, int high, int (*comparator)(void *, void *))
{
    if (high <= low)
        return ((comparator(key, A[low])) > 0) ? (low + 1) : low;

    int mid = (low + high) / 2;

    if (comparator(key, A[mid]) == 0)
        return mid + 1;

    if (comparator(key, A[mid]) > 0)
        return binarySearch(A, key, mid + 1, high, comparator);

    return binarySearch(A, key, low, mid - 1, comparator);
}

// --------------------------------------------------- AUXILIARY FUNCTIONS------------------------------------------------------------------------------

// swaps two keys
void swap(void **a, void **b)
{
    void *tmp;
    tmp = *a;
    *a = *b;
    *b = tmp;
}