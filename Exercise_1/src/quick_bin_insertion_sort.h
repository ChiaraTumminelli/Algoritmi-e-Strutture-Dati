// Ask which algorithm to run
void quick_bin_insertion_sort(void **A, int low, int high, int (*comparator)(void *, void *), int (*partition)(void **, int, int, int (*)(void *, void *)));

// -------------------------------- QUICKSORT ---------------------------------------------------------------------------------------
// Ask which pivot to use
void choosePivot(void **A, int low, int high, int (*comparator)(void *, void *), int (*partition)(void **, int, int, int (*)(void *, void *)));

// quicksort implementation
void quickSort(void **A, int low, int high, int (*comparator)(void *, void *), int (*partition)(void **A, int low, int high, int (*comparator)(void *, void *)));

// Partition using last element as pivot
int partition_pivot_first(void **A, int low, int high, int (*comparator)(void *, void *));

// Partition using randomic element as pivot
int partition_pivot_last(void **A, int low, int high, int (*comparator)(void *, void *));

// Partition using randomic element as pivot
int partition_pivot_random(void **A, int low, int high, int (*comparator)(void *, void *));

// Partition using median element as pivot
int partition_pivot_median(void **A, int low, int high, int (*comparator)(void *, void *));

// -------------------------------- BINARY INSERTION SORT------------------------------------------------------------------------------
// Implementing insertionSort
void insertionSort(void **A, int low, int high, int (*comparator)(void *, void *));

// Implementing binarySearch
int binarySearch(void **A, void *item, int low, int high, int (*comparator)(void *, void *));

// -------------------------------- AUXILIARY FUNCTIONS ------------------------------------------------------------------------------
// Swaps two items
void swap(void **a, void **b);